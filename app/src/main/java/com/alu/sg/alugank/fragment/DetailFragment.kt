package com.alu.sg.alugank.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.alu.sg.alugank.R
import com.alu.sg.alugank.activity.DetailActivity
import com.alu.sg.alugank.base.BaseKotlinFragment
import com.alu.sg.alugank.base.SGActivity
import com.alu.sg.alugank.databinding.FragmentDetailPageBinding


/**
 * Created by alu on 2017/6/30.
 */

class DetailFragment : BaseKotlinFragment<FragmentDetailPageBinding>() {
    var url = ""
    override fun getLayoutId(): Int {
        return R.layout.fragment_detail_page
    }

    override fun initView(saveInstanceState: Bundle?, view: View) {
        with(mBinding) {
            if (arguments != null) {
                url = arguments.getString(DetailActivity.KEY_DETAIL)
                (activity as SGActivity).setupToolbar(toolbar)
//                toast(url)
                tvTitle.text = "Gank"
                webView.loadUrl(url)
                webView.setWebViewClient(object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                        view?.loadUrl(url)
                        return true
                    }
                })
            }
        }

    }

    override fun createDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentDetailPageBinding {
        return FragmentDetailPageBinding.inflate(inflater, container, false)
    }

    companion object {
        fun newInstance(url: String): DetailFragment {
            val fragment = DetailFragment()
            val bundle = Bundle()
            bundle.putString(DetailActivity.KEY_DETAIL, url)
            fragment.arguments = bundle
            return fragment
        }
    }
}
