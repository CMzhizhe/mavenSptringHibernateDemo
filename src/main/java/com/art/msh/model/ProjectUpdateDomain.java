package com.art.msh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <br>
 * 项目名称：gongzhi02 <br>
 * 类名称：ProjectUpdateDomain <br>
 * 类描述：<br>
 * 创建人：高小雄<br>
 * 创建时间：2016年9月29日 下午9:40:00 <br>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 *
 * @version V1.0
 */
@Entity
@Table(name = "projectupdate")
public class ProjectUpdateDomain implements Serializable {
    private Integer id;
    private Integer isForceUpdate;//是否需要强制更新
    private Integer isNeedUpdate;//是否需要更新
    private Integer newVersionCode;//新的版本
    private String newVersionName;//新版本名称
    private String updateAddress;//更新地址
    private String updateDetail;//更新内容
    private String updateFileName;//更新文件名称
    private boolean downTinker;//是否下载补丁 //false不下  true下载

    public ProjectUpdateDomain() {
        super();
    }
    @Id
    @Column(name = "cid", nullable = false, length = 36)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "isForceUpdate", nullable = false, length = 100)
    public Integer getIsForceUpdate() {
        return isForceUpdate;
    }

    public void setIsForceUpdate(Integer isForceUpdate) {
        this.isForceUpdate = isForceUpdate;
    }

    @Column(name = "isNeedUpdate", nullable = false, length = 100)
    public Integer getIsNeedUpdate() {
        return isNeedUpdate;
    }

    public void setIsNeedUpdate(Integer isNeedUpdate) {
        this.isNeedUpdate = isNeedUpdate;
    }

    @Column(name = "newVersionCode", nullable = false, length = 100)
    public Integer getNewVersionCode() {
        return newVersionCode;
    }

    public void setNewVersionCode(Integer newVersionCode) {
        this.newVersionCode = newVersionCode;
    }

    @Column(name = "newVersionName", nullable = false, length = 100)
    public String getNewVersionName() {
        return newVersionName;
    }

    public void setNewVersionName(String newVersionName) {
        this.newVersionName = newVersionName;
    }

    @Column(name = "updateAddress", nullable = false, length = 100)
    public String getUpdateAddress() {
        return updateAddress;
    }

    public void setUpdateAddress(String updateAddress) {
        this.updateAddress = updateAddress;
    }

    @Column(name = "updateDetail", nullable = false, length = 100)
    public String getUpdateDetail() {
        return updateDetail;
    }

    public void setUpdateDetail(String updateDetail) {
        this.updateDetail = updateDetail;
    }

    @Column(name = "updateFileName", nullable = false, length = 100)
    public String getUpdateFileName() {
        return updateFileName;
    }

    public void setUpdateFileName(String updateFileName) {
        this.updateFileName = updateFileName;
    }

    @Column(name = "downTinker", nullable = false, length = 100)
    public boolean isDownTinker() {
        return downTinker;
    }

    public void setDownTinker(boolean downTinker) {
        this.downTinker = downTinker;
    }
}
