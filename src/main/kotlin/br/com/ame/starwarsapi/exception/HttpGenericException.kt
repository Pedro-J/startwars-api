package br.com.ame.starwarsapi.exception

import org.springframework.http.HttpStatus

abstract class HttpGenericException(message: String) : RuntimeException(message) {

    abstract fun statusCode(): HttpStatus
}
