package br.com.ame.starwarsapi.resource

import br.com.ame.starwarsapi.mapper.toEntity
import br.com.ame.starwarsapi.mapper.toResponse
import br.com.ame.starwarsapi.resource.request.PlanetRequest
import br.com.ame.starwarsapi.resource.response.PlanetResponse
import br.com.ame.starwarsapi.resource.response.PlanetResponseList
import br.com.ame.starwarsapi.service.PlanetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/planets"], produces = [APPLICATION_JSON_VALUE])
class PlanetResource(
        @Autowired
        private val planetService: PlanetService
){
    @PostMapping(consumes = [APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun createNewPlanet(@Valid @RequestBody planetRequest: PlanetRequest): PlanetResponse {
        return planetService.create(planetRequest.toEntity())!!.toResponse()
    }

    @GetMapping(value = ["/{code}"])
    @ResponseStatus(HttpStatus.OK)
    fun getPlanetByCode(@PathVariable code: String): PlanetResponse {
        return planetService.findByCode(code)!!.toResponse()
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getPlanetsByName(@RequestParam("name") name: String): PlanetResponseList {
        return PlanetResponseList(planetService.findByName(name).map { it.toResponse() })
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    fun getAllPlanets(): PlanetResponseList {
       return PlanetResponseList(planetService.findAll().map { it.toResponse() })
    }

    @DeleteMapping(value = ["/{code}"])
    @ResponseStatus(HttpStatus.OK)
    fun deletePlanetById(@PathVariable code: String) {
        planetService.delete(code)
    }
}