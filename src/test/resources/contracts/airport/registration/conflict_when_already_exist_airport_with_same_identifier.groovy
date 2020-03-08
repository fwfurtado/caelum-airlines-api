import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        urlPath '/airports'
        method POST()
        headers {
            contentType 'application/vnd.caelum.clines.v1+json'
        }

        body(
                identifier: "GRU",
                name: "International Airport",
        )
    }

    response {
        status CONFLICT()

        body([
                [message: "Already exist airport with identifier GRU"]
        ])
    }
}