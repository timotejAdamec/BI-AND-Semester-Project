package cz.cvut.fit.adametim.spacex_crew.features.crew.data.room

import cz.cvut.fit.adametim.spacex_crew.features.crew.data.CrewDatabaseDataSource
import cz.cvut.fit.adametim.spacex_crew.features.crew.domain.CrewMember
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CrewRoomDataSource(
    private val crewDao: CrewDao
) : CrewDatabaseDataSource {
    override fun getCrewStream(): Flow<List<CrewMember>> {
        return crewDao.getCrewStream().map { databaseCrew ->
            databaseCrew.map { databaseCrewMember ->
                CrewMember(
                    id = databaseCrewMember.id,
                    name = databaseCrewMember.name,
                    status = databaseCrewMember.status,
                    agency = databaseCrewMember.agency,
                    wikipedia = databaseCrewMember.wikipedia,
                    numberOfLaunches = databaseCrewMember.numberOfLaunches,
                    imageUrl = databaseCrewMember.imageUrl
                )
            }
        }
    }

    override fun getCrewMemberStream(id: String): Flow<CrewMember> {
        return crewDao.getCrewMemberStream(id).map { databaseCrewMember ->
            CrewMember(
                id = databaseCrewMember.id,
                name = databaseCrewMember.name,
                status = databaseCrewMember.status,
                agency = databaseCrewMember.agency,
                wikipedia = databaseCrewMember.wikipedia,
                numberOfLaunches = databaseCrewMember.numberOfLaunches,
                imageUrl = databaseCrewMember.imageUrl
            )
        }
    }

    override suspend fun synchronizeCrew(crew: List<CrewMember>) {
        val databaseCrew = crew.map { crewMember ->
            DatabaseCrewMember(
                id = crewMember.id,
                name = crewMember.name,
                status = crewMember.status,
                agency = crewMember.agency,
                wikipedia = crewMember.wikipedia,
                numberOfLaunches = crewMember.numberOfLaunches,
                imageUrl = crewMember.imageUrl
            )
        }
        crewDao.synchronizeCrew(databaseCrew)
    }
}