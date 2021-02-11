package com.example.myapplicationtest3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 別クラスに呼び出せる
        val apiUrl = "http://mattun-pattun.com/api/delete";
        val result = HitAPITask().execute(apiUrl, "DELETE")
//        val parentJsonObj = JSONObject(result)
        println(result)

    }
}
