package com.enigma.myandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.enigma.myandroid.Commiunicator
import com.enigma.myandroid.R
import com.google.android.material.button.MaterialButton

class FragmentB : Fragment() {

    var displayMessage = ""
    private lateinit var commiunicator: Commiunicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_b, container, false)

        val textView = view.findViewById<TextView>(R.id.data_fragment2)
        val backBtn = view.findViewById<MaterialButton>(R.id.backBtn)
        displayMessage = arguments?.getString("message").toString()

        textView.text = displayMessage

        commiunicator = activity as Commiunicator

        backBtn.setOnClickListener {
            commiunicator.backToFragmentA()
        }

        return view
    }
}