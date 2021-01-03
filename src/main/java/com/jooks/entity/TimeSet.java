package com.jooks.entity;

public class TimeSet {
    private Integer zhouCiDan;
    private Integer xinQiJi;
    private Integer jieCiDan;

    public TimeSet(Integer zhouCiDan, Integer xinQiJi, Integer jieCiDan) {
        this.zhouCiDan = zhouCiDan;
        this.xinQiJi = xinQiJi;
        this.jieCiDan = jieCiDan;
    }

    public Integer getZhouCiDan() {
        return zhouCiDan;
    }

    public void setZhouCiDan(Integer zhouCiDan) {
        this.zhouCiDan = zhouCiDan;
    }

    public Integer getXinQiJi() {
        return xinQiJi;
    }

    public void setXinQiJi(Integer xinQiJi) {
        this.xinQiJi = xinQiJi;
    }

    public Integer getJieCiDan() {
        return jieCiDan;
    }

    public void setJieCiDan(Integer jieCiDan) {
        this.jieCiDan = jieCiDan;
    }
}
