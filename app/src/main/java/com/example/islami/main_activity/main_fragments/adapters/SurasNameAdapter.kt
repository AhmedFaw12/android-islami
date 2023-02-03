package com.example.islami.main_activity.main_fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.Guideline
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.R
import com.example.islami.callbacks.OnSuraClickListener
import com.example.islami.data.model.SuraDataItem

class SurasNameAdapter(var suras:List<String>, var count:Int = 286) :Adapter<SurasNameAdapter.SurasNameViewHolder>(){


    var onSuraClickListener :OnSuraClickListener ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurasNameViewHolder {
        val view:View = LayoutInflater.from(parent.context)
            .inflate(R.layout.quran_list_item, parent, false)

        return SurasNameViewHolder(view)
    }

    override fun onBindViewHolder(holder: SurasNameViewHolder, position: Int) {

        val item:String = suras[position]

        holder.suraName.text = suras[position]
        holder.suraContentCount.text = "$count" //convert int to string
        if(onSuraClickListener!=null){
            holder.itemView.setOnClickListener{
                onSuraClickListener?.onSuraClick(item, position)
            }
        }
    }

    override fun getItemCount(): Int {
        return suras.size
    }

    class SurasNameViewHolder(itemView: View) : ViewHolder(itemView){
        var suraName: TextView
        var suraContentCount : TextView

        init{
            suraName = itemView.findViewById(R.id.sura_name)
            suraContentCount = itemView.findViewById(R.id.sura_content_count)

        }
    }



}