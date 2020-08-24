package com.android.english.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.english.R

class PersonaAdapter(private val personas: Array<String>) :
    RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        return PersonaViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        holder.tviPersona.text = personas[position]
    }



    inner class PersonaViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_textview, parent, false)) {
        val tviPersona: TextView

        init {
            tviPersona = itemView.findViewById(R.id.tviitem)
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return personas.size
    }

}