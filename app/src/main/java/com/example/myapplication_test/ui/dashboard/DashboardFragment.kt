package com.example.myapplication_test.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication_test.HitAPITask
import com.example.myapplication_test.R

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: Dashboard1ViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(Dashboard1ViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)


        val addFragment = root.findViewById<Button>(R.id.btnSend)
        addFragment.setOnClickListener {
            println("aaaaa")
//            val email = root.findViewById(R.id.login_email)
            val email = root.findViewById<EditText>(R.id.login_email)
            val password = root.findViewById<EditText>(R.id.login_password)
            println(email.text)
            println(password.text)

            // 別クラスに呼び出せる
            val apiUrl = "http://mattun-pattun.com/api/delete";
            val result = HitAPITask().execute(apiUrl, "DELETE")
            println(result)

        }
        return root
    }

}