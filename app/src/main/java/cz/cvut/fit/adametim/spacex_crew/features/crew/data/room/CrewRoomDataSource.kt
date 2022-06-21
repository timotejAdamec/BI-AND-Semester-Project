package cz.cvut.fit.adametim.spacex_crew.features.crew.data.room

import cz.cvut.fit.adametim.spacex_crew.features.crew.data.CrewDatabaseDataSource
import cz.cvut.fit.adametim.spacex_crew.features.crew.domain.CrewMember
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

class CrewRoomDataSource(
    private val crewDao: CrewDao
) : CrewDatabaseDataSource {

    override fun getCrewStream(): Flow<List<CrewMember>> {
        return crewDao.getCrewStream().filterNotNull().map { databaseCrew ->
            databaseCrew.map { databaseCrewMember ->
                DatabaseCrewMemberMapper.getCrewMember(databaseCrewMember)
            }
        }
    }

    override fun getCrewMemberStream(id: String): Flow<CrewMember> {
        return crewDao.getCrewMemberStream(id).filterNotNull().map { databaseCrewMember ->
            DatabaseCrewMemberMapper.getCrewMember(databaseCrewMember)
        }
    }

    override suspend fun synchronizeCrew(crew: List<CrewMember>) {
        val databaseCrew = crew.map { crewMember ->
            DatabaseCrewMemberMapper.getDatabaseCrewMember(crewMember)
        }
        crewDao.synchronizeCrew(databaseCrew)
    }
}