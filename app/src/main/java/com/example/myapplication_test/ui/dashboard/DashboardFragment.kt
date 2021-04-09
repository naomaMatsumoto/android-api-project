package com.example.myapplication_test.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
        }
        return root
    }

}