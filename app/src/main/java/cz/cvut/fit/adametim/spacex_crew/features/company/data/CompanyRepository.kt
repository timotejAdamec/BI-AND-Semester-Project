package cz.cvut.fit.adametim.spacex_crew.features.company.data

import android.util.Log
import cz.cvut.fit.adametim.spacex_crew.features.company.domain.Company
import cz.cvut.fit.adametim.spacex_crew.features.crew.data.CrewDatabaseDataSource
import cz.cvut.fit.adametim.spacex_crew.features.crew.data.CrewRemoteDataSource
import cz.cvut.fit.adametim.spacex_crew.features.crew.domain.CrewMember
import kotlinx.coroutines.flow.Flow

class CompanyRepository(
    private val companyDatabaseDataSource: CompanyDatabaseDataSource,
    private val companyRemoteDataSource: CompanyRemoteDataSource
) {

    fun getCompanyStream(): Flow<Company> {
        return companyDatabaseDataSource.getCompanyStream()
    }

    suspend fun fetchCompany() {
        val company = companyRemoteDataSource.fetchCompany()
        companyDatabaseDataSource.synchronizeCompany(company = company)
    }
}
