package com.alu.sg.alugank.base;

import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

/**
 * Created by Alu on 2017/4/24.
 * 版本：V1.0
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected abstract int getContentViewId();

    protected abstract int getFragmentContentId();

    protected void addFragment(BaseFragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    protected void removeFragment(BaseFragment fragment) {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
