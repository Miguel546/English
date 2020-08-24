package com.android.english

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.english.adapter.PersonaAdapter

class BasicActivity : AppCompatActivity() {
    private var listPersonas: RecyclerView? = null
    private var listPersonas2: RecyclerView? = null
    private var adaptador: PersonaAdapter? = null
    private var adaptador2: PersonaAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
        val intent = intent
        val item = intent.getStringExtra("item")
        Log.d("clickItem", "En el actividad BasicActivity")
        Log.d(
            "clickItem",
            "Cuando de noche llegues a tu casa y el alma sientas herida"
        )
        Log.d("clickItem", item!!)
        listPersonas = findViewById(R.id.ab_recycler_view) as RecyclerView?
        listPersonas2 = findViewById(R.id.ab2_recycler_view) as RecyclerView?
        if (item == "People") {
            adaptador = PersonaAdapter(
                applicationContext.resources.getStringArray(R.array.peopleSingular)
            )
            adaptador2 = PersonaAdapter(
                applicationContext.resources.getStringArray(R.array.peoplePlural)
            )
        } else if (item == "Pronouns") {
            adaptador = PersonaAdapter(
                applicationContext.resources.getStringArray(R.array.pronounsSingular)
            )
            adaptador2 = PersonaAdapter(
                applicationContext.resources.getStringArray(R.array.pronounsPlural)
            )
        } else if (item == "Possessive pronouns") {
            adaptador = PersonaAdapter(
                applicationContext.resources
                    .getStringArray(R.array.possesivePronounsSingular)
            )
            adaptador2 = PersonaAdapter(
                applicationContext.resources
                    .getStringArray(R.array.possesivePronounsPlural)
            )
        }
        listPersonas!!.setLayoutManager(LinearLayoutManager(this@BasicActivity))
        listPersonas!!.setHasFixedSize(true)
        listPersonas!!.setAdapter(adaptador)
        listPersonas2!!.setLayoutManager(LinearLayoutManager(this@BasicActivity))
        listPersonas2!!.setHasFixedSize(true)
        listPersonas2!!.setAdapter(adaptador2)
    }

    override fun onResume() {
        super.onResume()
    }

    companion object {
        const val EXTRA_POSITION = "position"
    }
}
