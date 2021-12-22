package ru.slartus.coilexperiments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import coil.load

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.image)
            // take any path from iconUrl attribute from https://raw.githubusercontent.com/slartus/4pdaClient-plus/master/forum_struct.json
            .load("https://ds-assets.cdn.devapps.ru/jiOb0rOXz2odLpYhjQEX9vTRyt5HNlb9hO9CT6Nu.gif") {
                listener(
                    onError = { _, throwable ->
                        throwable.printStackTrace()
                        Log.e("TAG", throwable.toString())
                        Toast.makeText(this@MainActivity, throwable.message, Toast.LENGTH_SHORT)
                            .show()
                    }
                )
            }
    }
}