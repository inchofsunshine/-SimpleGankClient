package com.alu.sg.alugank.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Alu on 2017/4/24.
 * 版本：V1.0
 */

public abstract class BaseFragment extends Fragment {
    protected BaseActivity mBaseActivity;

    protected abstract int getLayoutId();

    protected abstract void initView(View view, Bundle saveInstanceState);

    protected BaseActivity getHoldingActivity() {
        return mBaseActivity;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mBaseActivity = (BaseActivity) activity;
    }

    protected void addFragment(BaseFragment fragment) {
        if (null != fragment) {
            getHoldingActivity().addFragment(fragment);
        }
    }

    protected void removeFrament(BaseFragment fragment) {
        if (null != fragment) {
            getHoldingActivity().removeFragment(fragment);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        initView(view,  savedInstanceState);
        return view;
    }
}
