package br.com.ame.starwarsapi.exception

import org.springframework.http.HttpStatus

class InternalServerErrorException(message: String): HttpGenericException(message) {

    override fun statusCode(): HttpStatus {
        return HttpStatus.INTERNAL_SERVER_ERROR
    }

}