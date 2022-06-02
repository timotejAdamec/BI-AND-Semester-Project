package cz.cvut.fit.adametim.spacex_crew.features.crew.data

import cz.cvut.fit.adametim.spacex_crew.features.crew.domain.CrewMember

interface CrewRemoteDataSource {
    suspend fun fetchCrew(): List<CrewMember>
}