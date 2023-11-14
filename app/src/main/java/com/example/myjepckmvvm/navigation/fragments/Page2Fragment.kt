package com.example.myjepckmvvm.navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myjepckmvvm.R

class Page2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_page2, container, false)


        view.findViewById<Button>(R.id.bn2).setOnClickListener {
            // 使用 Navigation 跳转，传递的 ID 为导航图中 Action标签声明的 ID
            findNavController().navigate(R.id.action_page2_to_page1)
        }


        return view

    }

}