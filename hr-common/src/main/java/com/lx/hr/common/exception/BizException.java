package com.lx.hr.common.exception;

import com.lx.hr.common.constant.CodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author zhufeifei
 * @date 2021/06/15 12:55
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException {

    private CodeEnum code;
    private boolean useCodeMsg = false;

    public BizException() {
        super();
        this.code = CodeEnum.S000000;
    }

    public BizException(CodeEnum code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(CodeEnum code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BizException(CodeEnum code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public BizException useCodeMsg(boolean useCodeMsg) {
        this.useCodeMsg = useCodeMsg;
        return this;
    }

    @Override
    public String getMessage() {
        String msg = super.getMessage();
        if ("".equals(msg) || this.useCodeMsg) {
            return code.getMessage();
        }
        return msg;
    }
}
