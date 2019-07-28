package br.com.ame.starwarsapi.external.swapi.response

import com.fasterxml.jackson.annotation.JsonProperty

data class SwapiPlanetResponse(
        @JsonProperty("films")
        var films: List<String>?
)