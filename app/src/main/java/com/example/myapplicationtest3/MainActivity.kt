package com.example.myapplicationtest3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 別クラスに呼び出せる
        val API_URL = "http://mattun-pattun.com/api/delete";
        HitAPITask().execute(API_URL)
    }
}

