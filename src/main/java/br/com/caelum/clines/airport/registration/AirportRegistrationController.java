package br.com.caelum.clines.airport.registration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static br.com.caelum.clines.infra.Versioning.AIRPORT_V1;
import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("airports")
class AirportRegistrationController {

    @PostMapping(consumes = AIRPORT_V1)
    ResponseEntity<?> register(@RequestBody AirportForm form) {
        var uri = URI.create("/airports/" + form.getIdentifier());

        return created(uri).build();
    }

    static class AirportForm {
        private String identifier;
        private String name;

        AirportForm() {
        }

        public AirportForm(String identifier, String name) {
            this.identifier = identifier;
            this.name = name;
        }

        public String getIdentifier() {
            return identifier;
        }

        public String getName() {
            return name;
        }
    }
}
