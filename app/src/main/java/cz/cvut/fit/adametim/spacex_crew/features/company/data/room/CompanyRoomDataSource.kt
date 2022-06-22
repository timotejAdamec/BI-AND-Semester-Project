package cz.cvut.fit.adametim.spacex_crew.features.company.data.room

import cz.cvut.fit.adametim.spacex_crew.features.company.data.CompanyDatabaseDataSource
import cz.cvut.fit.adametim.spacex_crew.features.company.domain.Company
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

class CompanyRoomDataSource(
    private val companyDao: CompanyDao
) : CompanyDatabaseDataSource {

    override fun getCompanyStream(): Flow<Company> {
        return companyDao.getCompanyStream().filterNotNull().map { databaseCompany ->
            DatabaseCompanyMapper.getCompany(databaseCompany)
        }
    }

    override suspend fun synchronizeCompany(company: Company) {
        companyDao.synchronizeCompany(DatabaseCompanyMapper.getDatabaseCompany(company))
    }
}