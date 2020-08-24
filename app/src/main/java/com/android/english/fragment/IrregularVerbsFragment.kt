package com.android.english.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.english.R

class IrregularVerbs : Fragment() {
    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {
        val recyclerView: RecyclerView = inflater.inflate(
            R.layout.recycler_view, container, false
        ) as RecyclerView
        val adapter =
            ContentAdapter(recyclerView.getContext())
        recyclerView.setAdapter(adapter)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(activity))
        return recyclerView
    }

    class ViewHolder(inflater: LayoutInflater, parent: ViewGroup?) :
        RecyclerView.ViewHolder(
            inflater.inflate(
                R.layout.fragment_irregular_verbs,
                parent,
                false
            )
        ) {
        var baseForm: TextView
        var pastTense: TextView
        var pastParticiple: TextView

        init {
            baseForm = itemView.findViewById(R.id.baseForm)
            pastTense = itemView.findViewById(R.id.pastTense)
            pastParticiple = itemView.findViewById(R.id.pastParticiple)
        }
    }

    class ContentAdapter(context: Context) :
        RecyclerView.Adapter<ViewHolder?>() {
        // Set numbers of List in RecyclerView.
        private val mBaseForm: Array<String>
        private val mPastTense: Array<String>
        private val mPastParticiple: Array<String>
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context), parent)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.baseForm.text = mBaseForm[position % mBaseForm.size]
            holder.pastTense.text = mPastTense[position % mPastTense.size]
            holder.pastParticiple.text = mPastParticiple[position % mPastParticiple.size]
        }


        init {
            val resources = context.resources
            mBaseForm = resources.getStringArray(R.array.baseForm)
            mPastTense = resources.getStringArray(R.array.pastTense)
            mPastParticiple = resources.getStringArray(R.array.pastParticiple)
        }

        override fun getItemCount(): Int {
            return mBaseForm.size
        }
    }

    override fun onDetach() {
        super.onDetach()
    }
}
