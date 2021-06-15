package com.lx.hr.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lx.hr.common.constant.CodeEnum;
import lombok.Data;

/**
 * TODO
 *
 * @author zhufeifei
 * @date 2021/06/09 18:25
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespData<T> {

    protected CodeEnum code = CodeEnum.A000000;
    protected String message;
    protected T data;

    public static <T> RespData.RespDataBuilder<T> builder() {
        return new RespData.RespDataBuilder<>(new RespData<T>());
    }

    public static class RespDataBuilder<T> {
        private final RespData<T> respData;

        RespDataBuilder(RespData<T> respData) {
            this.respData = respData;
        }

        public RespDataPageable.RespDataBuilder<T> code(CodeEnum code) {
            this.respData.setCode(code);
            return this;
        }

        public RespDataPageable.RespDataBuilder<T> message(String message) {
            this.respData.setMessage(message);
            return this;
        }

        public RespDataPageable.RespDataBuilder<T> data(T data) {
            this.respData.setData(data);
            return this;
        }

        public RespData<T> build() {
            return this.respData;
        }


    }
}
