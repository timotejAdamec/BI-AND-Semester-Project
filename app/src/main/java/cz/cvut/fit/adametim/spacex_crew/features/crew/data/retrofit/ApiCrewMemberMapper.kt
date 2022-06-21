package cz.cvut.fit.adametim.spacex_crew.features.crew.data.retrofit

import cz.cvut.fit.adametim.spacex_crew.features.crew.domain.CrewMember

class ApiCrewMemberMapper {
    companion object {

        fun getCrewMember(apiCrewMember: ApiCrewMember): CrewMember {
            return CrewMember(
                id = apiCrewMember.id,
                name = apiCrewMember.name,
                status = apiCrewMember.status,
                agency = apiCrewMember.agency,
                wikipedia = apiCrewMember.wikipedia,
                numberOfLaunches = apiCrewMember.launches.size,
                imageUrl = apiCrewMember.image
            )
        }
    }
}