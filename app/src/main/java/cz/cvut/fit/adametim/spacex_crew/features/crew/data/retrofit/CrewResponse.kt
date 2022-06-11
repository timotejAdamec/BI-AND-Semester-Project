package cz.cvut.fit.adametim.spacex_crew.features.crew.data.retrofit

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CrewResponse(
    val result: List<ApiCrewMember>
)
