package com.enigma.myandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.enigma.myandroid.fragment.FragmentA
import com.enigma.myandroid.fragment.FragmentB

class MainActivity : AppCompatActivity(), Commiunicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA = FragmentA()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentA)
            .commit()
    }

    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("message", editTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentB = FragmentB()
        fragmentB.arguments = bundle
        transaction.replace(R.id.fragment_container, fragmentB)
        transaction.commit()
    }

    override fun backToFragmentA() {
        val fragmentA = FragmentA()
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragmentA).commit()
    }
}