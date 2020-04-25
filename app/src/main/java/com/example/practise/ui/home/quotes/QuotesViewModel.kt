package com.example.practise.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.example.practise.data.repositories.QuotesRepository
import com.example.practise.utils.lazyDeferred

class QuotesViewModel (
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}