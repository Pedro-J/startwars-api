package br.com.ame.starwarsapi.external.swapi.service

interface SwapiService{
    fun getPlanetNumPresenceByName(name: String): Int
}