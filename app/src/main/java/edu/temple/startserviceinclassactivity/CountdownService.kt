package edu.temple.startserviceinclassactivity

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val COUNTDOWN_START_VALUE = "countdownvalue"

class CountdownService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        CoroutineScope(Dispatchers.IO).launch{
            intent?.run{
                val from = getIntExtra(COUNTDOWN_START_VALUE, 0)

                repeat(from){
                    Log.d("Countdown", (from - it).toString())
                    delay(1000)
                }
            }


        }

        return super.onStartCommand(intent, flags, startId)
    }
}