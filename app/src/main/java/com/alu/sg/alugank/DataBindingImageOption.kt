package com.alu.test.okletusgo.databinding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * Created by Alu on 2017/6/12.
 * 版本：V1.0
 */
@BindingAdapter("load_image")
fun loadImage(imageView: ImageView, url: String?) {
    Glide.with(imageView.context)
            .load(url)
            .crossFade()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
//            .placeholder(R.drawable.jiazaizhong)//占位图
            .into(imageView)
}

@BindingAdapter("load_asset")
fun loadAsset(imageView: ImageView, id: Int) {
    Glide.with(imageView.context)
            .load(id)
            .into(imageView)
}