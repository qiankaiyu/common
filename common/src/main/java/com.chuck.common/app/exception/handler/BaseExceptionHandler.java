package com.chuck.common.app.exception.handler;

import com.chuck.base.client.dto.data.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
/**
 * BaseExceptionHandler
 *
 * @description
 * @author Chuck
 * @date 1/13/2022 2:36 PM
 */
@RestControllerAdvice
@Slf4j
public class BaseExceptionHandler {

  @ResponseBody
  @ExceptionHandler(HttpServerErrorException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public BaseResponse<Void> onHttpServerErrorException(HttpServerErrorException e) {
    log.error(e.getMessage());
    return BaseResponse.error(
        "第三方服务内部异常：" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
  }

  @ResponseBody
  @ExceptionHandler(HttpClientErrorException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public BaseResponse<Void> onHttpClientErrorException(HttpClientErrorException e) {
    log.error(e.getMessage());
    return BaseResponse.error(
        "第三方服务客户端异常：" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
  }
}
