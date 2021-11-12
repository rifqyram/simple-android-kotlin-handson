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
import com.google.android.material.button.MaterialButton

class FragmentA : Fragment() {

    private lateinit var communicator: Commiunicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_a, container, false)

        communicator = activity as Commiunicator

        val btn = view.findViewById<MaterialButton>(R.id.sendBtn)
        val textView = view.findViewById<TextView>(R.id.input_text)

        btn.setOnClickListener {
            communicator.passDataCom(textView.text.toString())
        }

        return view
    }
}