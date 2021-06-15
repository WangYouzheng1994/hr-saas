package com.lx.hr.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author zhufeifei
 * @date 2021/06/09 18:25
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespDataPageable<T> extends RespData<T> {

    protected long total;
    protected long pages;

    public static <T> RespDataPageable.RespDataPageableBuilder<T> builder() {
        return new RespDataPageable.RespDataPageableBuilder<>(new RespDataPageable<>());
    }

    public static class RespDataPageableBuilder<T> extends RespData.RespDataBuilder<T> {

        RespDataPageableBuilder(RespDataPageable<T> respDataPageable) {
            super(respDataPageable);
        }

        public RespDataPageable.RespDataPageableBuilder<T> total(long total) {
            ((RespDataPageable<T>) this.build()).setTotal(total);
            return this;
        }

        public RespDataPageable.RespDataPageableBuilder<T> pages(long pages) {
            ((RespDataPageable<T>) this.build()).setPages(pages);
            return this;
        }

    }
}
