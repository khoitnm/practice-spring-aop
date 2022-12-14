package org.tnmk.practicejson.pro01simple.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
public class SampleServiceParent {

  public void parentWelcome() {
    log.info("parentWelcome()");

  }

  public void parentOverloadMethod() {
    log.info("parentOverloadMethod()");

  }

  public void parentOverloadMethod(String a) {
    log.info("parentOverloadMethod({})", a);

  }

  public void parentOverloadMethod(String a, String... b) {
    log.info("parentOverloadMethod({}, {})", a, Arrays.toString(b));
  }
}
