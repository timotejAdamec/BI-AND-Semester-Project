package cz.cvut.fit.adametim.spacex_crew.features.company.data.retrofit

import android.util.Log
import cz.cvut.fit.adametim.spacex_crew.features.company.data.CompanyRemoteDataSource
import cz.cvut.fit.adametim.spacex_crew.features.company.domain.Company

class CompanyRetrofitDataSource(
    private val companyApiDescription: CompanyApiDescription
) : CompanyRemoteDataSource {

    override suspend fun fetchCompany(): Company {
        val apiCompany = companyApiDescription.fetchCompany()
        return ApiCompanyMapper.getCompany(apiCompany)
    }
}
