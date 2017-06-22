package com.heitian.ssm.model;

import java.util.List;

public class Status {
    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List getDatas() {
        return datas;
    }

    public void setDatas(List datas) {
        this.datas = datas;
    }

    //执行的操作类型，登录，添加 等操作
    private int ret;
    //成功（0） or 失败（1,2,3.....）
    private int status_code;
    //对错误类型的描述
    private String description ;
    private List datas;

}
