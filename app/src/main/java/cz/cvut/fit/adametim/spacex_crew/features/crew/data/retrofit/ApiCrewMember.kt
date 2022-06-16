package cz.cvut.fit.adametim.spacex_crew.features.crew.data.retrofit

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiCrewMember(
    val id: String,
    val name: String,
    val status: String,
    val agency: String,
    val wikipedia: String,
    //val launches: List<String>,
    val image: String
)