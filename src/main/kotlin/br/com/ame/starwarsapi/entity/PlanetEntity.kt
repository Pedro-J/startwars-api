package br.com.ame.starwarsapi.entity

import javax.persistence.*

@Entity
@Table(name = "tb_planet")
data class PlanetEntity(

        @Column(name = "code") //public identifier
        var code: String,

        @Column(name = "name")
        var name: String,

        @Column(name = "ground")
        var ground: String,

        @Column(name = "weather")
        var weather: String

) {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "planet_id")
        var id: Long? = null

        @Transient
        var numPresence: Int = 0
}