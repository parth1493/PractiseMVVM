package com.example.practise.data.network.repsonses

import com.example.practise.data.db.entites.Quote

data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)