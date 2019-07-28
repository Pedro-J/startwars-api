package br.com.ame.starwarsapi.external.swapi.client

import br.com.ame.starwarsapi.external.swapi.response.SwapiPlanetResponseList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.*
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class SwapiClient (
        @Autowired
        private val restTemplate: RestTemplate
){

    private var baseUri: String = "https://swapi.co/api/%s"

    fun getPlanetByName(name: String): ResponseEntity<SwapiPlanetResponseList> {
        val resourceUri = "planets/?search=$name"
        val requestEntity = HttpEntity<Any>(createHeader())
        return restTemplate.exchange(baseUri.format(resourceUri), HttpMethod.GET, requestEntity, SwapiPlanetResponseList::class.java)
    }

    private fun createHeader(): HttpHeaders {
        val header = HttpHeaders()
        header.accept = listOf(MediaType.APPLICATION_JSON)
        return header
    }
}