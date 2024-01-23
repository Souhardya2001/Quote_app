package com.example.quoteapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun QuoteList(data: Array<Quote>, Onclick: (quote: Quote) -> Unit){
        LazyColumn(
            content ={
                items(data){
                    QuotelistItems(quote = it,Onclick)
                }
            }
        )
}