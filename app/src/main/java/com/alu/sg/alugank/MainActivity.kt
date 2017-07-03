package com.alu.sg.alugank

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.alu.sg.alugank.base.SGActivity
import com.alu.sg.alugank.fragment.AndroidFragment
import com.alu.sg.alugank.fragment.GirlFragment
import com.alu.sg.alugank.fragment.IosFragment
import com.alu.sg.alugank.fragment.UsFragment

import kotlinx.android.synthetic.main.activity_gank_main_activityt.*

/**
 * Created by Alu on 2017/6/9.
 * 版本：V1.0
 */
class MainActivity : SGActivity() {
    lateinit var mFragments: MutableList<Fragment>
    override fun getFirstFragment(): AndroidFragment {
        return AndroidFragment.newInstance()
    }

    override fun getContentViewId(): Int {
        return R.layout.activity_gank_main_activityt
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFragments()
        mViewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment = mFragments[position]
            override fun getCount(): Int = mFragments.size
        }
        mViewPager.offscreenPageLimit = 4
        mNavigationView.setOnNavigationItemSelectedListener {
            item ->
            var tab = 0
            when (item.itemId) {
                R.id.menu_android -> tab = 0
                R.id.menu_ios -> tab = 1
                R.id.menu_girl -> tab = 2
                R.id.menu_about -> tab = 3
            }
            mViewPager.currentItem = tab
            true
        }
    }

    private fun initFragments() {
        mFragments = ArrayList<Fragment>()
        mFragments.add(AndroidFragment.newInstance())
        mFragments.add(IosFragment.newInstance())
        mFragments.add(GirlFragment.newInstance())
        mFragments.add(UsFragment.instance())
    }
}