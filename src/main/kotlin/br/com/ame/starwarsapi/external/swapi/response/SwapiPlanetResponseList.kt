package br.com.ame.starwarsapi.external.swapi.response

import com.fasterxml.jackson.annotation.JsonProperty

data class SwapiPlanetResponseList(
        @JsonProperty("results")
        var result: List<SwapiPlanetResponse>?
)