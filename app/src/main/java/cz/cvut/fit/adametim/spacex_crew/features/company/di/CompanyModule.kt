package cz.cvut.fit.adametim.spacex_crew.features.company.di

import cz.cvut.fit.adametim.spacex_crew.features.company.data.CompanyDatabaseDataSource
import cz.cvut.fit.adametim.spacex_crew.features.company.data.CompanyRemoteDataSource
import cz.cvut.fit.adametim.spacex_crew.features.company.data.CompanyRepository
import cz.cvut.fit.adametim.spacex_crew.features.company.data.retrofit.CompanyApiDescription
import cz.cvut.fit.adametim.spacex_crew.features.company.data.retrofit.CompanyRetrofitDataSource
import cz.cvut.fit.adametim.spacex_crew.features.company.data.room.CompanyRoomDataSource
import cz.cvut.fit.adametim.spacex_crew.features.company.presentation.CompanyViewModel
import cz.cvut.fit.adametim.spacex_crew.shared.data.room.AppDatabase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val companyModule = module {

    factory {
        get<Retrofit>().create(CompanyApiDescription::class.java)
    }

    factory<CompanyRemoteDataSource> {
        CompanyRetrofitDataSource(get())
    }

    factory {
        get<AppDatabase>().getCompanyDao()
    }

    factory<CompanyDatabaseDataSource> {
        CompanyRoomDataSource(get())
    }

    single {
        CompanyRepository(get(), get())
    }

    viewModel {
        CompanyViewModel(get())
    }
}