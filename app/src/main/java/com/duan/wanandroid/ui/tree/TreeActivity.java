package com.duan.wanandroid.ui.tree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.duan.wanandroid.R;
/**
 *@author Admin
 *@time 2020/3/26  10:50
 *@describe  用于练习三级列表
 */
public class TreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);
        initview();

    }

    private void initview() {
        DataBean dataBean=new DataBean();

    }
}
