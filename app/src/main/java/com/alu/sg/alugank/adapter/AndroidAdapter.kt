package com.alu.sg.alugank.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alu.sg.alugank.bean.GirlData
import com.alu.sg.alugank.databinding.ItemAndroidBinding



/**
 * Created by alu on 2017/6/20.
 */
class AndroidAdapter(val list: List<GirlData>) : BaseBindingAdapter<ItemAndroidBinding>() {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder<ItemAndroidBinding> {
        return DataBoundViewHolder(ItemAndroidBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<ItemAndroidBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.fuckgoods = list[position]
        holder.binding.executePendingBindings()
    }

}