package cz.cvut.fit.adametim.spacex_crew.features.company.data.retrofit

import cz.cvut.fit.adametim.spacex_crew.features.company.data.CompanyRemoteDataSource
import cz.cvut.fit.adametim.spacex_crew.features.company.domain.Company
import cz.cvut.fit.adametim.spacex_crew.features.crew.data.CrewRemoteDataSource
import cz.cvut.fit.adametim.spacex_crew.features.crew.data.retrofit.CrewApiDescription
import cz.cvut.fit.adametim.spacex_crew.features.crew.domain.CrewMember

class CompanyRetrofitDataSource(
    private val companyApiDescription: CompanyApiDescription
) : CompanyRemoteDataSource {

    override suspend fun fetchCompany(): Company {
        val apiCompany = companyApiDescription.fetchCompany()
        return Company(
            id = apiCompany.id,
            hqAddress = apiCompany.headquarters.address,
            hqCity = apiCompany.headquarters.city,
            hqState = apiCompany.headquarters.state,
            website = apiCompany.links.website,
            name = apiCompany.name,
            founder = apiCompany.founder,
            founded = apiCompany.founded,
            employees = apiCompany.employees,
            vehicles = apiCompany.vehicles,
            numberOfLaunchSites = apiCompany.launch_sites,
            numberOfTestSites = apiCompany.test_sites,
            summary = apiCompany.summary
        )
    }
}
