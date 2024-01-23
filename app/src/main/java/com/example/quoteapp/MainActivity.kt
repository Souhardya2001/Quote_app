package com.example.quoteapp
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssestsfromJson(applicationContext)
        }
        setContent {

            App()
        }
    }
}
@Composable
fun App() {
    if (DataManager.isdataloaded.value) {
        if(DataManager.currentPage_val.value == currentPage.LISTING) {
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        }
        else {
            DataManager.currentquote?.let { QuoteDetail(quote = it) }
        }
    }
}