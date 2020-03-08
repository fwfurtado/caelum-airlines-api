package br.com.caelum.clines.api.airport.registration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.net.URI;

import static br.com.caelum.clines.api.Versioning.AIRPORT_V1;
import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("airports")
class AirportRegistrationController {

    private final AirportRegistrationService service;

    AirportRegistrationController(AirportRegistrationService service) {
        this.service = service;
    }

    @PostMapping(consumes = AIRPORT_V1)
    ResponseEntity<?> register(@RequestBody @Valid AirportForm form) {
        var id = service.register(form);

        var uri = URI.create("/airports/" + id);

        return created(uri).build();
    }

    static class AirportForm {

        @NotBlank
        @Size(max = 4)
        private String identifier;

        @NotBlank
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
