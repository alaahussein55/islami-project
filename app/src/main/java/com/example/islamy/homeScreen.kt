package com.example.islamy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.islamy.homfragments.hadeathFragment
import com.example.islamy.homfragments.quranFragment
import com.example.islamy.homfragments.radioFragment
import com.example.islamy.homfragments.sebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class homeScreen : AppCompatActivity() {
    lateinit var bottonnav:BottomNavigationView
    lateinit var switch : Switch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        switch=findViewById(R.id.switch1)
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (switch.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                switch.text = "Disable dark mode"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
               switch.text = "Enable dark mode"
            }


        }

        bottonnav=findViewById(R.id.navigation)
        showFragment(quranFragment())
        bottonnav.setOnItemSelectedListener { menyItem->
            if(menyItem.itemId==R.id.icquran){
                showFragment(quranFragment())

            }
            else if(menyItem.itemId==R.id.icahadeath){

                showFragment(hadeathFragment())
            } else if(menyItem.itemId==R.id.icsebha){
                showFragment(sebhaFragment())

            }else if(menyItem.itemId==R.id.icaradio){

                showFragment(radioFragment())
            }
            return@setOnItemSelectedListener true
        }

    }

    private fun showFragment(fragment:Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentcontainer,fragment)
            .commit()

}}