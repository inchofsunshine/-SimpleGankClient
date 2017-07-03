package com.alu.sg.alugank.base

import android.databinding.ViewDataBinding
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Alu on 2017/5/26.
 * 版本：V1.0
 */

abstract class BaseKotlinFragment<B : ViewDataBinding> : BaseFragment() {
    lateinit var mBinding: B
    override fun initView(view: View?, saveInstanceState: Bundle?) {}
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = createDataBinding(inflater, container, savedInstanceState)
        val view = inflater.inflate(layoutId, container, false)
        initView(savedInstanceState, view)
        return mBinding.root
    }

    protected abstract fun initView(saveInstanceState: Bundle?, view: View)
    protected abstract fun createDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): B

}
