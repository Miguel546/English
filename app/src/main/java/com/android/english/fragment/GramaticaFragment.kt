package com.android.english.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.android.english.BasicActivity
import com.android.english.R

class GramaticaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val recyclerView: RecyclerView = inflater.inflate(
            R.layout.recycler_view, container, false
        ) as RecyclerView
        //        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //linearLayout = (LinearLayout) rootView.findViewById(R.id.linearlayout);
        return inflater.inflate(R.layout.fragment_gramatica, container, false)
        //return recyclerView;
    }

    inner class ViewHolder(inflater: LayoutInflater, parent: ViewGroup?) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.fragment_gramatica, parent, false)) {
        var avator: ImageView
        var name: TextView
        var description: TextView

        init {
            avator = itemView.findViewById(R.id.list_avatar)
            name = itemView.findViewById(R.id.list_title)
            description = itemView.findViewById(R.id.list_desc)
            itemView.setOnClickListener(View.OnClickListener { v ->
                Log.d("clickItem", v.id.toString())
                Log.d("clickItem", (name.text as String))
                val context = v.context
                if (name.text == "People") {
                    Toast.makeText(v.context, name.text, Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, PeopleFragment::class.java)
                    intent.putExtra("item", name.text as String)
                    //intent.putExtra(PeopleFragment.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent)
                } else if (name.text == "Pronouns") {
                    Toast.makeText(v.context, name.text, Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, BasicActivity::class.java)
                    intent.putExtra("item", name.text as String)
                    intent.putExtra("position", getAdapterPosition())
                    context.startActivity(intent)
                } else if (name.text == "Possessive pronouns") {
                    Toast.makeText(v.context, name.text, Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, BasicActivity::class.java)
                    intent.putExtra("item", name.text as String)
                    intent.putExtra("position", getAdapterPosition())
                    context.startActivity(intent)
                } else if (name.text == "Conditionals") {
                    Toast.makeText(
                        activity!!.applicationContext,
                        "click condicionales",
                        Toast.LENGTH_SHORT
                    ).show()
                    Toast.makeText(v.context, name.text, Toast.LENGTH_SHORT).show()
                    val fl =
                        activity!!.findViewById(R.id.frameLayout) as FrameLayout
                    fl.removeAllViews()
                    val conditionalsFragment: Fragment = ConditionalsFragment()
                    val fragmentManager: FragmentManager? = fragmentManager
                    val fragmentTransaction: FragmentTransaction =
                        fragmentManager!!.beginTransaction()
                    fragmentTransaction.replace(R.id.main_content, conditionalsFragment)
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
            })
        }
    }

    override fun onDetach() {
        super.onDetach()
    }
}
