package br.com.caelum.clines.api.airport.registration;

import br.com.caelum.clines.domain.Airport;

import java.util.Optional;

public interface AirportRegistrationRepository {
    void save(Airport airport);
    Optional<Airport> findByIdentifier(String code);
}
