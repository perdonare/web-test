/************************************************************************************
 * Copyright (c) 2015 © Bestpay Co., Ltd.  All Rights Reserved.
 * This software is published under the terms of the Bestpay.
 * Software License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 *
 * File name:      ResponseModel.java
 * Create on:      2015/8/3 0003 8:56
 * Author :        袁其亮
 *
 * ChangeList
 * ----------------------------------------------------------------------------------
 * Date									Editor						ChangeReasons
 * 2015/8/3 0003 8:56               	    袁其亮					    Create
 ************************************************************************************/
package com.lance.controller.bo;

import java.util.List;

/**
 * <b>DESCRIPTION:</b><br/>
 * <b>Create on:</b>2015/8/3 0003<br/>
 *
 * @author 袁其亮
 */
public class ResponseModel<T> {
    private boolean success;
    private int totalRows;
    private int curPage;
    private List<T> result;

    public ResponseModel(){
        this.success = false;
    }

    public ResponseModel(List<T> result){
        this.result = result;
        this.success = true;
        this.totalRows = result.size();
        this.curPage = 1;
    }

    public ResponseModel(List<T> result,int totalRows,int curPage){
        this.result = result;
        this.totalRows = totalRows;
        this.curPage = curPage;
        this.success = true;

    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
