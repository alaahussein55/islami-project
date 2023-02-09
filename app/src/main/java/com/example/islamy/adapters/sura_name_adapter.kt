package com.example.islamy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamy.R

class sura_name_adapter(val item:List<String>) : RecyclerView.Adapter<sura_name_adapter.viewholder>() {
    class viewholder(itemview:View):RecyclerView.ViewHolder(itemview){


        val suranametv =itemview.findViewById<TextView>(R.id.itemsuraname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
       val view =LayoutInflater.from(parent.context).inflate(R.layout.suranameitem,parent,false)
        return viewholder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.suranametv.text = item.get(position)
        holder.itemView.setOnClickListener{
         oncitemlick?.onsuraname(item.get(position),position)
        }
    }
    var oncitemlick :onclick?=null

    interface onclick {
        fun onsuraname( sura :String,position:Int)
    }
}