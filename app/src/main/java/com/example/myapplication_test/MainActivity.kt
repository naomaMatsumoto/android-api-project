package com.example.myapplication_test


//import com.example.myapplication_test.ui.dashboard.DashboardFragment
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication_test.ui.notifications.NotificationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_notifications,
                R.id.navigation_dashboard,
                R.id.navigation_dashboard1
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // 別クラスに呼び出せる
//        val apiUrl = "http://mattun-pattun.com/api/delete";
//        val result = HitAPITask().execute(apiUrl, "DELETE")
//        println(result)








//        R.id.navigation_notifications

        // FragmentManagerのインスタンス生成

//        val menu1 = MenuItem.findItem(R.id.navigation_notifications) // menu1取得
//        menu1.isVisible = false　// 隠す
    }
//    override fun onCreateOptionsMenu(menu: Menu?): Void {
////        super.onCreateOptionsMenu(menu, inflater)
//        menuInflater.inflate(R.menu.bottom_nav_menu, menu)
//
////        val inflater: MenuInflater = inflater
////        inflater.inflate(R.menu.bottom_nav_menu, menu)
//
//
////        val item = menu?.findItem(R.id.navigation_notifications)
//        val item = menu?.removeItem(R.id.navigation_notifications)
////        item?.isVisible = true
//    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.bottom_nav_menu, menu)

        val item = menu?.findItem(R.id.navigation_notifications)
//        val item = menu?.removeItem(R.id.navigation_notifications)
        item?.isVisible = true

        return true
    }
}