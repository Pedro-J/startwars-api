package br.com.ame.starwarsapi.resource.request

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class PlanetRequest(
        @JsonProperty("name")
        @get:NotBlank(message = "The field name cannot be empty")
        var name: String? = null,

        @JsonProperty("ground")
        @get:NotBlank(message = "The field ground cannot be empty")
        var ground: String? = null,

        @JsonProperty("weather")
        @get:NotNull(message = "The field weather cannot be empty")
        var weather: String? = null
)