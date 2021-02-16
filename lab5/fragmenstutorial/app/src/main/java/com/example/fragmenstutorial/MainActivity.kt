package com.example.fragmenstutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if (savedInstanceState == null) {
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.container, MainFragment())
//                .commit()
//        }
        passValues()
    }

    private fun passValues() {
        val data = "kku"
        val bundle = Bundle().apply {
            putString("EXTRA_KEY" ,data)
        }
        val fragment = MainFragment().apply {
            arguments = bundle
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}