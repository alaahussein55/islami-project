package com.example.islamy.sura_details

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.islamy.R
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.streams.toList

class sura_details : AppCompatActivity() {
    var suracontent =""
    //val lines :MutableList<String> = mutableListOf()
    lateinit var suaraNameTextview :TextView
    lateinit var suaraContentTextview :TextView
    lateinit var backArrow :ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        suaraNameTextview =findViewById(R.id.suranamed)
        suaraContentTextview = findViewById(R.id.suracontent)
        backArrow = findViewById(R.id.arrow)
        val sura_name =intent.getStringExtra("suraname")
       val file_name= intent.getStringExtra("filename")
        suaraNameTextview.text=sura_name
        suaraContentTextview.movementMethod= ScrollingMovementMethod()
        readSuraFile(file_name?:"")
        suaraContentTextview.text=suracontent
        backArrow.setOnClickListener { finish() }

    }
    fun readSuraFile(fileNmeme:String){
        val reader = BufferedReader(InputStreamReader(assets.open(fileNmeme)))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val lines = reader.lines().toList()
            for( i in 0..lines.size-1){

                val line =lines.get(i)
                suracontent+= line+"(${i+1})"
            }


        }
    }
}