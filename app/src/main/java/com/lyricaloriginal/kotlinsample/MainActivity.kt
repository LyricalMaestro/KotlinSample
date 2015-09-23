package com.lyricaloriginal.kotlinsample

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast

/**
 * A sample activity of Kotlin.
 *
 * Created by LyricalMaestro on 15/09/22.
 */
class MainActivity() : Activity() {

    private var _active = false
    private var _handler: Handler = Handler();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        _active = true
        _handler = Handler()
        _handler.postDelayed(Runnable { fired() }, 1000)
    }

    override fun onStop() {
        super.onStop()
        _active = false
    }

    fun fired() {
        if (_active) {
            val msgTxtView: TextView = findViewById(R.id.msg_txtview) as TextView
            msgTxtView.append("こんにちは!\r\n")
            _handler.postDelayed(Runnable { fired() }, 3000)
        }
    }
}