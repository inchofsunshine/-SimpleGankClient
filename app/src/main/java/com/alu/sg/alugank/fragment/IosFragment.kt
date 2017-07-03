package com.alu.sg.alugank.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alu.sg.alugank.GankRouter
import com.alu.sg.alugank.R
import com.alu.sg.alugank.adapter.AndroidAdapter
import com.alu.sg.alugank.api.GankApi
import com.alu.sg.alugank.base.BaseKotlinFragment
import com.alu.sg.alugank.bean.GirlData
import com.alu.sg.alugank.databinding.FragmentAndroidBinding
import com.alu.sg.alugank.inter.FuckGoodsContract
import com.alu.sg.alugank.model.FuckGoodsModel
import com.alu.sg.alugank.present.GirlPresenter
import org.jetbrains.anko.support.v4.toast
import java.net.URLEncoder

/**
 * Created by alu on 2017/6/22.
 *
 */
class IosFragment : BaseKotlinFragment<FragmentAndroidBinding>(), FuckGoodsContract.View {


    private var mList = ArrayList<GirlData>()
    private lateinit var gp: GirlPresenter
    private var page = 1
    private lateinit var mAdapter: AndroidAdapter
    override fun getLayoutId(): Int {
        return R.layout.fragment_android
    }

    override fun initView(saveInstanceState: Bundle?, view: View) {
        mAdapter = AndroidAdapter(mList)
        gp = GirlPresenter(FuckGoodsModel.instance(), this)
        with(mBinding) {
            rvAndroid.adapter = mAdapter
            rvAndroid.layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?
            rvAndroid.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!recyclerView?.canScrollVertically(1)!!) {
                        page++
                        gp.getData(page, IOS)
                    }
                }
            })
            gp.getData(page, IOS)
            mAdapter.setOnItemClickListener {
                pos ->
                val url = URLEncoder.encode(mList[pos].url)
                GankRouter.router(context, GankApi.serr.DETAIL + url)
            }
        }
    }

    override fun createDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentAndroidBinding {
        return FragmentAndroidBinding.inflate(inflater, container, false)
    }

    override fun setData(result: List<GirlData>) {
//        Log.d("lbw", result.toString())
//        toast("分页".plus(page))
        mList.addAll(result)
        mAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        gp.unSubscription()
    }

    companion object {
        val IOS = "ios"
        fun newInstance() = IosFragment()
    }

}