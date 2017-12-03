package com.example.administrator.bycjsaypos.model;

import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 2017/11/15.
 */

public class user {
    private boolean Success;
    private String Message;
    private String StatusNo;
    private String Data;
    private String RecordCount;

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
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

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getRecordCount() {
        return RecordCount;
    }

    public void setRecordCount(String recordCount) {
        RecordCount = recordCount;
    }

    public user() {
    }

    @Override
    public String toString() {
        return "user{" +
                "Success=" + Success +
                ", Message='" + Message + '\'' +
                ", StatusNo='" + StatusNo + '\'' +
                ", Data='" + Data + '\'' +
                ", RecordCount='" + RecordCount + '\'' +
                '}';
    }
}
