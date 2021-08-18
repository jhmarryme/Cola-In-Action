package com.jhmarryme.cola.config.exception;

import com.jhmarryme.cola.dto.Response;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

/**
 *
 * @author JiaHao Wang
 * @date 2021/8/18 12:26
 */
@Component
@ConditionalOnMissingBean(I18nErrorResultBuilder.class)
public class NormalErrorResultBuilder implements ErrorResultBuilder {
    @Override
    public Response build(String errorCode, String errorMsg, String... params) {
        return Response.buildFailure(errorCode, errorMsg);
    }
}
