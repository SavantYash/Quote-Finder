package com.example.test123.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test123.R
import com.example.test123.viewmodel.QuoteViewModel

class QuoteFragment : Fragment() {
    private lateinit var viewModel: QuoteViewModel
    private lateinit var adapter: QuoteAdapter
    private var filter: String = "ALL"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        filter = arguments?.getString("FILTER") ?: "ALL"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragement_quote, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[QuoteViewModel::class.java]
        adapter = QuoteAdapter(viewModel)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerQuotes)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.loadQuotes(filter)
        viewModel.quotes.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    companion object {
        fun newInstance(filter: String) = QuoteFragment().apply {
            arguments = Bundle().apply { putString("FILTER", filter) }
        }
    }
}
