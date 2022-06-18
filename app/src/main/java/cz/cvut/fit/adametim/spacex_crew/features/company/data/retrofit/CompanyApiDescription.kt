package cz.cvut.fit.adametim.spacex_crew.features.company.data.retrofit

import retrofit2.http.GET

interface CompanyApiDescription {
    @GET("company")
    suspend fun fetchCompany(): ApiCompany
}