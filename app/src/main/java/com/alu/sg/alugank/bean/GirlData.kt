
package com.alu.sg.alugank.bean
/**
 * Created by Alu on 2017/6/9.
 * 版本：V1.0
 */
data class GirlData(val _id: String,
                    val createdAt: String,
                    val desc: String,
                    val images: ArrayList<String>,
                    val publishedAt: String,
                    val source: String,
                    val type: String,
                    val url: String,
                    val used: Boolean,
                    val who: String) {
    fun hasImage(): Boolean {
        return images != null
    }

    fun createText() = createdAt.substring(0, 10)
}