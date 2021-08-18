package com.jhmarryme.cola.security.validate.code.sms;

import com.jhmarryme.cola.security.properties.SecurityProperties;
import com.jhmarryme.cola.security.validate.code.ValidateCodeGenerator;
import com.jhmarryme.cola.security.validate.code.base.ValidateCode;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 *
 * @author JiaHao Wang
 * @date 2020/12/3 19:23
 */
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 生成短信验证码
     * <br/>
     * @param request
     * @return com.jhmarryme.cola.security.validate.code.base.ValidateCode
     */
    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSmsCode().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSmsCode().getExpireIn());
    }
}
