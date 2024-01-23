package com.example.quoteapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson

object DataManager {
    var data = emptyArray<Quote>()
    var isdataloaded = mutableStateOf(false)
    var currentPage_val = mutableStateOf(currentPage.LISTING)
    var currentquote: Quote?= null
    fun loadAssestsfromJson(context : Context){
        val inputStream = context.assets.open("quotes.json")
        val size :Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val jsonString = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(jsonString,Array<Quote>::class.java)
        isdataloaded.value = true
    }
    fun switchPages(quote : Quote?){
        if(currentPage_val.value == currentPage.LISTING){
            currentPage_val.value = currentPage.DETAILS
            currentquote = quote
        }
        else{
            currentPage_val.value = currentPage.LISTING
        }
    }
}