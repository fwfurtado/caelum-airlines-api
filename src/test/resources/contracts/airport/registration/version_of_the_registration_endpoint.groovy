package contracts.airport.registration

import org.springframework.cloud.contract.spec.Contract
import org.springframework.cloud.contract.spec.internal.MatchingTypeValue

Contract.make {
    request {
        urlPath '/airports'

        method POST()

        body(
                identifier: "CGH",
                name: "Congonhas Airport",
        )
    }

    response {
        status UNSUPPORTED_MEDIA_TYPE()

        headers {
            accept 'application/vnd.caelum.clines.v1+json'
        }
    }
}