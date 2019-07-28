package br.com.ame.starwarsapi.external.swapi.service

import br.com.ame.starwarsapi.external.swapi.client.SwapiClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SwapiServiceImpl(
        @Autowired
        private val swapiClient: SwapiClient
): SwapiService {

    private val log: Logger = LoggerFactory.getLogger(SwapiServiceImpl::class.java)

    override fun getPlanetNumPresenceByName(name: String): Int {

        try{
            val response = swapiClient.getPlanetByName(name)

            if ( response.statusCode.is2xxSuccessful ){
                return response.body?.result?.first()?.films?.size ?: 0
            }

        }catch (ex: Exception) {
            log.error("Error on getting data of planet presence number in the starwars movies. Details: ${ex.message}")
        }
        return 0
    }

}