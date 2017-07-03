package com.alu.sg.alugank.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by Alu on 2017/6/9.
 * 版本：V1.0
 */
class DataBoundViewHolder<T : ViewDataBinding>(val binding:T) : RecyclerView.ViewHolder(binding.root)
