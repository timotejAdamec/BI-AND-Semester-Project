package cz.cvut.fit.adametim.spacex_crew.features.crew.domain

data class CrewMember(
    val id: String,
    val name: String,
    val status: String,
    val agency: String,
    val wikipedia: String,
    val numberOfLaunches: Int,
    val imageUrl: String
)