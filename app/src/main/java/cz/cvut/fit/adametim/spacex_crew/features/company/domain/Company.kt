package cz.cvut.fit.adametim.spacex_crew.features.company.domain

data class Company(
    val id: String,
    val hqAddress: String,
    val hqCity: String,
    val hqState: String,
    val website: String,
    val name: String,
    val founder: String,
    val founded: Int,
    val employees: Int,
    val vehicles: Int,
    val numberOfLaunchSites: Int,
    val numberOfTestSites: Int,
    val summary: String
)
