package com.jhmarryme.cola.config.exception;

import com.jhmarryme.cola.config.i18n.I18nMessageUtil;
import com.jhmarryme.cola.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 *
 * @author JiaHao Wang
 * @date 2021/8/18 12:26
 */
@Slf4j
@Component
@ConditionalOnProperty(prefix = "cola.i18n", name = "enable", havingValue = "true")
public class I18nErrorResultBuilder implements ErrorResultBuilder{

    @Override
    public Response build(String errorCode, String errorMsg, String... params) {
        // 国际化
        try {
            errorMsg = I18nMessageUtil.getMsg(errorCode, params);
        } catch (Exception e) {
            log.warn("国际化异常消息失败" + e);
        }
        return Response.buildFailure(errorCode, errorMsg);
    }
}
