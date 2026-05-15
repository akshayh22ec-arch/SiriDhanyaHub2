package com.example.siri_dhanyahub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation =
            findViewById<BottomNavigationView>(R.id.bottomNavigation)

        // Default Fragment
        loadFragment(HomeFragment())

        bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }

                R.id.nav_market -> {
                    loadFragment(MarketFragment())
                    true
                }

                R.id.nav_health -> {
                    loadFragment(HealthFragment())
                    true
                }

                R.id.nav_recipe -> {
                    loadFragment(RecipeFragment())
                    true
                }

                R.id.nav_buy -> {
                    loadFragment(BuyFragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}