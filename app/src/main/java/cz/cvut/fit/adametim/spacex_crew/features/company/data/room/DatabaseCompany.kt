package cz.cvut.fit.adametim.spacex_crew.features.company.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company")
data class DatabaseCompany(
    @PrimaryKey val id: String,
    val hqAddress: String,
    val hqCity: String,
    val hqState: String,
    val website: String,
    val name: String,
    val founder: String,
    val founded: Int,
    val employees: Int,
    val vehicles: Int,
    val numberOfLaunchSites: Int,
    val numberOfTestSites: Int,
    val summary: String
    )