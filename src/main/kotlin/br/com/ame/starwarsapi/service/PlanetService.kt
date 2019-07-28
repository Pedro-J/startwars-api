package br.com.ame.starwarsapi.service

import br.com.ame.starwarsapi.entity.PlanetEntity

interface PlanetService {
    fun findByCode(code: String): PlanetEntity?
    fun findAll(): List<PlanetEntity>
    fun findByName(name: String): List<PlanetEntity>
    fun create(planet: PlanetEntity): PlanetEntity?
    fun delete(code: String)
}