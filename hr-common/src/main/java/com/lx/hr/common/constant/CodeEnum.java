package com.lx.hr.common.constant;

/**
 * 业务码
 *
 * @author zhufeifei
 * @date 2021/06/09 18:36
 **/
public enum CodeEnum {

    /**
     * 正常响应业务码
     */
    A000000("OK"),

    /**
     * Server Error
     */
    S000000("Server Error."),

    /**
     * Client Error
     */
    C000010("No Role Permission."),
    C000020("No Operation Permission."),
    C000030("Account Disabled."),

    /**
     * Token Error
     */
    C000040("Token Error");

    private final String message;

    CodeEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
