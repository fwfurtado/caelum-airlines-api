package br.com.caelum.clines.api.airport.registration;

import br.com.caelum.clines.exceptions.AlreadyExistsException;
import org.springframework.stereotype.Service;

import static br.com.caelum.clines.api.airport.registration.AirportRegistrationController.*;

@Service
class AirportRegistrationService {
    private final AirportFormToAirport converter;
    private final AirportRegistrationRepository repository;

    AirportRegistrationService(AirportFormToAirport converter, AirportRegistrationRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    public Long register(AirportForm form) {
        String identifier = form.getIdentifier();

        repository.findByIdentifier(identifier).ifPresent(airport -> {
            throw new AlreadyExistsException("Already exist airport with identifier " + identifier);
        });

        var airport = converter.convert(form);

        repository.save(airport);

        return airport.getId();
    }
}
