package com.lucio.appframework.base;

/**
 * 所有实体类的基类
 * 安装Parcelable插件一键实现Parcelable
 */
public class BaseBean {

    private String reCode;
    private String reMsg;


    public String getReCode() {
        return reCode;
    }

    public void setReCode(String reCode) {
        this.reCode = reCode;
    }

    public String getReMsg() {
        return reMsg;
    }

    public void setReMsg(String reMsg) {
        this.reMsg = reMsg;
    }


}
