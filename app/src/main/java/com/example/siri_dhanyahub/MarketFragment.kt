package com.example.siri_dhanyahub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarketFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =
            inflater.inflate(
                R.layout.fragment_market,
                container,
                false
            )

        recyclerView =
            view.findViewById(R.id.recyclerViewMarket)

        recyclerView.layoutManager =
            LinearLayoutManager(requireContext())

        loadPrices()

        return view
    }

    private fun loadPrices() {

        RetrofitClient.apiService.getPrices()
            .enqueue(object : Callback<List<MarketPrice>> {

                override fun onResponse(
                    call: Call<List<MarketPrice>>,
                    response: Response<List<MarketPrice>>
                ) {

                    Toast.makeText(
                        requireContext(),
                        "Response Received",
                        Toast.LENGTH_SHORT
                    ).show()

                    if (response.isSuccessful) {

                        val list = response.body() ?: emptyList()

                        Toast.makeText(
                            requireContext(),
                            "Items: ${list.size}",
                            Toast.LENGTH_LONG
                        ).show()

                        recyclerView.adapter =
                            MarketAdapter(list)

                    } else {

                        Toast.makeText(
                            requireContext(),
                            "Failed Code: ${response.code()}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(
                    call: Call<List<MarketPrice>>,
                    t: Throwable
                ) {

                    Toast.makeText(
                        requireContext(),
                        "ERROR: ${t.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }
}