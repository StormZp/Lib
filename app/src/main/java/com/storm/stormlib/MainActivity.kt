package com.storm.stormlib

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.storm.lib.Test
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var test = findViewById<TextView>(R.id.test1);
        test.setText(Test.test())
    }
}
