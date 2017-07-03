package com.alu.sg.alugank.base;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;


import com.alu.sg.alugank.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alu on 2017/4/24.
 * 版本：V1.0
 */

public abstract class SGActivity extends BaseActivity {

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        if (null != getIntent()) {
            handleIntent(getIntent());
        }
        if (null == getSupportFragmentManager().getFragments()) {
            BaseFragment firstFragment = getFirstFragment();
            if (null != firstFragment) {
                addFragment(firstFragment);
            }
        }

        requestRuntimePermission();
    }

    private void requestRuntimePermission() {
        List<String> allPermission = new ArrayList<>();
        List<String> unGetPermissionList = new ArrayList<>();
        allPermission.add(Manifest.permission.READ_PHONE_STATE);
        allPermission.add(Manifest.permission.ACCESS_FINE_LOCATION);
        allPermission.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        for (String permission : allPermission) {
            if (ContextCompat.checkSelfPermission(SGActivity.this, permission) != PackageManager.PERMISSION_GRANTED) {
                unGetPermissionList.add(permission);
            }
        }
        if (!unGetPermissionList.isEmpty()) {
            String[] permissions = unGetPermissionList.toArray(new String[unGetPermissionList.size()]);
            ActivityCompat.requestPermissions(SGActivity.this, permissions, 1);
        } else {
            //所有权限已经在上一次启动时全部获取到
        }

    }

    protected void handleIntent(Intent intent) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.fragment_container;
    }

    public abstract BaseFragment getFirstFragment();

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "权限获取成功", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(this, "权限获取失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    public void setupToolbar(Toolbar toolbar) {
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.icon_back);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
