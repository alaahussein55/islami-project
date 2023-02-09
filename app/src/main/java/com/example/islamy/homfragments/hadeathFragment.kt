package com.example.islamy.homfragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.R
import com.example.islamy.adapters.hadeath_name_adapter
import com.example.islamy.hadeathnamedetails

class hadeathFragment : Fragment() {

lateinit var recycleview :RecyclerView
lateinit var adaoter :hadeath_name_adapter
val hadeathnames = listOf<String>("الحديث الأول","الحديث الثاني","الحديث الثالث","الحديث الرابع","الحديث الخامس","الحديث السادس","الحديث السابع","الحديث الثامن","الحديث التاسع","الحديث العاشر","الحديث الحادي عشر","الحديث الثاني عشر","الحديث الثالث عشر","الحديث الرابع عشر","الحديث الخامس عشر","الحديث السادس عشر","الحديث السابع عشر","الحديث الثامن عشر","الحديث التاسع عشر","الحديث العشرون","الحديث الحادي والعشرون","الحديث الثاني والعشرون","الحديث الثالث والعشرون","الحديث الرابع والعشرون","الحديث الخامس والعشرون","الحديث السادس والعشرون","الحديث السابع والعشرون","الحديث الثامن والعشرون","الحديث التاسع والعشرون","الحديث الثلاثون","الحديث الحادي والثلاثون","الحديث الثاني والثلاثون","الحديث الثالث والثلاثون","الحديث الرابع والثلاثون","الحديث الخامس والثلاثون","الحديث السادس والثلاثون","الحديث السابع والثلاثون","الحديث الثامن والثلاثون","الحديث التاسع والثلاثون","الحديث الأربعون","الحديث الحادي والأربعون","الحديث الثاني والأربعون","الحديث الثالث والأربعون","الحديث الرابع والأربعون","الحديث الخامس والأربعون","الحديث السادس والأربعون","الحديث السابع والأربعون","الحديث الثامن والأربعون","الحديث التاسع والأربعون","الحديث الخمسون")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hadeath, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycleview =view.findViewById<RecyclerView>(R.id.hadeath_number_recycle)
        adaoter= hadeath_name_adapter(hadeathnames)

        adaoter.onchadeathlick = object : hadeath_name_adapter.onhadeathclick{
            override fun onhadeathname(hadeath: String, position: Int) {

                val intent= Intent(requireActivity(),hadeathnamedetails::class.java)
                intent.putExtra("filename","h${position+1}.txt")
                intent.putExtra("hadeathname",hadeath)
                startActivity(intent)
            }
        }
        recycleview.adapter=adaoter

    }
}