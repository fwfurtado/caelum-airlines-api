package br.com.caelum.clines.api.airport.registration;

import br.com.caelum.clines.api.ContractTest;
import br.com.caelum.clines.domain.Airport;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ReflectionUtils;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ContractTest
public class AirportRegistrationContractTest  {

    @MockBean
    private AirportRegistrationRepository repository;

    @MockBean
    private AirportFormToAirport converter;

    @BeforeEach
    void setup() {
        when(repository.findByIdentifier("CGH")).thenReturn(Optional.empty());
        when(repository.findByIdentifier("GRU")).thenReturn(Optional.of(new Airport("GRU", "Gov. André Franco Montoro International Airport")));

        Airport cgh = new Airport("CGH", "Congonhas Airport");
        ReflectionTestUtils.setField(cgh, "id", 1L);

        when(converter.convert(any(AirportRegistrationController.AirportForm.class))).thenReturn(cgh);
    }
}
