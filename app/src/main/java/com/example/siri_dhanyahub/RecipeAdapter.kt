package com.example.siri_dhanyahub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(
    private var recipeList: List<Recipe>
) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name = view.findViewById<TextView>(R.id.txtRecipeName)
        val ingredients = view.findViewById<TextView>(R.id.txtIngredients)
        val procedure = view.findViewById<TextView>(R.id.txtProcedure)
        val benefits = view.findViewById<TextView>(R.id.txtBenefits)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val recipe = recipeList[position]

        holder.name.text = recipe.name
        holder.ingredients.text = recipe.ingredients
        holder.procedure.text = recipe.procedure
        holder.benefits.text = recipe.benefits
    }

    override fun getItemCount() = recipeList.size

    fun filterList(filteredList: List<Recipe>) {
        recipeList = filteredList
        notifyDataSetChanged()
    }
}