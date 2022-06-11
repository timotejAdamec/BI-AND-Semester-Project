package cz.cvut.fit.adametim.spacex_crew.features.crew.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crew")
data class DatabaseCrewMember(
    @PrimaryKey val id: String,
    val name: String,
    val agency: String,
    val wikipedia: String,
    val status: String,
    val numberOfLaunches: Int,
    val imageUrl: String
)
