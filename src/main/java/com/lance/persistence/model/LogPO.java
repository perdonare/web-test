package com.lance.persistence.model;

import java.util.Date;

public class LogPO {
    private String id;

    private String logType;

    private String operationAccount;

    private String aperationUsername;

    private String operationPath;

    private Date operationTime;

    private String operationIp;

    private String logContent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    public String getOperationAccount() {
        return operationAccount;
    }

    public void setOperationAccount(String operationAccount) {
        this.operationAccount = operationAccount == null ? null : operationAccount.trim();
    }

    public String getAperationUsername() {
        return aperationUsername;
    }

    public void setAperationUsername(String aperationUsername) {
        this.aperationUsername = aperationUsername == null ? null : aperationUsername.trim();
    }

    public String getOperationPath() {
        return operationPath;
    }

    public void setOperationPath(String operationPath) {
        this.operationPath = operationPath == null ? null : operationPath.trim();
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperationIp() {
        return operationIp;
    }

    public void setOperationIp(String operationIp) {
        this.operationIp = operationIp == null ? null : operationIp.trim();
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }
}