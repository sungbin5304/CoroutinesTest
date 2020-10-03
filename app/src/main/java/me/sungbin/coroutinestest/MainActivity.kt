package me.sungbin.coroutinestest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        suspend fun one(): Int {
            var i = 0
            repeat(5) {
                delay(1000)
                i++
            }
            return i
        }

        suspend fun two(): Int {
            var i = 0
            repeat(10) {
                delay(1000)
                i++
            }
            return i
        }

        CoroutineScope(Dispatchers.Main).launch {
            log("hello world!")
        }.run {
            start()
            cancel()
        }
    }
}

fun log(text: Any) {
    Log.w("CoroutinesTest-Logging", text.toString())
}