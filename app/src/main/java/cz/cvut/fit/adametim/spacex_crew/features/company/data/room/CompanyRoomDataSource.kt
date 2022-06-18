package cz.cvut.fit.adametim.spacex_crew.features.company.data.room

import cz.cvut.fit.adametim.spacex_crew.features.company.data.CompanyDatabaseDataSource
import cz.cvut.fit.adametim.spacex_crew.features.company.domain.Company
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CompanyRoomDataSource(
    private val companyDao: CompanyDao
) : CompanyDatabaseDataSource {

    override fun getCompanyStream(): Flow<Company> {
        return companyDao.getCompanyStream().map { databaseCompany ->
            Company(
                id = databaseCompany.id,
                hqAddress = databaseCompany.hqAddress,
                hqCity = databaseCompany.hqCity,
                hqState = databaseCompany.hqState,
                website = databaseCompany.website,
                name = databaseCompany.name,
                founder = databaseCompany.founder,
                founded = databaseCompany.founded,
                employees = databaseCompany.employees,
                vehicles = databaseCompany.vehicles,
                numberOfLaunchSites = databaseCompany.numberOfLaunchSites,
                numberOfTestSites = databaseCompany.numberOfTestSites,
                summary = databaseCompany.summary
            )
        }
    }

    override suspend fun synchronizeCompany(company: Company) {
        companyDao.synchronizeCompany(DatabaseCompany(
            id = company.id,
            hqAddress = company.hqAddress,
            hqCity = company.hqCity,
            hqState = company.hqState,
            website = company.website,
            name = company.name,
            founder = company.founder,
            founded = company.founded,
            employees = company.employees,
            vehicles = company.vehicles,
            numberOfLaunchSites = company.numberOfLaunchSites,
            numberOfTestSites = company.numberOfTestSites,
            summary = company.summary
        ))
    }
}