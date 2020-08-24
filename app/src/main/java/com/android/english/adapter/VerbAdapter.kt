package com.android.english.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.android.english.R

class VerbAdapter(
    private val firstPartArray: Array<String>,
    private val secondPartArray: Array<String>,
    private val thirdPartArray: Array<String>
) :
    RecyclerView.Adapter<VerbAdapter.VerbViewHolder?>() {
    private val context: Context? = null
    private val fragmentManager: FragmentManager? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerbViewHolder {
        return VerbViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: VerbViewHolder, position: Int) {
        holder.tviFirstPart.text = firstPartArray[position]
        holder.tviSecondPart.text = secondPartArray[position]
        holder.tviThirdPart.text = thirdPartArray[position]
    }


    inner class VerbViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_verbs, parent, false)) {
        val tviFirstPart: TextView
        val tviSecondPart: TextView
        val tviThirdPart: TextView

        init {
            tviFirstPart = itemView.findViewById(R.id.firstPart)
            tviSecondPart = itemView.findViewById(R.id.secondPart)
            tviThirdPart = itemView.findViewById(R.id.thirdPart)
        }
    }

    override fun getItemCount(): Int {
        return firstPartArray.size
    }

}
