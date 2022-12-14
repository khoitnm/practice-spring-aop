package org.tnmk.practicejson.pro01simple.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tnmk.practicejson.pro01simple.testinfra.BaseIntegrationTest;

public class SampleServiceParentTest extends BaseIntegrationTest {
  @Autowired
  private SampleServiceChild sampleServiceChild;

  @Test
  void test_aop() {
    sampleServiceChild.childWelcome();
    sampleServiceChild.childOverloadMethod();
    sampleServiceChild.childOverloadMethod("a");
    sampleServiceChild.childOverloadMethod("a", "b1", "b2", "b3");

    sampleServiceChild.parentWelcome();
    sampleServiceChild.parentOverloadMethod();
    sampleServiceChild.parentOverloadMethod("a");
    sampleServiceChild.parentOverloadMethod("a", "b1", "b2", "b3");
  }
}
