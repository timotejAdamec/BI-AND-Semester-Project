package cz.cvut.fit.adametim.spacex_crew.features.company.data

import cz.cvut.fit.adametim.spacex_crew.features.company.domain.Company
import kotlinx.coroutines.flow.Flow

interface CompanyDatabaseDataSource {
    fun getCompanyStream(): Flow<Company>
    suspend fun synchronizeCompany(company: Company)
}