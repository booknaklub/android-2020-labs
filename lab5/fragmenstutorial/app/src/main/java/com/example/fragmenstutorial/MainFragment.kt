package com.example.fragmenstutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment


public final class MainFragment :Fragment() {
    var curView:View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       curView = inflater?.inflate(
           R.layout.main_fragment,
           container,false
       )
        val view:View? = curView
        val button:Button? = view?.findViewById<Button>(R.id.button)
        button?.setOnClickListener {
            val editText = view?.findViewById<EditText>(R.id.editText)
            val resultText = view?.findViewById<TextView>(R.id.textView)
            resultText.text = editText.text.toString()
        }
        getValues()
        return curView
    }

    private fun getValues() {
        val key: String? = arguments?.getString("EXTRA_KEY")
        Toast.makeText(this.context, key,
            Toast.LENGTH_LONG).show()
        var resultText = curView?.findViewById<TextView>(R.id.textView)
        if (resultText != null) {
            resultText.text = key
        }
    }
}