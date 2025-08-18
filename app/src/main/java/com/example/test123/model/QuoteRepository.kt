package com.example.test123.model

import androidx.lifecycle.LiveData
import com.example.test123.model.dao.QuoteDao
import com.example.test123.model.datamodel.Quote

class QuoteRepository(private val dao: QuoteDao) {

    fun getQuotes(filter: String): LiveData<List<Quote>> {
        return when (filter) {
            "ALL" -> dao.getAllQuotes()
            "STAR" -> dao.getStarredQuotes()
            "HEART" -> dao.getHeartedQuotes()
            "BOTH" -> dao.getStarredAndHeartedQuotes()
            else -> dao.getAllQuotes()
        }
    }

    suspend fun updateQuote(quote: Quote) {
        dao.updateQuote(quote)
    }

    suspend fun insertNew(newList : List<Quote>){
        dao.deleteNotSelected()
        dao.insertAll(newList)
    }
}
