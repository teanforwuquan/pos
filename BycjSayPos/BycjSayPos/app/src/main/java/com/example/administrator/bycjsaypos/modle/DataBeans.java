package com.example.administrator.bycjsaypos.modle;

import java.util.List;
/**
 * Created by Administrator on 2017/11/28.
 */
 public  class DataBeans {
    private String total ;
    private List<RowsBeans> rows;

    public DataBeans() {
        super();
    }

    public DataBeans(String total, List<RowsBeans> rows) {
        this.total = total;
        this.rows = rows;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<RowsBeans> getRows() {
        return rows;
    }

    public void setRows(List<RowsBeans> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "DataBeans{" +
                "total='" + total + '\'' +
                ", rows=" + rows +
                '}';
    }
}
