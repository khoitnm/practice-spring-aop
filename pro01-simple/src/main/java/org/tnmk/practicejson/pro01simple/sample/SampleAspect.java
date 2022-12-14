package org.tnmk.practicejson.pro01simple.sample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class SampleAspect {

  @Around("execution(* org.tnmk.practicejson.pro01simple.sample.SampleServiceChild.childWelcome())")
  public Object aroundChildWelcome(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    return logAround(proceedingJoinPoint);
  }

  @Around("execution(* org.tnmk.practicejson.pro01simple.sample.SampleServiceChild.childOverloadMethod(..))")
  public Object aroundChildOverload(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    return logAround(proceedingJoinPoint);
  }

  @Around("execution(* org.tnmk.practicejson.pro01simple.sample.SampleServiceChild.parentWelcome())")
  public Object aroundParentWelcome(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    return logAround(proceedingJoinPoint);
  }

  @Around("execution(* org.tnmk.practicejson.pro01simple.sample.SampleServiceChild.parentOverloadMethod(..))")
  public Object aroundParentOverload(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    return logAround(proceedingJoinPoint);
  }

  private Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    try {
      log.info("----------------------------------------------------------");
      log.info("AOP: start...");
      Object result = proceedingJoinPoint.proceed();
      log.info("AOP: result success:" + result);
      return result;
    } catch (Exception ex) {
      log.error("AOP: result error:" + ex.getMessage());
      throw ex;
    }
  }
}
