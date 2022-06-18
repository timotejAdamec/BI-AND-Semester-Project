package cz.cvut.fit.adametim.spacex_crew.features.company.data.retrofit

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiCompany(
    val headquarters: ApiHeadquarters,
    val links: ApiLinks,
    val name: String,
    val founder: String,
    val founded: Int,
    val employees: Int,
    val vehicles: Int,
    val launch_sites: Int,
    val test_sites: Int,
    val ceo: String,
    val cto: String,
    val coo: String,
    val cto_propulsion: String,
    val valuation: Long,
    val summary: String,
    val id: String
)

@JsonClass(generateAdapter = true)
data class ApiHeadquarters(
    val address: String,
    val city: String,
    val state: String
)

@JsonClass(generateAdapter = true)
data class ApiLinks(
    val website: String,
    val flickr: String,
    val twitter: String,
    val elon_twitter: String
)
