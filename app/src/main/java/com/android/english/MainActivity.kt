package com.android.english

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.android.english.fragment.GramaticaFragment
import com.android.english.fragment.IrregularVerbs
import com.android.english.fragment.VerbsFragment
import com.android.english.fragment.VocabularioFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import java.util.*

class MainActivity : AppCompatActivity() {
    private var mDrawerLayout: DrawerLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Adding Toolbar to Main screen
        val toolbar: Toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val viewPager: ViewPager = findViewById(R.id.viewpager) as ViewPager
        setupViewPager(viewPager)

        //Set Tabs inside Toolbar
        val tabs: TabLayout = findViewById(R.id.tabs) as TabLayout
        tabs.setupWithViewPager(viewPager)
        // Create Navigation drawer and inlfate layout
        val navigationView: NavigationView = findViewById(R.id.nav_view) as NavigationView
        mDrawerLayout = findViewById(R.id.drawer) as DrawerLayout?
        // Adding menu icon to Toolbar
        val supportActionBar: ActionBar? = supportActionBar
        /*if (supportActionBar != null) {
            VectorDrawableCompat indicator
                    = VectorDrawableCompat.create(getResources(), R.drawable.ic_menu, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(), R.color.white, getTheme()));
            supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }*/navigationView.setNavigationItemSelectedListener(
            object : BottomNavigationView.OnNavigationItemSelectedListener {
                // This method will trigger on item Click of navigation menu
                override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
                    // Set item in checked state
                    menuItem.isChecked = true
                    val fm: FragmentManager = supportFragmentManager
                    val transaction: FragmentTransaction = fm.beginTransaction()
                    if (menuItem.itemId == R.id.itemGramatica) {
                        transaction.replace(R.id.drawer, GramaticaFragment())
                        //viewPager.setCurrentItem(0);
                    } else if (menuItem.itemId == R.id.itemVocabulario) {
                        transaction.replace(R.id.drawer, VocabularioFragment())

                        //viewPager.setCurrentItem(1);
                    } else if (menuItem.itemId == R.id.itemVerbs) {
                        transaction.replace(R.id.drawer, VocabularioFragment())
                        //viewPager.setCurrentItem(2);
                    } else if (menuItem.itemId == R.id.itemIrregularVerbs) {
                        transaction.replace(R.id.drawer, VocabularioFragment())
                        //viewPager.setCurrentItem(3);
                    }
                    transaction.commit()
                    mDrawerLayout!!.closeDrawers()
                    return true
                }
            })
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = Adapter(supportFragmentManager)
        adapter.addFragment(GramaticaFragment(), "Grammar")
        adapter.addFragment(VocabularioFragment(), "Vocabulary")
        adapter.addFragment(VerbsFragment(), "Times")
        adapter.addFragment(IrregularVerbs(), "IrregularVerbs")
        viewPager.setAdapter(adapter)
    }

    internal class Adapter(manager: FragmentManager?) : FragmentPagerAdapter(manager!!) {
        private val mFragmentList: MutableList<Fragment> =
            ArrayList<Fragment>()
        private val mFragmentTitleList: MutableList<String> =
            ArrayList()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        if (id == R.id.itemGramatica) {
            return true
        } else if (id == R.id.itemVocabulario) {
            return true
        } else if (id == android.R.id.home) {
            mDrawerLayout!!.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
}

private fun NavigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener) {

}
