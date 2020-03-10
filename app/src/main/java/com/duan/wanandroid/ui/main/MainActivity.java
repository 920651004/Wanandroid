package com.duan.wanandroid.ui.main;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.duan.wanandroid.R;
import com.duan.wanandroid.base.BaseMvcActivity;
import com.duan.wanandroid.ui.fragment.knofra.Knowframent;
import com.duan.wanandroid.ui.fragment.mainfra.Mainframent;
import com.duan.wanandroid.ui.fragment.navfra.Navframent;
import com.duan.wanandroid.ui.fragment.projectfra.Proframent;
import com.duan.wanandroid.ui.fragment.wx.WxActicleFragment;
import com.duan.wanandroid.utlis.Contents;
import com.duan.wanandroid.utlis.JumpUtlis;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;


public class MainActivity extends BaseMvcActivity implements MenuItem.OnMenuItemClickListener {


    @BindView(R.id.tool_text)
    TextView toolText;
    @BindView(R.id.search_img)
    ImageView searchImg;
    @BindView(R.id.main_content)
    FrameLayout mainContent;
    /* @BindView(R.id.main_home)
     LinearLayout mainHome;
     @BindView(R.id.main_knowledge)
     LinearLayout mainKnowledge;
     @BindView(R.id.main_navigation)
     LinearLayout mainNavigation;
     @BindView(R.id.main_project)
     LinearLayout mainProject;
     @BindView(R.id.bottom_layout)
     LinearLayout bottomLayout;*/
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.nav_drawer)
    DrawerLayout navDrawer;
    @BindView(R.id.tool_bar)
    RelativeLayout toolBar;
    @BindView(R.id.nav_bottomview)
    BottomNavigationView navBottomview;
    private int hideFragment = Contents.Main;
    private int showFragment = Contents.Main;
    Mainframent mainFragment;
    Knowframent knowFragment;
    Navframent navFragment;
    Proframent proFragment;
    WxActicleFragment wxFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        toolText.setText("首页");
        initpermission();
        initNavigationView();
        initDrawerLayout();
        initBottomView();
        mainFragment = Mainframent.getIntentce();
        knowFragment = Knowframent.getIntentce();
        navFragment = Navframent.getIntentce();
        proFragment = Proframent.getIntentce();
        wxFragment = WxActicleFragment.getIntentce();
        navBottomview.setSelectedItemId(R.id.tab_main_pager);
        loadMultipleRootFragment(R.id.main_content, 0, mainFragment, knowFragment, wxFragment, navFragment, proFragment);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @SuppressLint("WrongConstant")
    private void initpermission() {
        PermissionUtils.permission(PermissionConstants.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, PermissionConstants.LOCATION)
                .rationale((PermissionUtils.OnRationaleListener.ShouldRequest shouldRequest) -> {
                    ToastUtils.showShort("权限未打开，请打开权限");
                    PermissionUtils.launchAppDetailsSettings();
                })
                .callback(new PermissionUtils.FullCallback() {
                    @Override
                    public void onGranted(List<String> permissionsGranted) {
                    LogUtils.e("允许");
                    }

                    @Override
                    public void onDenied(List<String> permissionsDeniedForever, List<String> permissionsDenied) {

                    }
                }).request();


    }


    private void initDrawerLayout() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, navDrawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //获取mDrawerLayout中的第一个子布局，也就是布局中的RelativeLayout
                //获取抽屉的view
                View mContent = navDrawer.getChildAt(0);
                float scale = 1 - slideOffset;
                float endScale = 0.8f + scale * 0.2f;
                float startScale = 1 - 0.3f * scale;

                //设置左边菜单滑动后的占据屏幕大小
                drawerView.setScaleX(startScale);
                drawerView.setScaleY(startScale);
                //设置菜单透明度
                drawerView.setAlpha(0.6f + 0.4f * (1 - scale));

                //设置内容界面水平和垂直方向偏转量
                //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
                mContent.setTranslationX(drawerView.getMeasuredWidth() * (1 - scale));
                //设置内容界面操作无效（比如有button就会点击无效）
                mContent.invalidate();
                //设置右边菜单滑动后的占据屏幕大小
                mContent.setScaleX(endScale);
                mContent.setScaleY(endScale);
            }
        };
        toggle.syncState();
        navDrawer.addDrawerListener(toggle);
    }

    private void initBottomView() {
        navBottomview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tab_main_pager:
                        toolText.setText("首页");
                        showFragment = Contents.Main;
                        showHideFragment(getTargetFragment(showFragment), getTargetFragment(hideFragment));
                        hideFragment = showFragment;
                        break;
                    case R.id.tab_knowledge_hierarchy:
                        toolText.setText("知识体系");
                        showFragment = Contents.Knowledge;
                        showHideFragment(getTargetFragment(showFragment), getTargetFragment(hideFragment));
                        hideFragment = showFragment;
                        break;
                    case R.id.tab_wx_article:
                        toolText.setText("公众号");
                        showFragment = Contents.WxActicle;
                        showHideFragment(getTargetFragment(showFragment), getTargetFragment(hideFragment));
                        hideFragment = showFragment;
                        break;
                    case R.id.tab_navigation:
                        toolText.setText("导航");
                        showFragment = Contents.Navigation;
                        showHideFragment(getTargetFragment(showFragment), getTargetFragment(hideFragment));
                        hideFragment = showFragment;
                        break;
                    case R.id.tab_project:
                        toolText.setText("项目");
                        showFragment = Contents.Project;
                        showHideFragment(getTargetFragment(showFragment), getTargetFragment(hideFragment));
                        hideFragment = showFragment;
                        break;
                }
                return true;
            }
        });
    }


    @Override
    protected void process(Bundle savedInstanceState) {
        super.process(savedInstanceState);
        if (savedInstanceState != null) {
            showHideFragment(getTargetFragment(showFragment), getTargetFragment(hideFragment));
            hideFragment = showFragment;
            //loadRootFragment(R.id.main_content,Mainframent.getIntentce());
        }
    }


    private SupportFragment getTargetFragment(int item) {
        switch (item) {
            case Contents.Main:
                return mainFragment;
            case Contents.Knowledge:
                return knowFragment;
            case Contents.Navigation:
                return navFragment;
            case Contents.Project:
                return proFragment;
            case Contents.WxActicle:
                return wxFragment;

        }

        return mainFragment;
    }

    @OnClick({R.id.search_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search_img:
                JumpUtlis.ToSearch(mContext);
                break;
        }
    }

    private void initNavigationView() {
        navView.setItemIconTintList(null);
        navView.getHeaderView(0).findViewById(R.id.nav_header_login_tv).setOnClickListener(view -> {

        });
        navView.getMenu().findItem(R.id.nav_item_wan_android).setOnMenuItemClickListener(this);
        navView.getMenu().findItem(R.id.nav_item_my_collect).setOnMenuItemClickListener(this);
        navView.getMenu().findItem(R.id.nav_item_setting).setOnMenuItemClickListener(this);
        navView.getMenu().findItem(R.id.nav_item_about_us).setOnMenuItemClickListener(this);
        navView.getMenu().findItem(R.id.nav_item_logout).setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_item_wan_android:
                GoMainFra();
                navDrawer.closeDrawers();
                break;
            case R.id.nav_item_my_collect:
                navDrawer.closeDrawers();
                break;
            case R.id.nav_item_setting:
                navDrawer.closeDrawers();
                break;
            case R.id.nav_item_about_us:
                navDrawer.closeDrawers();
                break;
            case R.id.nav_item_logout:
                navDrawer.closeDrawers();
                break;
        }
        return true;
    }

    private void GoMainFra() {
        toolText.setText("首页");
        showFragment = Contents.Main;
        showHideFragment(getTargetFragment(showFragment), getTargetFragment(hideFragment));
        hideFragment = showFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
