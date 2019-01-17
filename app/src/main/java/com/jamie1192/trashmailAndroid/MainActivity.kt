package com.jamie1192.trashmailAndroid

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jamie1192.trashmailAndroid.fragments.QuickFragment
import com.mikepenz.iconics.context.IconicsContextWrapper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setupUI()

        setFragment(QuickFragment.newInstance("one", "two"), "quickFragment")
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(IconicsContextWrapper.wrap(newBase))
    }

    private fun setupUI() {
        bottom_nav_bar.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_quick -> Toast.makeText(this, "${it.title} clicked", Toast.LENGTH_SHORT).show()
                R.id.nav_address_manager -> Toast.makeText(this, "${it.title} clicked", Toast.LENGTH_SHORT).show()
                R.id.nav_account -> Toast.makeText(this, "${it.title} clicked", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    private fun setFragment(fragment : Fragment, tagName : String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_content, fragment, tagName)
            .commit()
    }
}
