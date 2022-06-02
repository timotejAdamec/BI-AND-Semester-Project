package cz.cvut.fit.adametim.spacex_crew.features.crew.data

import cz.cvut.fit.adametim.spacex_crew.features.crew.domain.CrewMember
import kotlinx.coroutines.flow.Flow

class CrewRepository(
    private val crewDatabaseDataSource: CrewDatabaseDataSource,
    private val crewRemoteDataSource: CrewRemoteDataSource
) {

    fun getCrewStream(): Flow<List<CrewMember>> {
        return crewDatabaseDataSource.getCrewStream()
    }

    fun getCrewMemberStream(id: Int): Flow<CrewMember> {
        return crewDatabaseDataSource.getCrewMemberStream(id)
    }

    suspend fun fetchCrew() {
        val crew = crewRemoteDataSource.fetchCrew()
        crewDatabaseDataSource.synchronizeCrew(crew)
    }
}
