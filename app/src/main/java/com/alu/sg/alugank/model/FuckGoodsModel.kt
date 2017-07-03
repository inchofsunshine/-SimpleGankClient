package com.alu.sg.alugank.model

import com.alu.sg.alugank.api.GankApi
import com.alu.sg.alugank.bean.GirlData
import com.alu.sg.alugank.bean.JsonResult
import com.alu.sg.alugank.fragment.AndroidFragment
import com.alu.sg.alugank.fragment.GirlFragment
import com.alu.sg.alugank.fragment.IosFragment
import com.alu.sg.alugank.inter.FuckGoodsContract
import rx.Observable

/**
 * Created by Alu on 2017/6/9.
 * 版本：V1.0
 */
class FuckGoodsModel(val api: GankApi) : FuckGoodsContract.Model {
    override fun getData(page: Int, type: String): Observable<JsonResult<List<GirlData>>> {
        when (type) {
            GirlFragment.GIRL -> return api.getGirlData(page)
            AndroidFragment.ANDROID -> return api.getAndroidData(page)
            IosFragment.IOS -> return api.getIOSData(page)
            else -> return api.getGirlData(page)
        }
    }

    companion object {
        fun instance() = FuckGoodsModel(GankApi.serr.getGankApiService)
    }
}