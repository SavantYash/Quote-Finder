package com.example.test123.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.test123.model.QuoteDatabase
import com.example.test123.model.QuoteRepository
import com.example.test123.model.datamodel.Quote
import com.example.test123.model.retrofit.ApiObject
import com.example.test123.model.retrofit.RetrofitApi
import kotlinx.coroutines.launch

class QuoteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: QuoteRepository
    private var _quotes: LiveData<List<Quote>> = MutableLiveData()
    val quotes: LiveData<List<Quote>> get() = _quotes

    private val quoteList : MutableList<Quote> = mutableListOf()
    private val api : RetrofitApi = ApiObject.retrofit

    init {
        val dao = QuoteDatabase.getDatabase(application).quoteDao()
        repository = QuoteRepository(dao)
        viewModelScope.launch {
            if (dao.getCount() == 0) {
                generateQuote()
                repository.insertNew(quoteList)
            }
        }
    }

    fun loadQuotes(filter: String) {
        _quotes = repository.getQuotes(filter)
    }

    fun toggleStar(quote: Quote) = viewModelScope.launch {
        quote.isStarred = !quote.isStarred
        repository.updateQuote(quote)
    }

    fun toggleHeart(quote: Quote) = viewModelScope.launch {
        quote.isHearted = !quote.isHearted
        repository.updateQuote(quote)
    }

    fun getNewQuotes() = viewModelScope.launch {
        generateQuote()
        repository.insertNew(quoteList)
    }

    private suspend fun generateQuote(){
        quoteList.clear()
        for (i in 1..10) {
            api.getQuote().forEach {
                quoteList.add(Quote(0, it.quote, isStarred = false, isHearted = false))
            }
        }
    }
}
