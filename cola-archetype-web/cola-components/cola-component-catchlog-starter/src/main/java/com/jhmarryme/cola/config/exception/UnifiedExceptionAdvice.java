package com.jhmarryme.cola.config.exception;

import com.jhmarryme.cola.config.i18n.I18nMessageUtil;
import com.jhmarryme.cola.dto.MultiResponse;
import com.jhmarryme.cola.exception.BizException;
import com.jhmarryme.cola.exception.SysException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * 统一异常处理切面, 默认不启用
 * <p>如果需要开启, 在配置文件中指定cola.exception.enable=true
 * @author JiaHao Wang
 * @date 2021/3/8 16:19
 */
@Slf4j
@ConditionalOnProperty(prefix = "cola.exception", name = "enable", havingValue = "true")
@RestControllerAdvice
public class UnifiedExceptionAdvice {

    @Autowired
    private ErrorResultBuilder resultBuilder;

    @ExceptionHandler(BizException.class)
    public Object handleBizException(BizException e) {
        log.error("统一异常处理(业务异常):" + e);
        return resultBuilder.build(e.getErrCode(), e.getMessage(), e.getParams());
    }

    @ExceptionHandler(SysException.class)
    public Object handleSysException(BizException e) {
        log.error("统一异常处理(系统异常):" + e);
        return resultBuilder.build(e.getErrCode(), e.getMessage(), e.getParams());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("统一异常处理(参数校验异常):" + e);
        List<String> list = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach(x -> list.add(x.getDefaultMessage()));
        return MultiResponse.buildFailure(
                CatchLogErrorEnum.PARAM_VERIFICATION_ERROR.getErrorCode(),
                I18nMessageUtil.getMsg("PARAM_VERIFICATION_ERROR"),
                list);
    }

    @ExceptionHandler(Exception.class)
    public Object error(Exception e) {
        log.error("统一异常处理(未知异常):" + e);
        return resultBuilder.build(CatchLogErrorEnum.UNKNOWN_ERROR.getErrorCode(),
                CatchLogErrorEnum.UNKNOWN_ERROR.getErrorMsg());
    }

}
