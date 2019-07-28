package br.com.ame.starwarsapi.service

import br.com.ame.starwarsapi.entity.PlanetEntity
import br.com.ame.starwarsapi.exception.NotFoundException
import br.com.ame.starwarsapi.external.swapi.client.SwapiClient
import br.com.ame.starwarsapi.external.swapi.service.SwapiService
import br.com.ame.starwarsapi.repository.PlanetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PlanetServiceImpl(

        @Autowired
        private val planetRepository: PlanetRepository,

        @Autowired
        private val swapiService: SwapiService

): PlanetService{

    override fun findByCode(code: String): PlanetEntity? {
        return planetRepository.findByCode(code)
                ?.apply { numPresence = swapiService.getPlanetNumPresenceByName(name) } ?: throw NotFoundException("No Planet Found")
    }

    override fun findAll(): List<PlanetEntity> {
        return planetRepository.findAll()
                .map { planet -> planet.apply { numPresence = swapiService.getPlanetNumPresenceByName(this.name) } }
    }

    override fun findByName(name: String): List<PlanetEntity> {
        return planetRepository.findByNameIgnoreCase(name)
                .map { planet -> planet.apply { numPresence = swapiService.getPlanetNumPresenceByName(this.name) } }
                .takeIf{ it.isNotEmpty() } ?: throw NotFoundException("No Planet Found")
    }

    override fun create(planet: PlanetEntity): PlanetEntity {
        planet.code = UUID.randomUUID().toString() // generate public identifier
        return planetRepository.save(planet).apply { numPresence = swapiService.getPlanetNumPresenceByName(name) }
    }

    override fun delete(code: String) {
        val planet = planetRepository.findByCode(code)
        planet?.let{ planetRepository.deleteById(it.id!!) } ?: throw NotFoundException("No Planet Found")
    }

}