package com.example.myapplicationtest3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
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
        val lineChart: com.github.mikephil.charting.charts.LineChart = findViewById(R.id.lineChartExample)
        lineChart.data = lineData
        //⑥Chartのフォーマット指定(3章で詳説)
        //X軸の設定
        lineChart.xAxis.apply {
            val isEnabled = true
            val textColor = Color.BLACK
        }
        //⑦linechart更新
        lineChart.invalidate()
    }
}
