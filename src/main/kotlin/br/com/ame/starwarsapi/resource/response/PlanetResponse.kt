package br.com.ame.starwarsapi.resource.response

import com.fasterxml.jackson.annotation.JsonProperty

data class PlanetResponse(
        @JsonProperty("code")
        var code: String,

        @JsonProperty("name")
        var name: String,

        @JsonProperty("ground")
        var ground: String,

        @JsonProperty("weather")
        var weather: String,

        @JsonProperty("num_presence")
        var numPresence: Int
)