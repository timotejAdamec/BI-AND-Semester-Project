package cz.cvut.fit.adametim.spacex_crew.shared.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import cz.cvut.fit.adametim.spacex_crew.features.crew.data.room.CrewDao
import cz.cvut.fit.adametim.spacex_crew.features.crew.data.room.DatabaseCrewMember

@Database(entities = [DatabaseCrewMember::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getCrewDao(): CrewDao
}