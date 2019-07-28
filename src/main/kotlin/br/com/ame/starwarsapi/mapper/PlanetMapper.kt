package br.com.ame.starwarsapi.mapper

import br.com.ame.starwarsapi.entity.PlanetEntity
import br.com.ame.starwarsapi.resource.request.PlanetRequest
import br.com.ame.starwarsapi.resource.response.PlanetResponse

fun PlanetRequest.toEntity() = PlanetEntity(
        code = "",
        name = name!!,
        ground = ground!!,
        weather = weather!!
)

fun PlanetEntity.toResponse() = PlanetResponse(
        code = code,
        name = name,
        ground = ground,
        weather = weather,
        numPresence = numPresence!!
)

