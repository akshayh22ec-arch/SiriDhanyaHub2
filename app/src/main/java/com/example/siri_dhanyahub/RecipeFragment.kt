package com.example.siri_dhanyahub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecipeFragment : Fragment() {

    private lateinit var recipeRecyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var recipeList: ArrayList<Recipe>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_recipe,
            container,
            false
        )

        // Initialize Views

        recipeRecyclerView =
            view.findViewById(R.id.recipeRecyclerView)

        searchView =
            view.findViewById(R.id.searchView)

        // RecyclerView Layout

        recipeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())

        recipeRecyclerView.setHasFixedSize(true)

        // Recipe Data

        recipeList = arrayListOf(

            Recipe(
                "Ragi Mudde",

                "• 1 cup Ragi Flour\n" +
                        "• 2 cups Water\n" +
                        "• Salt",

                "1. Take a vessel and boil 2 cups water.\n\n" +
                        "2. Add salt to boiling water.\n\n" +
                        "3. Slowly add ragi flour.\n\n" +
                        "4. Stir continuously to avoid lumps.\n\n" +
                        "5. Cook for 5 minutes.\n\n" +
                        "6. Prepare round mudde balls.\n\n" +
                        "7. Serve hot with curry.",

                "Rich in calcium and good for diabetes."
            ),

            Recipe(
                "Navane Pongal",

                "• 1 cup Foxtail Millet\n" +
                        "• 1/2 cup Moong Dal\n" +
                        "• 3 cups Water\n" +
                        "• Pepper\n" +
                        "• Ginger\n" +
                        "• Ghee",

                "1. Wash millet and dal properly.\n\n" +
                        "2. Soak for 10 minutes.\n\n" +
                        "3. Add 3 cups water.\n\n" +
                        "4. Pressure cook for 3 whistles.\n\n" +
                        "5. Prepare pepper seasoning.\n\n" +
                        "6. Add ghee and mix.\n\n" +
                        "7. Serve hot.",

                "Improves digestion and heart health."
            ),

            Recipe(
                "Sajje Roti",

                "• 1 cup Pearl Millet Flour\n" +
                        "• Warm Water\n" +
                        "• Salt\n" +
                        "• Ghee",

                "1. Add flour into bowl.\n\n" +
                        "2. Add warm water slowly.\n\n" +
                        "3. Prepare soft dough.\n\n" +
                        "4. Roll into round roti.\n\n" +
                        "5. Cook on hot pan.\n\n" +
                        "6. Apply little ghee.\n\n" +
                        "7. Serve hot.",

                "High fiber food and improves digestion."
            )
        )

        // Adapter

        recipeAdapter = RecipeAdapter(recipeList)

        recipeRecyclerView.adapter = recipeAdapter

        // Search Functionality

        searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    filterRecipes(newText)

                    return true
                }
            })

        return view
    }

    // Filter Function

    private fun filterRecipes(text: String?) {

        val filteredList = ArrayList<Recipe>()

        for (recipe in recipeList) {

            if (recipe.name.lowercase()
                    .contains(text.toString().lowercase())
            ) {

                filteredList.add(recipe)
            }
        }

        recipeAdapter.filterList(filteredList)
    }
}