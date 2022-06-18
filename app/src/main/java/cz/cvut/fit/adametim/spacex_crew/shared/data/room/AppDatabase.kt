package cz.cvut.fit.adametim.spacex_crew.shared.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import cz.cvut.fit.adametim.spacex_crew.features.company.data.room.CompanyDao
import cz.cvut.fit.adametim.spacex_crew.features.crew.data.room.CrewDao
import cz.cvut.fit.adametim.spacex_crew.features.crew.data.room.DatabaseCrewMember

@Database(entities = [DatabaseCrewMember::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getCrewDao(): CrewDao

    abstract fun getCompanyDao(): CompanyDao
}