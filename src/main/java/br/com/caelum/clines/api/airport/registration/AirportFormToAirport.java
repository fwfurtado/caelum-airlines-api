package br.com.caelum.clines.api.airport.registration;

import br.com.caelum.clines.domain.Airport;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static br.com.caelum.clines.api.airport.registration.AirportRegistrationController.*;

@Component
class AirportFormToAirport implements Converter<AirportForm, Airport> {
    @Override
    public Airport convert(AirportForm form) {
        return new Airport(form.getIdentifier(), form.getName());
    }
}
