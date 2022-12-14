package org.tnmk.practicejson.pro01simple.testinfra;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest()
//@AutoConfigureMockMvc // Without this, we cannot inject MockMvc
public class BaseIntegrationTest {
}
