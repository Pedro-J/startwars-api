package br.com.ame.starwarsapi

import br.com.ame.starwarsapi.entity.PlanetEntity
import br.com.ame.starwarsapi.repository.PlanetRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
class StarwarsApiApplication{

	@Bean
	fun init(planetRepository: PlanetRepository) = CommandLineRunner {
		println("Creating planets...")

		val marte = PlanetEntity(UUID.randomUUID().toString(), "marte", "desert", "HOT" )
		val naboo = PlanetEntity(UUID.randomUUID().toString(), "Naboo", "grassy hills, swamps, forests, mountains", "Partially cold" )
		val coruscant = PlanetEntity(UUID.randomUUID().toString(), "Coruscant", "cityscape, mountains", "Raining" )
		val kamino = PlanetEntity(UUID.randomUUID().toString(), "Kamino", "ocean", "HEAT" )
		val alderaan = PlanetEntity(UUID.randomUUID().toString(), "Alderaan", "Green GROUND", "COLD" )


		planetRepository.saveAll(listOf(marte, naboo, coruscant, kamino, alderaan))

		println("Planets created...")

	}
}

fun main(args: Array<String>) {
	runApplication<StarwarsApiApplication>(*args)
}
