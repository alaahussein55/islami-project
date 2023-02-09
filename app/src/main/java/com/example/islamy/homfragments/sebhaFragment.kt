package com.example.islamy.homfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.islamy.R

class sebhaFragment : Fragment() {
    lateinit var image:ImageView
    lateinit var phase:TextView
    lateinit var counter_tv :TextView
    var counter : Int =0



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image =view.findViewById(R.id.sebhahead)
        phase=view.findViewById(R.id.phase)
        counter_tv =view.findViewById(R.id.sebhacounter)
        counter_tv.text="$counter"
        image.setOnClickListener {
            onSebhaClicked()
        }
    }

    private fun onSebhaClicked() {
        image.rotation=image.rotation+ 5
        counter++
        counter_tv.text="$counter"
        if(counter==33){
            if(phase.text=="سبحان الله"){
                phase.text="الحمدلله"
                counter=0
                counter_tv.text="$counter"

            }
             else if(phase.text=="الحمدلله"){
                phase.text="الله اكبر"
                counter=0
                counter_tv.text="$counter"

            }
            else if(phase.text=="الله اكبر"){
                phase.text="لا اله الا الله وحده لا شريك له له الملك و له الحمد وخو علي كل شئ قدير"
                counter=0
                counter_tv.text="$counter"

            }
            else if(phase.text=="لا اله الا الله وحده لا شريك له له الملك و له الحمد وخو علي كل شئ قدير"){
                phase.text="سبحان الله"
                counter=0
                counter_tv.text="$counter"

            }
        }

    }

}

