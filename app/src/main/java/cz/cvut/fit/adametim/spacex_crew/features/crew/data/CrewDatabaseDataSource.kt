package cz.cvut.fit.adametim.spacex_crew.features.crew.data

import cz.cvut.fit.adametim.spacex_crew.features.crew.domain.CrewMember
import kotlinx.coroutines.flow.Flow

interface CrewDatabaseDataSource {
    fun getCrewStream(): Flow<List<CrewMember>>
    fun getCrewMemberStream(id: Int): Flow<CrewMember>
    suspend fun synchronizeCrew(crew: List<CrewMember>)
}