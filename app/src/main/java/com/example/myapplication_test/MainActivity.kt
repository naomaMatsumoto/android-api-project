package com.example.myapplication_test

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController


import android.graphics.Color
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
//import com.example.myapplication_test.ui.dashboard.DashboardFragment
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import org.json.JSONObject
import com.google.android.material.navigation.NavigationView;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_notifications, R.id.navigation_dashboard, R.id.navigation_dashboard1))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // 別クラスに呼び出せる
        val apiUrl = "http://mattun-pattun.com/api/delete";
        val result = HitAPITask().execute(apiUrl, "DELETE")
        println(result)

//        setContentView(R.layout.fragment_dashboard)

//        try {
//            val btnSend: Button =  R.layout._dafragmentshboard.findViewById(R.id.btnSend)
//        } catch (e: Exception) {
//            println("error")
//            println(e)
//        }
//        println(btnSend)
//        btnSend.setOnClickListener {
//            val aaa = "aaa";
//            val textView: TextView = findViewById(R.id.text_home)
//        }

//        val hogeFragment = DashboardFragment()
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.container, hogeFragment)
//        transaction.commit()

//        fun onHogeFragmentAddFragment() {
//            val hugaFragment = DashboardFragment()
//            val transaction = supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.container, hugaFragment)
//            transaction.addToBackStack(null) // バックスタックに保存する。呼び出さなければ積まれない。
//            transaction.commit()
//        }
    }

    // MARK: OnboardSignUpTermsOfServiceListener
    fun onClickNext() {
        // TODO: Handle events.
        println("bbbb")
    }

}