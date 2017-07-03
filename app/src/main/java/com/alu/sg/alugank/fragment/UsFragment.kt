package com.alu.sg.alugank.fragment

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alu.sg.alugank.R
import com.alu.sg.alugank.base.BaseKotlinFragment
import com.alu.sg.alugank.databinding.FragmentUsBinding


/**
 * Created by alu on 2017/6/22.
 *
 */

class UsFragment : BaseKotlinFragment<FragmentUsBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_us
    }

    override fun initView(saveInstanceState: Bundle?, view: View) {

    }

    override fun createDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentUsBinding {
        return FragmentUsBinding.inflate(inflater, container, false)
    }

    companion object {
        fun instance() = UsFragment()
    }
}