package com.example.myjepckmvvm.navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myjepckmvvm.R
import com.example.myjepckmvvm.databinding.FragmentPage2Binding

class Page2Fragment : Fragment() {


    private var _binding: FragmentPage2Binding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPage2Binding.inflate(inflater, container, false)

        val root: View = binding.root
        val userName = arguments?.getString("userName")

        Toast.makeText(requireContext(), userName, Toast.LENGTH_SHORT).show()

        root.findViewById<Button>(R.id.bn2).setOnClickListener {
            // 使用 Navigation 跳转，传递的 ID 为导航图中 Action标签声明的 ID
            findNavController().navigate(R.id.action_page2_to_page1)
        }
        return root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}