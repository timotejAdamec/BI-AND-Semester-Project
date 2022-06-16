package cz.cvut.fit.adametim.spacex_crew.features.crew.data.retrofit

import cz.cvut.fit.adametim.spacex_crew.features.crew.data.CrewRemoteDataSource
import cz.cvut.fit.adametim.spacex_crew.features.crew.domain.CrewMember

class CrewRetrofitDataSource(
    private val crewApiDescription: CrewApiDescription
) : CrewRemoteDataSource {
    override suspend fun fetchCrew(): List<CrewMember> {
        return crewApiDescription.fetchCrew().map { apiCrewMember ->
            CrewMember(
                id = apiCrewMember.id,
                name = apiCrewMember.name,
                status = apiCrewMember.status,
                agency = apiCrewMember.agency,
                wikipedia = apiCrewMember.wikipedia,
                //numberOfLaunches = apiCrewMember.launches.size,
                numberOfLaunches = 1,
                imageUrl = apiCrewMember.image
            )
        }
    }
}