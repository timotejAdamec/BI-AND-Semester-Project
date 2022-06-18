package cz.cvut.fit.adametim.spacex_crew.features.company.data

import cz.cvut.fit.adametim.spacex_crew.features.company.domain.Company

interface CompanyRemoteDataSource {
    suspend fun fetchCompany(): Company
}