package com.alu.sg.alugank.activity

import com.airbnb.deeplinkdispatch.DeepLink
import com.alu.sg.alugank.api.GankApi
import com.alu.sg.alugank.base.BaseFragment
import com.alu.sg.alugank.base.SGActivity
import com.alu.sg.alugank.fragment.DetailFragment
import java.net.URLDecoder

/**
 * Created by alu on 2017/6/30.
 */
@DeepLink("gank://androidwing.net/detail/{${GankApi.serr.DETAIL_PARAM_URL}}")
class DetailActivity : SGActivity() {
    var url = ""
    override fun getFirstFragment(): BaseFragment {
        if (intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)) {
            url = URLDecoder.decode(intent.extras.getString(GankApi.serr.DETAIL_PARAM_URL))
        }
        return DetailFragment.newInstance(url)
    }

    companion object {
        val KEY_DETAIL = "key_detail"
    }
}