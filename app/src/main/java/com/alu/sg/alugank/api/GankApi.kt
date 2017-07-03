package com.alu.sg.alugank.api


import com.alu.sg.alugank.bean.GirlData
import com.alu.sg.alugank.bean.JsonResult
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by Alu on 2017/6/12.
 * 版本：V1.0
 */
interface GankApi {

    @GET("data/福利/10/{page}")
    fun getGirlData(@Path("page") page: Int): Observable<JsonResult<List<GirlData>>>

    @GET("data/Android/10/{page}")
    fun getAndroidData(@Path("page") page: Int): Observable<JsonResult<List<GirlData>>>

    @GET("data/iOS/10/{page}")
    fun getIOSData(@Path("page") page: Int): Observable<JsonResult<List<GirlData>>>


    object serr {
        val getGankApiService: GankApi by lazy {
            retrofit2.Retrofit.Builder()
                    .baseUrl("http://gank.io/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build()
                    .create(GankApi::class.java)
        }
        //关于Activity
        const val ABOUT = "gank://androidwing.net/about/"


        //详情页
        const val DETAIL_PARAM_URL = "url"
        const val DETAIL = "gank://androidwing.net/detail/"
    }


}
