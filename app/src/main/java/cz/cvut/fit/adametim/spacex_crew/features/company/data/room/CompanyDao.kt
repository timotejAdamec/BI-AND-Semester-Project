package cz.cvut.fit.adametim.spacex_crew.features.company.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CompanyDao {
    @Query("SELECT * FROM company ORDER BY id DESC LIMIT 1")
    abstract fun getCompanyStream(): Flow<DatabaseCompany>

    @Transaction
    open suspend fun synchronizeCompany(company: DatabaseCompany) {
        delete()
        insert(company)
    }

    @Insert
    protected abstract suspend fun insert(company: DatabaseCompany)

    @Query("DELETE FROM company")
    protected abstract suspend fun delete()
}