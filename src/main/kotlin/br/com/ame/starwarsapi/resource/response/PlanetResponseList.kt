package br.com.ame.starwarsapi.resource.response

import com.fasterxml.jackson.annotation.JsonProperty

data class PlanetResponseList (
        @JsonProperty("planets")
        var planets: List<PlanetResponse>
)