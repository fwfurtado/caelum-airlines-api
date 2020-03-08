import org.springframework.cloud.contract.spec.Contract

def header_version = 'application/vnd.caelum.clines.v1+json'
def airport_uri = '/airports'
[
        Contract.make {

            name('should post a empty airport')

            request {
                urlPath airport_uri

                method POST()

                headers {
                    contentType header_version
                }

                body(
                        name: "",
                        identifier: ""
                )
            }

            response {
                status BAD_REQUEST()

                body([
                        [field: "identifier", message: "must not be blank"],
                        [field: "name", message: "must not be blank"]
                ])
            }
        },

        Contract.make {
            name('should post a empty identifier')

            request {
                urlPath airport_uri

                method POST()

                headers {
                    contentType header_version
                }

                body(
                        "name": null,
                        "identifier": null
                )
            }

            response {
                status BAD_REQUEST()

                body([
                        [field: "identifier", message: "must not be blank"],
                        [field: "name", message: "must not be blank"]
                ])

            }
        }
]
