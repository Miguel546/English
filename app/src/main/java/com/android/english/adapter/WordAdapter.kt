package com.android.english.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.android.english.R
import com.android.english.fragment.DiFragment

class WordAdapter(
    private val palabras: Array<String>,
    private val significados: Array<String>,
    fragmentManager: FragmentManager
) :
    RecyclerView.Adapter<WordAdapter.WordViewHolder?>() {
    private val context: Context? = null
    private val fragmentManager: FragmentManager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.tviWord.text = palabras[position]
        holder.tviSignificado.text = significados[position]
        holder.itemView.setOnClickListener(View.OnClickListener {
            val dFragment = DiFragment()
            dFragment.newInstance("Hola", holder.tviWord.text as String)
            dFragment.show(fragmentManager, "Hola")
        })
    }

    inner class WordViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_vocabulary, parent, false)) {
        val tviWord: TextView
        val tviSignificado: TextView
        fun bind(item: WordViewHolder?, listener: OnItemClickListener?) {}

        init {
            tviWord = itemView.findViewById(R.id.tvWord)
            tviSignificado = itemView.findViewById(R.id.tvMeaning)
        }
    }

    init {
        this.fragmentManager = fragmentManager
    }

    override fun getItemCount(): Int {
       return palabras.size
    }
}

