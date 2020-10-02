package me.sungbin.coroutinestest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Unconfined).launch {
            log(Date().time)
            val deferred = async {
                log(Date().time)
                var i = 0
                while (i < 5) {
                    delay(500)
                    println("lazy async $i")
                    yield()
                    i++
                }
                i
            }
            log(deferred.await())
        }
    }
}

fun log(text: Any) {
    Log.w("CoroutinesTest-Logging", text.toString())
}