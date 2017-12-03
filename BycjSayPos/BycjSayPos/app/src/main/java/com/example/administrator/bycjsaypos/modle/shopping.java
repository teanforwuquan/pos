package com.example.administrator.bycjsaypos.modle;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/28.
 */

public class shopping implements Serializable{
    private String Success;
    private String Message;
    private String StatusNo;
    private DataBeans Data;
    private String RecordCount;

    public shopping() {
        super();
    }

    public shopping(String success, String message, String statusNo, DataBeans data, String recordCount) {
        Success = success;
        Message = message;
        StatusNo = statusNo;
        Data = data;
        RecordCount = recordCount;
    }

    public String getSuccess() {
        return Success;
    }

    public void setSuccess(String success) {
        Success = success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStatusNo() {
        return StatusNo;
    }

    public void setStatusNo(String statusNo) {
        StatusNo = statusNo;
    }

    public DataBeans getData() {
        return Data;
    }

    public void setData(DataBeans data) {
        Data = data;
    }

    public String getRecordCount() {
        return RecordCount;
    }

    public void setRecordCount(String recordCount) {
        RecordCount = recordCount;
    }

    @Override
    public String toString() {
        return "shopping{" +
                "Success='" + Success + '\'' +
                ", Message='" + Message + '\'' +
                ", StatusNo='" + StatusNo + '\'' +
                ", Data=" + Data +
                ", RecordCount='" + RecordCount + '\'' +
                '}';
    }


}
