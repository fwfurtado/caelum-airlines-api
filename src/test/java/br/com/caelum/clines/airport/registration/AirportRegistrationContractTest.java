package br.com.caelum.clines.airport.registration;

import br.com.caelum.clines.ClinesApplicationTest;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ClinesApplicationTest.class)
public class AirportRegistrationContractTest {

    @BeforeEach
    void setup() {
        RestAssuredMockMvc.standaloneSetup(new AirportRegistrationController());
    }
}
