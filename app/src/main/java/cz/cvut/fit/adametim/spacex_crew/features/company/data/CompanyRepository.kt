package cz.cvut.fit.adametim.spacex_crew.features.company.data

import cz.cvut.fit.adametim.spacex_crew.features.company.domain.Company
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
