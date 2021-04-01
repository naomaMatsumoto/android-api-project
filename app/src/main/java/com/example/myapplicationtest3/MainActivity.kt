package com.example.myapplicationtest3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.json.JSONObject
import com.google.android.material.navigation.NavigationView;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        setContentView(R.layout.bottom_navigation)
//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
//        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.homeTab -> {
//                }
//                R.id.historyTab -> {
//                }
//                R.id.favouriteTab -> {
//                }
//            }
//            false
//        }

        // 別クラスに呼び出せる
        val apiUrl = "http://mattun-pattun.com/api/delete";
        val result = HitAPITask().execute(apiUrl, "DELETE")
//        val parentJsonObj = JSONObject(result)
        println(result)


        //表示用サンプルデータの作成//
        val x = listOf<Float>(1f, 2f, 3f, 5f, 8f, 13f, 21f, 34f)//X軸データ
        val y = x.map{it*it}//Y軸データ（X軸の2乗）

        //①Entryにデータ格納
        var entryList = mutableListOf<Entry>()//1本目の線
        for(i in x.indices){
            entryList.add(
                Entry(x[i], y[i])
            )
        }

        //LineDataSetのList
        val lineDataSets = mutableListOf<ILineDataSet>()
        //②DataSetにデータ格納
        val lineDataSet = LineDataSet(entryList as List<Entry>?, "square")
        //③DataSetにフォーマット指定(3章で詳説)
        lineDataSet.color = Color.BLUE
        //リストに格納
        lineDataSets.add(lineDataSet)

        //④LineDataにLineDataSet格納
        val lineData = LineData(lineDataSets)
        //⑤LineChartにLineData格納
        val lineChart: LineChart = findViewById(R.id.lineChartExample)
        lineChart.data = lineData
        //⑥Chartのフォーマット指定(3章で詳説)
        //X軸の設定
        lineChart.xAxis.apply {
            isEnabled = true
            textColor = Color.BLACK
        }
        //左Y軸の設定 → フォーマット指定処理
//        lineChart.axisLeft.apply {
//            isEnabled = true
//            textColor = Color.BLACK
//            axisMinValue = -3.0f
//        }
        println(lineChart)


        //⑦linechart更新
        lineChart.invalidate()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}