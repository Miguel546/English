package com.android.english.fragment

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.english.R
import com.android.english.WordsActivity

class VocabularioFragment  // TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val recyclerView: RecyclerView = inflater.inflate(
            R.layout.recycler_view, container, false
        ) as RecyclerView
        val adapter = ContentAdapter(recyclerView.getContext())
        recyclerView.setAdapter(adapter)
        recyclerView.setHasFixedSize(true)
        // Set padding for Tiles
        val tilePadding = resources.getDimensionPixelSize(R.dimen.tile_padding)
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding)
        recyclerView.setLayoutManager(GridLayoutManager(activity, 2))
        return recyclerView
    }

    class ViewHolder(inflater: LayoutInflater, parent: ViewGroup?) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.fragment_vocabulario, parent, false)) {
        var picture: ImageView
        var name: TextView

        init {
            picture = itemView.findViewById(R.id.tile_picture)
            name = itemView.findViewById(R.id.tile_title)
            itemView.setOnClickListener(View.OnClickListener { v ->
                val context = v.context
                val intent = Intent(context, WordsActivity::class.java)
                intent.putExtra("itemVocabulary", name.text)
                context.startActivity(intent)
            })
        }
    }

    /**
     * Adapter to display recycler view.
     */
    class ContentAdapter(context: Context) :
        RecyclerView.Adapter<ViewHolder?>() {
        // Set numbers of Tiles in RecyclerView.
        private val mPlaces: Array<String>
        private val mPlacePictures: Array<Drawable?>
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context), parent)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.picture.setImageDrawable(mPlacePictures[position % mPlacePictures.size])
            holder.name.text = mPlaces[position % mPlaces.size]
        }

        init {
            val resources = context.resources
            mPlaces = resources.getStringArray(R.array.vocabularyTiles)
            val a = resources.obtainTypedArray(R.array.vocabularyImages)
            mPlacePictures = arrayOfNulls(a.length())
            for (i in mPlacePictures.indices) {
                mPlacePictures[i] = a.getDrawable(i)
            }
            a.recycle()
        }

        override fun getItemCount(): Int {
            return mPlaces.size
        }
    }

    override fun onDetach() {
        super.onDetach()
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri?)
    }
}