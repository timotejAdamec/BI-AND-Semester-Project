package cz.cvut.fit.adametim.spacex_crew.features.crew.di

import cz.cvut.fit.adametim.spacex_crew.features.crew.data.CrewDatabaseDataSource
import cz.cvut.fit.adametim.spacex_crew.features.crew.data.CrewRemoteDataSource
import cz.cvut.fit.adametim.spacex_crew.features.crew.data.CrewRepository
import cz.cvut.fit.adametim.spacex_crew.features.crew.data.retrofit.CrewApiDescription
import cz.cvut.fit.adametim.spacex_crew.features.crew.data.retrofit.CrewRetrofitDataSource
import cz.cvut.fit.adametim.spacex_crew.features.crew.data.room.CrewRoomDataSource
import cz.cvut.fit.adametim.spacex_crew.features.crew.presentation.CrewViewModel
import cz.cvut.fit.adametim.spacex_crew.shared.data.room.AppDatabase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val crewModule = module {

    factory {
        get<Retrofit>().create(CrewApiDescription::class.java)
    }

    factory<CrewRemoteDataSource> {
        CrewRetrofitDataSource(get())
    }

    factory {
        get<AppDatabase>().getCrewDao()
    }

    factory<CrewDatabaseDataSource> {
        CrewRoomDataSource(get())
    }

    single {
        CrewRepository(get(), get())
    }

    viewModel {
        CrewViewModel(get())
    }
}