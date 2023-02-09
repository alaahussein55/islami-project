package com.example.islamy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.R

class hadeath_name_adapter(val item :List<String>): RecyclerView.Adapter<hadeath_name_adapter.viewHolder>() {
    class viewHolder(itemView :View): RecyclerView.ViewHolder(itemView){
        var hadeathnameTv =itemView.findViewById<TextView>(R.id.itemhadeathname)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.hadeath_item_name,parent,false
        )
       return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.hadeathnameTv.text=item.get(position)
        holder.hadeathnameTv.setOnClickListener {
            onchadeathlick?.onhadeathname(item.get(position),position)
        }
    }
    var onchadeathlick :onhadeathclick?=null

    interface onhadeathclick {
        fun onhadeathname( hadeath :String,position:Int)
    }
}