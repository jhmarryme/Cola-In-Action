package com.jhmarryme.cola.config.exception;

import com.jhmarryme.cola.dto.Response;

/**
 *
 * @author JiaHao Wang
 * @date 2021/8/18 12:25
 */
public interface ErrorResultBuilder {

    Response build(String errorCode, String errorMsg, String... params);
}
