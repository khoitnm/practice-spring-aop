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
    return logAround("aroundChildWelcome", proceedingJoinPoint);
  }

  @Around("execution(* org.tnmk.practicejson.pro01simple.sample.SampleServiceChild.childOverloadMethod(..))")
  public Object aroundChildOverload(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    return logAround("aroundChildOverload", proceedingJoinPoint);
  }

  // WRONG CONFIG: BEGIN ==================================================================
  // THIS WON'T WORK BECAUSE IT CANNOT FIND THOSE PARENT METHOD INSIDE CHILD CLASS
  @Around("execution(* org.tnmk.practicejson.pro01simple.sample.SampleServiceChild.parentWelcome())")
  public Object aroundParentWelcomeOnChildClass(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    return logAround("aroundParentWelcomeOnChildClass", proceedingJoinPoint);
  }

  @Around("execution(* org.tnmk.practicejson.pro01simple.sample.SampleServiceChild.parentOverloadMethod(..))")
  public Object aroundParentOverloadOnChildClass(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    return logAround("aroundParentOverloadOnChildClass", proceedingJoinPoint);
  }
  // WRONG CONFIG: END ==================================================================

  // Bellow is the way to fix the above wrong config: use the Parent class instead of Child class.
  // CORRECT CONFIG: BEGIN ==================================================================
  @Around("execution(* org.tnmk.practicejson.pro01simple.sample.SampleServiceParent.parentWelcome())")
  public Object aroundParentWelcomeOnParentClass(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    return logAround("aroundParentWelcomeOnParentClass", proceedingJoinPoint);
  }

  @Around("execution(* org.tnmk.practicejson.pro01simple.sample.SampleServiceParent.parentOverloadMethod(..))")
  public Object aroundParentOverloadOnParentClass(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    return logAround("aroundParentOverloadOnParentClass", proceedingJoinPoint);
  }
  // CORRECT CONFIG: END ==================================================================

  private Object logAround(String description, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    try {
      log.info("----------------------------------------------------------");
      log.info("AOP-{} start...", description);
      Object result = proceedingJoinPoint.proceed();
      log.info("AOP-{} result success: {}", description, result);
      return result;
    } catch (Exception ex) {
      log.error("AOP-{}: result error: {}", description, ex.getMessage());
      throw ex;
    }
  }
}
