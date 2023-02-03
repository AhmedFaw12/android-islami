package com.example.islami.hadeth_details_activity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.databinding.ItemHadethLineBinding

class HadethContentAdapter(var items:List<String?>?) :Adapter<HadethContentAdapter.HadethContentViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethContentViewHolder {
        val viewBinding = ItemHadethLineBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return HadethContentViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: HadethContentViewHolder, position: Int) {
        holder.viewBinding.hadethLine.text = items?.get(position)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    class HadethContentViewHolder(val viewBinding: ItemHadethLineBinding):ViewHolder(viewBinding.root){
    }

    fun updateContent(items:List<String?>?){
        this.items = items
        notifyDataSetChanged()
    }

}