package com.example.test123.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test123.R
import com.example.test123.model.datamodel.Quote
import com.example.test123.viewmodel.QuoteViewModel

class QuoteAdapter(private val viewModel: QuoteViewModel) :
    ListAdapter<Quote, QuoteAdapter.QuoteViewHolder>(DiffCallback()) {

    class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtQuote: TextView = itemView.findViewById(R.id.txtQuote)
        val btnStar: ImageButton = itemView.findViewById(R.id.btnStar)
        val btnHeart: ImageButton = itemView.findViewById(R.id.btnHeart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quote, parent, false)
        return QuoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val quote = getItem(position)
        holder.txtQuote.text = quote.statement
        holder.btnStar.setImageResource(if (quote.isStarred) R.drawable.ic_star_filled else R.drawable.ic_star_outline)
        holder.btnHeart.setImageResource(if (quote.isHearted) R.drawable.ic_heart_filled else R.drawable.ic_heart_outline)

        holder.btnStar.setOnClickListener { viewModel.toggleStar(quote) }
        holder.btnHeart.setOnClickListener { viewModel.toggleHeart(quote) }
    }

    class DiffCallback : DiffUtil.ItemCallback<Quote>() {
        override fun areItemsTheSame(oldItem: Quote, newItem: Quote) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Quote, newItem: Quote) = oldItem == newItem
    }
}

