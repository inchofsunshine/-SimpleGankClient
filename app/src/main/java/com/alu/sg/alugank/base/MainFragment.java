package com.alu.sg.alugank.base;


import android.os.Bundle;
import android.view.View;

import com.alu.sg.alugank.R;



/**
 * Created by Alu on 2017/4/24.
 * 版本：V1.0
 */

public class MainFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(View view, Bundle saveInstanceState) {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }
}
