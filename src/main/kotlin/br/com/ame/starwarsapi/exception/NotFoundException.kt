package br.com.ame.starwarsapi.exception

import org.springframework.http.HttpStatus

class NotFoundException(message: String): HttpGenericException(message) {

    override fun statusCode(): HttpStatus {
        return HttpStatus.NOT_FOUND
    }
}