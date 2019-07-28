package br.com.ame.starwarsapi.exception.handler

import br.com.ame.starwarsapi.exception.HttpGenericException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*
import kotlin.streams.toList


@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException,
                                               headers: HttpHeaders,
                                               status: HttpStatus, request: WebRequest): ResponseEntity<Any> {

        val body = LinkedHashMap<String, Any>()
        body["timestamp"] = Date()
        body["status"] = status.value()

        //Get all errors
        val errors = ex.bindingResult
                .fieldErrors
                .stream()
                .map<String> { x -> x.defaultMessage }
                .toList()

        body["errors"] = errors

        return ResponseEntity(body, headers, status)

    }

    @ExceptionHandler(HttpGenericException::class)
    fun handleThrowedException(exception: HttpGenericException, request: WebRequest): ResponseEntity<Any> {

        return ResponseEntity(buildSimpleErrorMessage(exception.message!!), exception.statusCode())
    }

    @ExceptionHandler(Exception::class)
    fun handleUnexpectedExceptions(exception: Exception, request: WebRequest): ResponseEntity<Any> {

        return ResponseEntity(buildSimpleErrorMessage("Unexpected error. Please contact the system's administration."),
                HttpStatus.INTERNAL_SERVER_ERROR)
    }

    fun buildSimpleErrorMessage(message: String): LinkedHashMap<String, Any> {
        val body = LinkedHashMap<String, Any>()
        body["message"] = message
        return body
    }
}
