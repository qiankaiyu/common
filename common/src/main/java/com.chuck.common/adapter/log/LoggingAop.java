package com.chuck.common.adapter.log;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Slf4j
public class LoggingAop {

  @Autowired private ObjectMapper objectMapper;

  @Around("execution(* com.mmc..*Controller.*(..))")
  public Object profileControllerMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

    String className = methodSignature.getDeclaringType().getSimpleName();
    String methodName = methodSignature.getName();
    Object[] args = proceedingJoinPoint.getArgs();

    log.info(String.format("In Controller Method: %s#%s，Parameters：", className, methodName));
    logEachParameter(args);

    final StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    Object result = proceedingJoinPoint.proceed();
    stopWatch.stop();

    log.info(
        "Execution time of "
            + className
            + "#"
            + methodName
            + " "
            + ":: "
            + stopWatch.getTotalTimeMillis()
            + " ms");

    log.info(
        String.format(
            "Out Controller Method: %s#%s，Return：%s",
            className, methodName, objectMapper.writeValueAsString(result)));

    return result;
  }

  /**
   * 获取请求参数方式二：直接序列化args，但是Jackson依赖不支持，需要其他序列化Jar实现。或者依次log
   *
   * @return
   */
  private void logEachParameter(Object[] args) {
    for (Object arg : args) {
      log.info(String.format("#####Parameter：%s", arg));
    }
  }

  /**
   * 获取请求参数方式一：取巧方式，不推荐
   *
   * @return
   */
  private String parameterFromContext() {
    RequestAttributes ra = RequestContextHolder.getRequestAttributes();
    ServletRequestAttributes sra = (ServletRequestAttributes) ra;
    HttpServletRequest request = sra.getRequest();
    //        String url = request.getRequestURL().toString();
    //        String method = request.getMethod();
    //        String uri = request.getRequestURI();
    String queryString = request.getQueryString();
    return queryString;
  }
}
