package cz.cvut.fit.adametim.spacex_crew.shared.di

import androidx.room.Room
import cz.cvut.fit.adametim.spacex_crew.shared.data.room.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val sharedModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v4/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "db")
            .fallbackToDestructiveMigration()
            .build()
    }
}