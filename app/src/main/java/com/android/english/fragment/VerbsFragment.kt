package com.android.english.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.english.R
import com.android.english.adapter.VerbAdapter
import com.google.android.material.tabs.TabLayout

class VerbsFragment : Fragment() {
    var imagenVocabulario: ImageView? = null
    private var adaptador: VerbAdapter? = null
    private var recyclerVerb: RecyclerView? = null
    private var tabSelected1: String? = null
    private var tabSelected2: String? = null
    private var definitionTimes: TextView? = null
    private var anteriorTab1: String? = ""
    private var anteriorTab2: String? = ""
    override fun onResume() {
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resources = activity!!.resources
        val tabs: TabLayout = view.findViewById<View>(R.id.tabsVerbs) as TabLayout
        definitionTimes = view.findViewById<View>(R.id.definitionTimes) as TextView
        tabs.addTab(tabs.newTab().setText("Present"))
        tabs.addTab(tabs.newTab().setText("Past"))
        tabs.addTab(tabs.newTab().setText("Future"))
        tabs.addTab(tabs.newTab().setText("Modal Verbs"))
        recyclerVerb = view.findViewById<View>(R.id.timesrecyclerview) as RecyclerView
        val tabs2: TabLayout = view.findViewById<View>(R.id.tabsVerbs2) as TabLayout
        if (tabs2.getTabCount() === 0) {
            tabs2.addTab(tabs2.newTab().setText("Present Simple"))
            tabs2.addTab(tabs2.newTab().setText("Present Continuos"))
            tabs2.addTab(tabs2.newTab().setText("Present Perfect"))
            tabs2.addTab(tabs2.newTab().setText("Present perfect continuos"))
            definitionTimes!!.setText(R.string.presentSimple)
            adaptador = VerbAdapter(
                resources.getStringArray(R.array.allPersons),
                resources.getStringArray(R.array.verbsPresentSimple),
                resources.getStringArray(R.array.thirdpartPresentSimple)
            )
            recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
            recyclerVerb!!.setHasFixedSize(true)
            recyclerVerb!!.setAdapter(adaptador)
        }
        tabs.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tabSelected1 = tab.getText().toString()
                if (tabSelected1 == "Present") {
                    tabs2.removeAllTabs()
                    tabs2.addTab(tabs2.newTab().setText("Present Simple"))
                    tabs2.addTab(tabs2.newTab().setText("Present Continuos"))
                    tabs2.addTab(tabs2.newTab().setText("Present Perfect"))
                    tabs2.addTab(tabs2.newTab().setText("Present perfect continuos"))
                    definitionTimes!!.setText(R.string.presentSimple)
                } else if (tabSelected1 == "Past") {
                    tabs2.removeAllTabs()
                    tabs2.addTab(tabs2.newTab().setText("Past Simple"))
                    tabs2.addTab(tabs2.newTab().setText("Past Continuos"))
                    tabs2.addTab(tabs2.newTab().setText("Past Simple Passive"))
                    tabs2.addTab(tabs2.newTab().setText("Past Perfect"))
                    tabs2.addTab(tabs2.newTab().setText("Past Perfect Continuos"))
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsPastSimple),
                        resources.getStringArray(R.array.vacio)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.pastSimple)
                } else if (tabSelected1 == "Future") {
                    tabs2.removeAllTabs()
                    tabs2.addTab(tabs2.newTab().setText("Future: Be going to"))
                    tabs2.addTab(tabs2.newTab().setText("Will"))
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsFutureBeGoingTo),
                        resources.getStringArray(R.array.vacio)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.futureBeGoingTo)
                } else if (tabSelected1 == "Modal Verbs") {
                    tabs2.removeAllTabs()
                    tabs2.addTab(tabs2.newTab().setText("May or might"))
                    tabs2.addTab(tabs2.newTab().setText("Could"))
                    tabs2.addTab(tabs2.newTab().setText("Should"))
                    tabs2.addTab(tabs2.newTab().setText("Must"))
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsMayOrMight),
                        resources.getStringArray(R.array.vacio)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.mayOrMight)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        tabs2.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tabSelected2 = tab.getText().toString()
                anteriorTab1 = if (anteriorTab1 == null) {
                    "Present"
                } else {
                    tabSelected1
                }
                anteriorTab2 = tabSelected2
                Toast.makeText(
                    context,
                    "tabSelected1: $tabSelected1 tabSelected2: $tabSelected2",
                    Toast.LENGTH_SHORT
                ).show()
                if (tabSelected2 == "Present Simple") {
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsPresentSimple),
                        resources.getStringArray(R.array.thirdpartPresentSimple)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.presentSimple)
                } else if (tabSelected2 == "Present Continuos") {
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsPresentContinuos),
                        resources.getStringArray(R.array.thirdpartPresentContinuos)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.presentContinuos)
                } else if (tabSelected2 == "Past Simple") {
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsPastSimple),
                        resources.getStringArray(R.array.vacio)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.pastSimple)
                } else if (tabSelected2 == "Past Continuos") {
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsPastContinuos),
                        resources.getStringArray(R.array.vacio)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.pastContinuos)
                } else if (tabSelected2 == "Past Simple Passive") {
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.firstPartPastSimplePassive),
                        resources.getStringArray(R.array.verbsPastSimplePassive),
                        resources.getStringArray(R.array.thirdpartPastSimplePassive)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.pastSimplePassive)
                } else if (tabSelected2 == "Present Perfect") {
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsPresentPerfect),
                        resources.getStringArray(R.array.vacio)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.presentPerfect)
                } else if (tabSelected2 == "Past Perfect") {
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsPastPerfect),
                        resources.getStringArray(R.array.vacio)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.pastPerfect)
                } else if (tabSelected2 == "Past Perfect Continuos") {
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsPastPerfectContinuos),
                        resources.getStringArray(R.array.vacio)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.pastPerfectContinuos)
                } else if (tabSelected2 == "Present perfect continuos") {
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsPresentPerfectContinuos),
                        resources.getStringArray(R.array.vacio)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.presentPerfectContinuos)
                } else if (tabSelected2 == "Future: Be going to") {
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsFutureBeGoingTo),
                        resources.getStringArray(R.array.vacio)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.futureBeGoingTo)
                } else if (tabSelected2 == "Will") {
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsWill),
                        resources.getStringArray(R.array.vacio)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.futureWill)
                } else if (tabSelected2 == "May or might") {
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsMayOrMight),
                        resources.getStringArray(R.array.thirdPartMayOrMight)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.mayOrMight)
                } else if (tabSelected2 == "Could") {
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsCould),
                        resources.getStringArray(R.array.thirdPartCould)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.could)
                } else if (tabSelected2 == "Should") {
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsShould),
                        resources.getStringArray(R.array.thirdPartShould)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.should)
                } else if (tabSelected2 == "Must") {
                    adaptador = VerbAdapter(
                        resources.getStringArray(R.array.allPersons),
                        resources.getStringArray(R.array.verbsMust),
                        resources.getStringArray(R.array.thirdPartMust)
                    )
                    recyclerVerb!!.setLayoutManager(LinearLayoutManager(activity))
                    recyclerVerb!!.setHasFixedSize(true)
                    recyclerVerb!!.setAdapter(adaptador)
                    definitionTimes!!.setText(R.string.must)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verbs, container, false)
    }

    override fun onDetach() {
        super.onDetach()
    }
}
