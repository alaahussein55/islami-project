package com.example.islamy

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.streams.toList

class hadeathnamedetails : AppCompatActivity() {
    var hadeathcontainer =""
   lateinit var hadeathcontent :TextView
   lateinit var hadethnametv :TextView
   lateinit var backarrow :ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeathnamedetails)
        hadeathcontent=findViewById(R.id.hadeathcontent)
        hadethnametv=findViewById(R.id.hadeathname)
        backarrow =findViewById(R.id.arrowh)
       val file_name= intent.getStringExtra("filename")
        val hadeathname = intent.getStringExtra("hadeathname")

        readhadeathfile(file_name?:"")
        hadethnametv.text=hadeathname
        hadeathcontent.text=hadeathcontainer
        backarrow.setOnClickListener {
            finish()
        }
    }
    fun readhadeathfile(filename:String){

         var reader =BufferedReader(
            InputStreamReader(assets.open(filename))
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            reader.lines().toList().joinToString {
                hadeathcontainer+=it
                return@joinToString ""
            }
        }
    }
}