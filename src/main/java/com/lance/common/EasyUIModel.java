package com.lance.common;

import java.util.List;

/**
 * Created by perdonare on 2015/5/4.
 */
public class EasyUIModel<T> {
    private static final long serialVersionUID = 7533733366938078014L;

    /**
     * 总记录数
     */
    private long total;
    /**
     * 数据集
     */
    private List<T> rows;

    public EasyUIModel() {
    }

    public EasyUIModel(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "EasyUIGridModel{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
