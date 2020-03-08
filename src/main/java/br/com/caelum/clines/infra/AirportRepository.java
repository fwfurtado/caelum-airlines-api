package br.com.caelum.clines.infra;

import br.com.caelum.clines.api.airport.registration.AirportRegistrationRepository;
import br.com.caelum.clines.domain.Airport;
import org.springframework.data.repository.Repository;

interface AirportRepository extends Repository<Airport, Long>, AirportRegistrationRepository {
}
