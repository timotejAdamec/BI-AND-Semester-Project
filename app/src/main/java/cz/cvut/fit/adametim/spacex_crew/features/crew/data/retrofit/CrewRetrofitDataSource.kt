package cz.cvut.fit.adametim.spacex_crew.features.crew.data.retrofit

import cz.cvut.fit.adametim.spacex_crew.features.crew.data.CrewRemoteDataSource
import cz.cvut.fit.adametim.spacex_crew.features.crew.domain.CrewMember

class CrewRetrofitDataSource(
    private val crewApiDescription: CrewApiDescription
) : CrewRemoteDataSource {

    override suspend fun fetchCrew(): List<CrewMember> {
        return crewApiDescription.fetchCrew().map { apiCrewMember ->
            ApiCrewMemberMapper.getCrewMember(apiCrewMember)
        }
    }
}