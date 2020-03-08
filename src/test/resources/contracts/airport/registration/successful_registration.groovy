import org.springframework.cloud.contract.spec.Contract

Contract.make {

    request {
        urlPath '/airports'
        method POST()

        headers {
            contentType 'application/vnd.caelum.clines.v1+json'
        }

        body(
                identifier: "CGH",
                name: "Congonhas Airport",
        )
    }

    response {
        status CREATED()

        headers {
            Location: "/airports/CGH"
        }
    }
}