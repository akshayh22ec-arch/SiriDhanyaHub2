package com.example.siri_dhanyahub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class BuyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_buy,
            container,
            false
        )

        val btn1 = view.findViewById<Button>(R.id.btnContact1)
        val btn2 = view.findViewById<Button>(R.id.btnContact2)

        btn1.setOnClickListener {

            Toast.makeText(
                requireContext(),
                "Connecting to Davangere Millet FPO",
                Toast.LENGTH_SHORT
            ).show()
        }

        btn2.setOnClickListener {

            Toast.makeText(
                requireContext(),
                "Connecting to Bengaluru Organic FPO",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view
    }
}