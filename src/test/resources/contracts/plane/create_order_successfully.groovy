package provision

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description '''
Represents get app config


'''

    request {
        url $(consumer("/plane/orders"))
        method POST()
        body([
                price: anyNumber(),
                content: anyNonBlankString()
        ])
    }

    response {
        status CREATED()
        headers {
            contentType applicationJson()
        }
    }
}