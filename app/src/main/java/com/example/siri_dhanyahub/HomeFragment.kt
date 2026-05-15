// HomeFragment.kt

package com.example.siri_dhanyahub

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.fragment_home,
            container,
            false
        )

        val logoutButton = view.findViewById<Button>(R.id.btnLogout)

        logoutButton.setOnClickListener {

            val sharedPreferences = requireActivity()
                .getSharedPreferences(
                    "UserData",
                    AppCompatActivity.MODE_PRIVATE
                )

            // Logout user
            sharedPreferences.edit()
                .putBoolean("isLoggedIn", false)
                .apply()

            // Open Login Page
            startActivity(
                Intent(requireContext(), LoginActivity::class.java)
            )

            // Close MainActivity
            requireActivity().finish()
        }

        return view
    }
}