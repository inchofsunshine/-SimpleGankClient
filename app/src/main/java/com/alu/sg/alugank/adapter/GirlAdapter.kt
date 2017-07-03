package com.alu.sg.alugank.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alu.sg.alugank.bean.GirlData
import com.alu.sg.alugank.databinding.ItemDataBindingGirlsBinding


/**
 * Created by Alu on 2017/6/9.
 * 版本：V1.0
 */
class GirlAdapter(private val list: List<GirlData>) : BaseBindingAdapter<ItemDataBindingGirlsBinding>() {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder<ItemDataBindingGirlsBinding> {
        return DataBoundViewHolder(ItemDataBindingGirlsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<ItemDataBindingGirlsBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.girl = list[holder.adapterPosition]
        holder.binding.executePendingBindings()
    }
}