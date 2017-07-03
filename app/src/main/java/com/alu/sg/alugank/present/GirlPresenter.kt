package com.alu.sg.alugank.present

import android.util.Log
import com.alu.sg.alugank.inter.FuckGoodsContract
import com.alu.sg.alugank.model.FuckGoodsModel
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Alu on 2017/6/14.
 * 版本：V1.0
 */
class GirlPresenter(val mModel: FuckGoodsModel, val mView: FuckGoodsContract.View) : BasePresenter(), FuckGoodsContract.Presenter {
    override fun getData(page: Int, type: String) {

        addSubscription(mModel
                .getData(page, type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    res ->
                    if (!res.error) {
                        mView.setData(res.results)
                    }
                }, { e -> Log.e("lbw", "error girl data load" + e.message) }))
    }

}