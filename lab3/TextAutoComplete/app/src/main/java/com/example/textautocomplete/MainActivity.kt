package com.example.textautocomplete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<EditText>(R.id.first_name).setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEND -> {
                    sendMessage()
                    true
                }
                else -> false
            }
        }

        // Get a reference to the AutoCompleteTextView in the layout
        val textView = findViewById(R.id.autocomplete_country) as AutoCompleteTextView
        // Get the string array
        val countries: Array<out String> =
            resources.getStringArray(R.array.countries_array)
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String>(
            this, android.R.layout.simple_list_item_1,
            countries
        ).also { adapter ->
            textView.setAdapter(adapter)
        }
    }

    private fun sendMessage() {
        val editText = findViewById<EditText>(R.id.first_name)
        val message = editText.text.toString()
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

}