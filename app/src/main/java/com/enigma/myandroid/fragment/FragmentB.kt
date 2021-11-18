package com.enigma.myandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.enigma.myandroid.Commiunicator
import com.enigma.myandroid.MainActivity
import com.enigma.myandroid.R
import com.enigma.myandroid.databinding.FragmentBBinding
import com.google.android.material.button.MaterialButton

class FragmentB : Fragment() {

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun notifyShowCounter(counter: Int) {
        binding.counterTv.text = counter.toString()
    }

}