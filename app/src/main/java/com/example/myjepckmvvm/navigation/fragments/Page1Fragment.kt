package com.example.myjepckmvvm.navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myjepckmvvm.R
import com.example.myjepckmvvm.databinding.FragmentPage1Binding

class Page1Fragment : Fragment() {
    private var _binding: FragmentPage1Binding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPage1Binding.inflate(inflater, container, false)

        val root: View = binding.root
        root.findViewById<Button>(R.id.bn1).setOnClickListener {
            val bundle = bundleOf("userName" to "abc")
            // 使用 Navigation 跳转，传递的 ID 为导航图中 Action标签声明的 ID
            findNavController().navigate(R.id.action_page1_to_page2, bundle)
        }

        return root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}