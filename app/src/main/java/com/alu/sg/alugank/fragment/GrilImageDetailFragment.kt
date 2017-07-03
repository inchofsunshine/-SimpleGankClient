package com.alu.sg.alugank.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alu.sg.alugank.R
import com.alu.sg.alugank.activity.GirlImageDetailActivity
import com.alu.sg.alugank.base.BaseKotlinFragment
import com.alu.sg.alugank.databinding.FragmentGrilImageDetailBinding


/**
 * Created by Alu on 2017/6/13.
 * 版本：V1.0
 */
class GirlImageDetailFragment : BaseKotlinFragment<FragmentGrilImageDetailBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_gril_image_detail
    }

    override fun initView(saveInstanceState: Bundle?, view: View) {
        mBinding.url = arguments.getString(GirlImageDetailActivity.KEY_IMG)
        mBinding.root.setOnClickListener {
            activity.supportFinishAfterTransition()
        }
    }

    override fun createDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentGrilImageDetailBinding {
        return FragmentGrilImageDetailBinding.inflate(inflater, container, false)
    }

    companion object {
        fun newInstance(url: String): GirlImageDetailFragment {
            val fragment = GirlImageDetailFragment()
            val bundle = Bundle()
            bundle.putString(GirlImageDetailActivity.KEY_IMG, url)
            fragment.arguments = bundle
            return fragment
        }
    }
}