package com.art.msh.base;

import org.hibernate.Query;

import java.util.List;



public interface BaseDao<T> {
	/**
	 * 保存数据
	 * @param entity
	 */
	void save(T entity);
	/**
	 * 删除数据
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 更新数据
	 * @param entity
	 */
	void update(T entity);
	/**
	 * 按Id查询
	 * @param id
	 * @return
	 */
	T getById(Long id);
	/**
	 * 按Id查询
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	/**
	 * 查询所有
	 * @return
	 */
	List<T>findAll();
	
	/**
	 * 
	* 根据参数查询出数据<br> 
	* 创建人： 高小雄<br> 
	* 创建时间： 2017年1月29日 上午10:38:23  
	* Copyright (c)2017 <br> 
	* @param hql  hql语句
	* @param args 参数
	* @return
	 */
	 List<T> findEntity(String hql, Object[] args);
	 
	 /**
	 * 更具sql语句来执行查询<br> 
	 * 创建人： 高小雄<br> 
	 * 创建时间： 2017年2月8日 下午4:58:22  
	 * Copyright (c)2017 <br> 
	 * @param sql sql语句
	 * @param args 参数
	 * @return
	  */
	 List<Object[]> findEntitysql(String sql, Object[] args);
	 
	 /**
	 * 更具sql语句来执行查询<br> 
	 * 创建人： 高小雄<br> 
	 * 创建时间： 2017年2月8日 下午5:20:53  
	 * Copyright (c)2017 <br> 
	 * @param sql
	 * @param args
	 * @return
	  */
	 List<Object> findEntitysql(Object[] args, String sql);


	/**
	 * 方法描述:hql语句查询
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 **/
	List<T> find(String hql);

	/**
	 * 方法描述:hql语句查询
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 **/
	List findSQL(String hql, Class T);


	/**
	 * 方法描述:查询集合
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 *  @param hql hql语句
	 * @param param List集合
	 **/
	List<T> find(String hql, List<Object> param);

	/**
	 * 方法描述:获取某一个对象
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 * @param hql hql语句
	 * @param param 数组
	 **/
	T get(String hql, Object[] param);

	/**
	 * 修改hql语句 select cout(*) from 对象
	 * @param hql 语句
	 * @return 返回新的hql语句
	 */
	String getCountHql(String hql);

	/**
	 * 执行sql<br>
	 * 创建人： 高小雄<br>
	 * 创建时间： 2017年2月7日 下午9:53:18
	 * Copyright (c)2017 <br>
	 * @param sql
	 * @param args
	 * @return
	 */
	Query setParamtersql(String sql, Object[] args);

	/**
	 * 执行hql语句
	 *
	 * @param hql
	 *            语句
	 * @param args
	 *            一组参数 or 无参数null
	 * @return 返回 Query对象
	 */
	Query setParamterQuery(String hql, Object[] args);

	/**
	 * 方法描述:获取数量
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 * @param hql hql语句
	 * @param param List集合
	 **/
	Long count(String hql, List<Object> param);

	/**
	 * 方法描述:更新
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 * @param hql hql语句
	 **/
	Integer executeUpdateHql(String hql);

	/**
	 * 方法描述:更新
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 * @param hql hql语句
	 * @param param 数组
	 **/
	Integer executeUpdateHql(String hql, Object[] param);

	/**
	 * 方法描述:更新
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 * @param hql hql语句
	 * @param param List数组
	 **/
	Integer executeUpdateHql(String hql, List<Object> param);

	/**
	 * 方法描述:页码查询
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 *  @param hql  hql语句
	 *  @param param 参数，数组
	 *  @param page 页码
	 *  @param rows 需要多少页
	 **/
	List<T> findPageHql(String hql, Object[] param, Integer page, Integer rows);

	/**
	 * 方法描述:页码查询
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 *  @param hql  hql语句
	 *  @param param 参数，集合
	 *  @param page 页码
	 *  @param rows 需要多少页
	 **/
	List<T> findPageHql(String hql, List<Object> param, Integer page, Integer rows);

	/**
	 * 方法描述:sql 分页查询
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 * @param hql sql语句
	 * @param args 数组
	 * @param pageNo 第几页
	 * @param pageSize 返回数量
	 **/
	Pagination <T> findPaginationSql(String hql, Object[] args,Integer pageNo, Integer pageSize);
}
