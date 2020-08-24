package com.android.english

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.english.adapter.WordAdapter
import com.android.english.fragment.DiFragment

class WordsActivity : AppCompatActivity() {
    var imagenVocabulario: ImageView? = null
    private var adaptador: WordAdapter? = null
    private var recyclerVocabulary: RecyclerView? = null
    val TAG = "WordActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words)
        val intent = intent
        val item = intent.getStringExtra("itemVocabulary")
        imagenVocabulario = findViewById(R.id.imageVocabulary) as ImageView
        recyclerVocabulary = findViewById(R.id.recyclerwords) as RecyclerView?
        val fm: FragmentManager = supportFragmentManager
        val dFragment = DiFragment()
        if (item == "Warehouse") {
            imagenVocabulario!!.setImageResource(R.drawable.warehouse)
            adaptador = WordAdapter(
                applicationContext.resources.getStringArray(R.array.warehouseWords),
                applicationContext.resources.getStringArray(R.array.warehouseMeanings),
                fm
            )
        } else if (item == "Office") {
            imagenVocabulario!!.setImageResource(R.drawable.office)
            adaptador = WordAdapter(
                applicationContext.resources.getStringArray(R.array.officeWords),
                applicationContext.resources.getStringArray(R.array.officeMeanings),
                fm
            )
        } else if (item == "Doctors office") {
            imagenVocabulario!!.setImageResource(R.drawable.doctorsoffice)
            adaptador = WordAdapter(
                applicationContext.resources.getStringArray(R.array.doctorofficeWords),
                applicationContext.resources.getStringArray(R.array.doctorofficeMeanings),
                fm
            )
        } else if (item == "Laboratory") {
            imagenVocabulario!!.setImageResource(R.drawable.laboratory)
            adaptador = WordAdapter(
                applicationContext.resources.getStringArray(R.array.laboratoryWords),
                applicationContext.resources.getStringArray(R.array.laboratoryMeanings),
                fm
            )
        } else if (item == "Hotel") {
            imagenVocabulario!!.setImageResource(R.drawable.hotel)
            adaptador = WordAdapter(
                applicationContext.resources.getStringArray(R.array.hotelWord),
                applicationContext.resources.getStringArray(R.array.hotelMeaning),
                fm
            )
        } else if (item == "Police station") {
            imagenVocabulario!!.setImageResource(R.drawable.policestation)
            adaptador = WordAdapter(
                applicationContext.resources.getStringArray(R.array.policestationWord),
                applicationContext.resources.getStringArray(R.array.policestationMeaning),
                fm
            )
        } else if (item == "Theater") {
            imagenVocabulario!!.setImageResource(R.drawable.theater)
            adaptador = WordAdapter(
                applicationContext.resources.getStringArray(R.array.theaterWord),
                applicationContext.resources.getStringArray(R.array.theaterMeaning),
                fm
            )
        } else if (item == "Train station") {
            imagenVocabulario!!.setImageResource(R.drawable.trainstation)
            adaptador = WordAdapter(
                applicationContext.resources.getStringArray(R.array.theaterWord),
                applicationContext.resources.getStringArray(R.array.theaterMeaning),
                fm
            )
        } else if (item == "Bank") {
            imagenVocabulario!!.setImageResource(R.drawable.interbank)
            adaptador = WordAdapter(
                applicationContext.resources.getStringArray(R.array.bankWords),
                applicationContext.resources.getStringArray(R.array.bankMeanings),
                fm
            )
        } else if (item == "Post office") {
            imagenVocabulario!!.setImageResource(R.drawable.postoffice)
            adaptador = WordAdapter(
                applicationContext.resources.getStringArray(R.array.postOfficeWords),
                applicationContext.resources.getStringArray(R.array.postOfficeMeanings),
                fm
            )
        } else if (item == "Restaurant") {
            imagenVocabulario!!.setImageResource(R.drawable.restaurant)
            adaptador = WordAdapter(
                applicationContext.resources.getStringArray(R.array.restaurantWord),
                applicationContext.resources.getStringArray(R.array.restaurantMeaning),
                fm
            )
        } else if (item == "Real state agency") {
            imagenVocabulario!!.setImageResource(R.drawable.realstateagency)
            adaptador = WordAdapter(
                applicationContext.resources.getStringArray(R.array.realStateAgencyWord),
                applicationContext.resources
                    .getStringArray(R.array.realStateAgencyMeaning),
                fm
            )
        }
        recyclerVocabulary!!.setLayoutManager(LinearLayoutManager(this@WordsActivity))
        recyclerVocabulary!!.setHasFixedSize(true)
        recyclerVocabulary!!.setAdapter(adaptador)
    }
}