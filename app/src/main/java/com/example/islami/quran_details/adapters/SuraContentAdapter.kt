package com.example.islami.quran_details.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.R

class SuraContentAdapter(var suraLines:List<String?>?) :Adapter<SuraContentAdapter.SuraContentViewHolder>(){


    class SuraContentViewHolder(itemView:View) : ViewHolder(itemView){
        val suraLineText : TextView
        init{
            suraLineText = itemView.findViewById(R.id.sura_line_text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraContentViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        val view:View = layoutInflater
            .inflate(R.layout.item_sura_line, parent, false)
        return SuraContentViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuraContentViewHolder, position: Int) {
        val line  = suraLines?.get(position)
        holder.suraLineText.text = "$line${position?.plus(1)}"
    }

    override fun getItemCount(): Int {
        return suraLines?.size ?: 0
    }

    fun updateData(suraLines : List<String?>?){
        this.suraLines = suraLines
        notifyDataSetChanged()
    }
}