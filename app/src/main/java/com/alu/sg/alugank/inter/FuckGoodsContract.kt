package com.alu.sg.alugank.inter

import com.alu.sg.alugank.bean.GirlData
import com.alu.sg.alugank.bean.JsonResult
import rx.Observable

/**
 * Created by Alu on 2017/6/12.
 * 版本：V1.0
 */
interface FuckGoodsContract {
    interface View {
        fun setData(result: List<GirlData>)
    }

    interface Model {
        fun getData(page: Int, type: String): Observable<JsonResult<List<GirlData>>>
    }

    interface Presenter {
        fun getData(page: Int, type: String)
    }
}