package cz.cvut.fit.adametim.spacex_crew.features.crew.data.room

import cz.cvut.fit.adametim.spacex_crew.features.crew.domain.CrewMember

class DatabaseCrewMemberMapper {
    companion object {

        fun getCrewMember(databaseCrewMember: DatabaseCrewMember): CrewMember {
            return CrewMember(
                id = databaseCrewMember.id,
                name = databaseCrewMember.name,
                status = databaseCrewMember.status,
                agency = databaseCrewMember.agency,
                wikipedia = databaseCrewMember.wikipedia,
                numberOfLaunches = databaseCrewMember.numberOfLaunches,
                imageUrl = databaseCrewMember.imageUrl
            )
        }

        fun getDatabaseCrewMember(crewMember: CrewMember): DatabaseCrewMember {
            return DatabaseCrewMember(
                id = crewMember.id,
                name = crewMember.name,
                status = crewMember.status,
                agency = crewMember.agency,
                wikipedia = crewMember.wikipedia,
                numberOfLaunches = crewMember.numberOfLaunches,
                imageUrl = crewMember.imageUrl
            )
        }
    }
}