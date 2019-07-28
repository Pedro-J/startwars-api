package br.com.ame.starwarsapi.repository

import br.com.ame.starwarsapi.entity.PlanetEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlanetRepository: JpaRepository<PlanetEntity, Long> {
    fun findByNameIgnoreCase(name: String): List<PlanetEntity>

    fun findByCode(code: String): PlanetEntity?
}