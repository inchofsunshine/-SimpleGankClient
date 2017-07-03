package com.alu.sg.alugank.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.alu.sg.alugank.R
import com.alu.sg.alugank.activity.GirlImageDetailActivity
import com.alu.sg.alugank.adapter.GirlAdapter
import com.alu.sg.alugank.base.BaseKotlinFragment
import com.alu.sg.alugank.bean.GirlData
import com.alu.sg.alugank.databinding.DataBindingTest2FragmentBinding
import com.alu.sg.alugank.inter.FuckGoodsContract
import com.alu.sg.alugank.model.FuckGoodsModel
import com.alu.sg.alugank.present.GirlPresenter
import kotlinx.android.synthetic.main.data_binding_test2_fragment.*

import java.util.*
import javax.inject.Inject

/**
 * Created by Alu on 2017/6/9.
 * 版本：V1.0
 */
class GirlFragment : BaseKotlinFragment<DataBindingTest2FragmentBinding>(), FuckGoodsContract.View {


    private var page = 1
    private lateinit var girlRecycle: RecyclerView
    private lateinit var girlAdapter: GirlAdapter
    private var girlList = ArrayList<GirlData>()
    @Inject lateinit private var mGirlPresenter: GirlPresenter
    override fun getLayoutId(): Int {
        return R.layout.data_binding_test2_fragment
    }

    override fun initView(saveInstanceState: Bundle?, view: View) {
        mGirlPresenter = GirlPresenter(FuckGoodsModel.Companion.instance(), this)
        girlAdapter = GirlAdapter(girlList)
        with(mBinding) {
            girlRecycle = girlRecycleView
            girlRecycleView.adapter = girlAdapter
            girlRecycleView.layoutManager = GridLayoutManager(context, 2)
            girlRecycle.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!recyclerView?.canScrollVertically(1)!!) {
                        if (page < 11) {
                            page++
                            mGirlPresenter.getData(page, GIRL)
                            Log.d("lbw", page.toString())
                        }
                    }
                }
            })
            mGirlPresenter.getData(page, GIRL)
        }

        girlAdapter.setOnItemClickListener {
            pos ->
            val imageView = girlRecycleView.findViewHolderForAdapterPosition(pos)?.itemView?.findViewById(R.id.iv_girl) as ImageView
            GirlImageDetailActivity.actionStart(context, imageView, girlList[pos].url)

        }
    }

    override fun createDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): DataBindingTest2FragmentBinding {
        return DataBindingTest2FragmentBinding.inflate(inflater, container, false)
    }

    companion object {
        val GIRL = "girl"
        fun newInstance() = GirlFragment()
    }

    override fun setData(result: List<GirlData>) {
        girlList.addAll(result)
        girlAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        mGirlPresenter.unSubscription()
    }
}