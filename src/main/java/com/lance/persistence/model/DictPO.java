package com.lance.persistence.model;

import java.util.Date;

public class DictPO {
    private String id;

    private String parentId;

    private String dictNo;

    private String dictName;

    private String dictType;

    private String orderNo;

    private String isSystem;

    private String isClose;

    private Date createTime;

    private Date checkTime;

    private String createUid;

    private String updateUid;

    private String checkUid;

    private String checkFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getDictNo() {
        return dictNo;
    }

    public void setDictNo(String dictNo) {
        this.dictNo = dictNo == null ? null : dictNo.trim();
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType == null ? null : dictType.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(String isSystem) {
        this.isSystem = isSystem == null ? null : isSystem.trim();
    }

    public String getIsClose() {
        return isClose;
    }

    public void setIsClose(String isClose) {
        this.isClose = isClose == null ? null : isClose.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCreateUid() {
        return createUid;
    }

    public void setCreateUid(String createUid) {
        this.createUid = createUid == null ? null : createUid.trim();
    }

    public String getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(String updateUid) {
        this.updateUid = updateUid == null ? null : updateUid.trim();
    }

    public String getCheckUid() {
        return checkUid;
    }

    public void setCheckUid(String checkUid) {
        this.checkUid = checkUid == null ? null : checkUid.trim();
    }

    public String getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag == null ? null : checkFlag.trim();
    }
}