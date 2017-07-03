package com.alu.sg.alugank.activity

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.KeyEvent
import android.widget.ImageView
import com.alu.sg.alugank.base.BaseFragment
import com.alu.sg.alugank.base.SGActivity
import com.alu.sg.alugank.fragment.GirlImageDetailFragment

/**
 * Created by Alu on 2017/6/13.
 * 版本：V1.0
 */
class GirlImageDetailActivity : SGActivity() {
    private lateinit var url: String
    override fun getFirstFragment(): BaseFragment {
        return GirlImageDetailFragment.newInstance(url)
    }

    companion object {
        val KEY_IMG = "key_image"
        fun actionStart(context: Context, imageView: ImageView, url: String) {
            val intent = Intent(context, GirlImageDetailActivity::class.java)
            intent.putExtra(KEY_IMG, url)
            if (Build.VERSION.SDK_INT > 21) {
                context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(context as Activity, imageView, "img").toBundle())
            } else {
                context.startActivity(intent)
            }
        }
    }

    override fun handleIntent(intent: Intent) {
        super.handleIntent(intent)
        val bundle = intent.extras
        if (bundle != null) {
            url = bundle.getString(KEY_IMG)
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            supportFinishAfterTransition()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}