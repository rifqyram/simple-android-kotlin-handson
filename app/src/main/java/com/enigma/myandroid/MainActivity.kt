package com.enigma.myandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.enigma.myandroid.databinding.ActivityMainBinding
import com.enigma.myandroid.fragment.FragmentA
import com.enigma.myandroid.fragment.FragmentB

class MainActivity : AppCompatActivity(), CounterHandler {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentA: FragmentA
    private lateinit var fragmentB: FragmentB
    var counter = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentA = FragmentA()
        fragmentB = FragmentB()

        with(binding) {
            supportFragmentManager.beginTransaction().add(fragmentCounter.id, fragmentA).commit()
            supportFragmentManager.beginTransaction().add(fragmentCounterShow.id, fragmentB).commit()
        }
    }

    override fun notifyIncrement() {
        counter++
        Log.i("Inc", "notifyIncrement: $counter")
        fragmentB.notifyShowCounter(counter)
    }

    override fun notifyDecrement() {
        if (counter > 0) {
            counter--
            fragmentB.notifyShowCounter(counter)
        } else {
            fragmentB.notifyShowCounter(0)
        }
        Log.i("Dec", "notifyDecrement: $counter")
    }
}