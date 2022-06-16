package cz.cvut.fit.adametim.spacex_crew.features.crew.data.retrofit

import retrofit2.http.GET

interface CrewApiDescription {
    @GET("crew")
    suspend fun fetchCrew(): List<ApiCrewMember>
}