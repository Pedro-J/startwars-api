package br.com.ame.starwarsapi.exception

import org.springframework.http.HttpStatus

class BadRequestException(message: String) : HttpGenericException(message) {

    override fun statusCode(): HttpStatus {
        return HttpStatus.BAD_REQUEST
    }

}
