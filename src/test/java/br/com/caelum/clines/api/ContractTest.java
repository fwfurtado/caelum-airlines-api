package br.com.caelum.clines.api;

import br.com.caelum.clines.ClinesApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;

import javax.transaction.Transactional;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.springframework.test.context.TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ActiveProfiles("contract-test")
@SpringBootTest(classes = ClinesApplication.class)
@TestExecutionListeners(mergeMode = MERGE_WITH_DEFAULTS, listeners = ContractTestListener.class)
@Transactional
@AutoConfigureTestEntityManager
@Inherited
public @interface ContractTest {
}
