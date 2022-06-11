package cz.cvut.fit.adametim.spacex_crew.features.crew.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CrewDao {

    @Query("SELECT * FROM crew")
    abstract fun getCrewStream(): Flow<List<DatabaseCrewMember>>

    @Query("SELECT * FROM crew WHERE id IS :id")
    abstract fun getCrewMemberStream(id: Int): Flow<DatabaseCrewMember>

    @Transaction
    open suspend fun synchronizeCrew(characters: List<DatabaseCrewMember>) {
        delete()
        insert(characters)
    }

    @Insert
    protected abstract suspend fun insert(characters: List<DatabaseCrewMember>)

    @Query("DELETE FROM crew")
    protected abstract suspend fun delete()
}