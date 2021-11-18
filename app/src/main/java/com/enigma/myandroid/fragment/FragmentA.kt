package com.enigma.myandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.enigma.myandroid.Commiunicator
import com.enigma.myandroid.CounterHandler
import com.enigma.myandroid.MainActivity
import com.enigma.myandroid.R
import com.enigma.myandroid.databinding.FragmentABinding
import com.google.android.material.button.MaterialButton

class FragmentA : Fragment() {
    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!
    private lateinit var counterHandler: CounterHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        counterHandler = activity as CounterHandler
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            incrementBtn.setOnClickListener {
                counterHandler.notifyIncrement()
            }
            decrementBtn.setOnClickListener {
                counterHandler.notifyDecrement()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}