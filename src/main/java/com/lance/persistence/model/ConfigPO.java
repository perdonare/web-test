package com.lance.persistence.model;

import java.util.Date;

public class ConfigPO {
    private String id;

    private String configKey;

    private String configType;

    private String configName;

    private String configValue;

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

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey == null ? null : configKey.trim();
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType == null ? null : configType.trim();
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
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