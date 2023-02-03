package com.example.islami.main_activity.main_fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.callbacks.OnHadethClickListener
import com.example.islami.data.model.Hadeth
import com.example.islami.databinding.ItemHadethTitleBinding

class HadethTitleRecyclerAdapter(private val items:List<Hadeth>):Adapter<HadethTitleRecyclerAdapter.HadethTitleViewHolder>() {

    class HadethTitleViewHolder(val viewBinding : ItemHadethTitleBinding) : ViewHolder(viewBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethTitleViewHolder {
        val viewBinding = ItemHadethTitleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return HadethTitleViewHolder(viewBinding)
    }

    var onHadethTitleClickListener:OnHadethClickListener ?= null
    override fun onBindViewHolder(holder: HadethTitleViewHolder, position: Int) {
        val item = items[position]
        holder.viewBinding.title.text = item.title

        onHadethTitleClickListener?.let{
            holder.viewBinding.title.setOnClickListener{
                onHadethTitleClickListener?.onHadethClick(item, position)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}