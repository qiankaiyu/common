package com.chuck.common.app.exception.handler;

import com.chuck.base.client.dto.data.response.BaseResponse;
import com.querydsl.core.NonUniqueResultException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * DataExceptionHandler
 *
 * @description
 * @author Chuck
 * @date 1/13/2022 2:38 PM
 */
@RestControllerAdvice
@Slf4j
public class DataExceptionHandler {

  /**
   * TO REMOVE
   * @param e
   * @return
   */
  @ResponseBody
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(NonUniqueResultException.class)
  public BaseResponse<Void> onBaseException(NonUniqueResultException e) {
    log.error(e.getMessage());
    return BaseResponse.error(
        "数据异常，返回多条数据：" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
  }

  @ResponseBody
  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse<Void> onIllegalArgumentException(IllegalArgumentException e) {
    log.error(e.getMessage());
    return BaseResponse.error(e.getMessage(), HttpStatus.BAD_REQUEST.value());
  }

  @ResponseBody
  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse<Void> onNoSuchElementException(NoSuchElementException e) {
    log.error(e.getMessage());
    return BaseResponse.error(e.getMessage(), HttpStatus.BAD_REQUEST.value());
  }

  @ResponseBody
  @ExceptionHandler(PropertyReferenceException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse<Void> onPropertyReferenceException(PropertyReferenceException e) {
    log.error(e.getMessage());
    return BaseResponse.error(e.getMessage(), HttpStatus.BAD_REQUEST.value());
  }

  @ResponseBody
  @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse<Void> onSQLIntegrityConstraintViolationException(
      SQLIntegrityConstraintViolationException e) {
    log.error(e.getMessage());
    return BaseResponse.error(e.getMessage(), HttpStatus.BAD_REQUEST.value());
  }
}
