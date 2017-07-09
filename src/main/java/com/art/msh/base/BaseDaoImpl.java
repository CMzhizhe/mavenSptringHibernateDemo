package com.art.msh.base;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

@Transactional
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz;

	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass(); // 得到泛型父类的类型，得到的是泛型话的类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个
	}
	
	protected SessionFactory getSessionFactory(){
		return sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession(); // 可以利用外面的数据库连接，本来是可以用openSession的，但每次都开启新的。不是很好
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void delete(Long id) {
		Object obj = getById(id);
		if (obj != null) {
			getSession().delete(obj);
		}
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public T getById(Long id) {
		if (id != null) {
			return (T) getSession().get(clazz, id);
		} else {
			return null;
		}

	}

	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		} else {
			return getSession().createQuery(//
					"FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")//
					.setParameterList("ids", ids)//
					.list();
		}
	}

	@Override
	public List<T> findAll() {
		return getSession().createQuery("FROM " + clazz.getSimpleName()).list();

	}

	/**
	 * 
	*  hql执行查询<br>  
	* 创建人：高小雄 <br> 
	* 创建时间： 2017年2月8日 下午4:56:54   
	* @param hql hql语句
	* @param args 参数
	* @return
	 */
	@Override
	public List<T> findEntity(String hql, Object[] args) {
		List<T> list = setParamterQuery(hql,args).list();
		return list;
	}
	
	/**
	 * 
	* sql语句执行查询<br> 
	* 创建人： 高小雄<br> 
	* 创建时间： 2017年2月8日 下午4:57:40  
	* Copyright (c)2017 <br> 
	* @param sql  sql语句
	* @param args
	* @return
	 */
	public List<Object[]> findEntitysql(String sql, Object[] args) {
		 List<Object[]> list =setParamtersql(sql,args).list();
		return list;
	}

	/**
	 * 方法描述:页码查询
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 *  @param hql  hql语句
	 *  @param param 参数，数组
	 *  @param page 页码
	 *  @param rows 需要多少页
	 **/
	public List<T> findPageHql(String hql, Object[] param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 20;
		}
		Query q = getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	/**
	 * 方法描述:页码查询
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 *  @param hql  hql语句
	 *  @param param 参数，集合
	 *  @param page 页码
	 *  @param rows 需要多少页
	 **/
	public List<T> findPageHql(String hql, List<Object> param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 20;
		}
		Query q = getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	/**
	 * 方法描述:sql 分页查询
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 * @param sql sql语句
	 * @param args 数组
	 * @param pageNo 第几页
	 * @param pageSize 返回数量
	 **/
	public Pagination <T> findPaginationSql(String sql, Object[] args,Integer pageNo, Integer pageSize) {
		if (pageNo == null || pageNo < 1) {
			pageNo = 1;
		}
		if (pageSize == null || pageSize < 1) {
			pageSize = 20;
		}
		// 查询总条数
		Long count = (Long) this.setParamterQuery(getCountHql(sql), args).uniqueResult();
		int pageCount = (count.intValue() + pageSize - 1) / pageSize;    //总页数

		/**
		 * 下一页
		 * @return
		 */
		if (pageNo >= pageCount) {
			pageNo = pageCount;
		}else if(pageNo<=1){
			pageNo = 1;
		}

		// 分页查询
		Query query = setParamterQuery(sql, args).setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageNo*pageSize);
		// 把值存进去对象中
		Pagination<T> pager = new Pagination<T>();
		pager.setPageSize(pageSize);
		pager.setPageSize(pageSize);
		pager.setList(query.list());
		pager.setTotalRecord(count);

		return pager;
	}





	/**
	 * 方法描述:hql语句查询
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 **/
	public List<T> find(String hql) {
		return this.getSession().createQuery(hql).list();
	}

	/**
	 * 方法描述:hql语句查询
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 **/
	public List findSQL(String hql, Class T) {
		return this.getSession().createSQLQuery(hql).addEntity(T).list();
	}
	
	/**
	 * 
	* sql语句执行查询<br> 
	* 创建人： 高小雄<br> 
	* 创建时间： 2017年2月8日 下午4:57:40  
	* Copyright (c)2017 <br> 
	* @param sql  sql语句
	* @param args
	* @return
	 */
	public List<Object> findEntitysql(Object[] args,String sql) {
		 List<Object> list =setParamtersql(sql,args).list();
		return list;
	}


	/**
	 * 执行hql语句
	 * 
	 * @param hql
	 *            语句
	 * @param args
	 *            一组参数 or 无参数null
	 * @return 返回 Query对象
	 */
	public Query setParamterQuery(String hql, Object[] args) {
		Query query = this.getSession().createQuery(hql);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		return query;
	}
	
	/**
	* 执行sql<br> 
	* 创建人： 高小雄<br> 
	* 创建时间： 2017年2月7日 下午9:53:18  
	* Copyright (c)2017 <br> 
	* @param sql
	* @param args
	* @return
	 */
	public  Query setParamtersql(String sql, Object[] args) {
		Query query = this.getSession().createSQLQuery(sql);
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				if(args[i] instanceof String )
					query.setParameter(i, args[i].toString());
				else if(args[i] instanceof Integer)
					query.setParameter(i, (Integer)args[i]);
			}
		}
		return query;
	}

	/**
	 * 修改hql语句 select cout(*) from 对象
	 * @param hql 语句
	 * @return 返回新的hql语句
	 */
	public String getCountHql(String hql) {
		String s;
		try {
			s = hql.substring(0, hql.indexOf("from"));
		} catch (Exception e) {
			s = hql.substring(0, hql.indexOf("FROM"));
		}
		if (s == null || s.trim().equals("")) {
			hql = "select count(*)" + hql;
		} else {
			hql = hql.replace(s, "select count(*)");
		}
		return hql;
	}

	/**
	 * 方法描述:查询集合
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 *  @param hql hql语句
	 * @param param 数组
	 **/
	public List<T> find(String hql, Object[] param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	/**
	 * 方法描述:查询集合
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 *  @param hql hql语句
	 * @param param List集合
	 **/
	public List<T> find(String hql, List<Object> param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	/**
	 * 方法描述:获取某一个对象
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 * @param hql hql语句
	 * @param param 数组
	 **/
	public T get(String hql, Object[] param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}


	/**
	 * 方法描述:获取数量
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 * @param hql hql语句
	 * @param param List集合
	 **/
	public Long count(String hql, List<Object> param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();
	}

	/**
	 * 方法描述:更新
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 * @param hql hql语句
	 **/
	public Integer executeUpdateHql(String hql) {
		return this.getSession().createQuery(hql).executeUpdate();
	}

	/**
	 * 方法描述:更新
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 * @param hql hql语句
	 * @param param 数组
	 **/
	public Integer executeUpdateHql(String hql, Object[] param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.executeUpdate();
	}

	/**
	 * 方法描述:更新
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 * @param hql hql语句
	 * @param param List数组
	 **/
	public Integer executeUpdateHql(String hql, List<Object> param) {
		Query q = this.getSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();
	}
	
}
