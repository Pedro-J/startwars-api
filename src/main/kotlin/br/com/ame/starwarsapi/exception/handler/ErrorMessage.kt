package br.com.ame.starwarsapi.exception.handler

import com.fasterxml.jackson.annotation.JsonProperty

data class ErrorMessage(@JsonProperty("message") var message: String)