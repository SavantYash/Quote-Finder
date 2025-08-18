package com.example.test123.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.test123.model.datamodel.Quote

@Dao
interface QuoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes: List<Quote>)

    @Update
    suspend fun updateQuote(quote: Quote)

    @Query("SELECT * FROM quotes")
    fun getAllQuotes(): LiveData<List<Quote>>

    @Query("SELECT * FROM quotes WHERE isStarred = 1")
    fun getStarredQuotes(): LiveData<List<Quote>>

    @Query("SELECT * FROM quotes WHERE isHearted = 1")
    fun getHeartedQuotes(): LiveData<List<Quote>>

    @Query("SELECT * FROM quotes WHERE isStarred = 1 AND isHearted = 1")
    fun getStarredAndHeartedQuotes(): LiveData<List<Quote>>

    @Query("DELETE FROM quotes WHERE isStarred = 0 AND isHearted = 0")
    suspend fun deleteNotSelected()

    @Query("SELECT COUNT(*) FROM quotes")
    suspend fun getCount(): Int
}
