package org.tnmk.practicejson.pro01simple.sample;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
public class SampleServiceChild extends SampleServiceParent {

  public void childWelcome() {
    log.info("childWelcome()");
  }

  public void childOverloadMethod(){
    log.info("childOverloadMethod()");

  }

  public void childOverloadMethod(String a){
    log.info("childOverloadMethod({})", a);

  }

  public void childOverloadMethod(String a, String... b) {
    log.info("childOverloadMethod({}, {})", a, Arrays.toString(b));
  }
}
