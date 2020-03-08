package br.com.caelum.clines.api;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.web.context.WebApplicationContext;

public class ContractTestListener implements TestExecutionListener {

    @Autowired
    private WebApplicationContext context;


    @BeforeTestClass
    public void beforeTestClass(TestContext testContext) throws Exception {
        autowireBy(testContext);

        RestAssuredMockMvc.webAppContextSetup(context);
    }

    private void autowireBy(TestContext testContext) {
        testContext.getApplicationContext().getAutowireCapableBeanFactory().autowireBean(this);
    }
}
