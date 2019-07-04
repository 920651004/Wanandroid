package com.duan.wanandroid.ui.main;

import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.duan.wanandroid.R;
import com.duan.wanandroid.base.BaseActivity;
import com.duan.wanandroid.ui.fragment.knofra.Knowframent;
import com.duan.wanandroid.ui.fragment.mainfra.Mainframent;
import com.duan.wanandroid.ui.fragment.navfra.Navframent;
import com.duan.wanandroid.ui.fragment.projectfra.Proframent;
import com.duan.wanandroid.utlis.Contents;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.model.Response;
import com.sunchen.netbus.NetStatusBus;
import com.sunchen.netbus.annotation.NetSubscribe;
import com.sunchen.netbus.type.NetType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import me.yokeyword.fragmentation.SupportFragment;


public class MainActivity extends BaseActivity {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.tool_text)
    TextView toolText;
    @BindView(R.id.search_img)
    ImageView searchImg;
    @BindView(R.id.tool_bar)
    RelativeLayout toolBar;
    @BindView(R.id.main_content)
    FrameLayout mainContent;
    @BindView(R.id.main_home)
    LinearLayout mainHome;
    @BindView(R.id.main_knowledge)
    LinearLayout mainKnowledge;
    @BindView(R.id.main_navigation)
    LinearLayout mainNavigation;
    @BindView(R.id.main_project)
    LinearLayout mainProject;
    @BindView(R.id.bottom_layout)
    LinearLayout bottomLayout;
    private int hideFragment = Contents.Main;
    private int showFragment = Contents.Main;
    Mainframent mainframent;
    Knowframent knowframent;
    Navframent navframent;
    Proframent proframent;
    Disposable mDisposable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (savedInstanceState!=null){
          showHideFragment(getTargetFragment(showFragment),getTargetFragment(hideFragment));
            hideFragment=showFragment;
            //loadRootFragment(R.id.main_content,Mainframent.getIntentce());
        }
        initview();
    }

    @Override
    protected void onStart() {
        super.onStart();
        NetStatusBus.getInstance().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        NetStatusBus.getInstance().unregister(this);
    }
    @NetSubscribe(netType = NetType.AUTO)
    public void doSometing(NetType netType) {
        //netType 会返回当前的网络类型为 NetType.WIFI 还是 NetType.MOBIL 或者 NetType.NONE
      LogUtils.e(netType.name());
    }


    @Override
    protected void init() {
        super.init();
    }

    void initview(){
        backImg.setVisibility(View.GONE);
        toolText.setText("首页");
        mainframent=Mainframent.getIntentce();
        knowframent=Knowframent.getIntentce();
        navframent=Navframent.getIntentce();
        proframent=Proframent.getIntentce();
        loadMultipleRootFragment(R.id.main_content,0, mainframent,knowframent, navframent, proframent);
    }

    private SupportFragment getTargetFragment(int item) {
        switch (item) {
            case Contents.Main:
                return mainframent;
            case Contents.Knowledge:
                return knowframent;
            case Contents.Navigation:
                return navframent;
            case Contents.Project:
                return proframent;
        }
        
        return mainframent;
    }

    @OnClick({R.id.back_img, R.id.search_img, R.id.main_home, R.id.main_knowledge, R.id.main_navigation, R.id.main_project})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                break;
            case R.id.search_img:
                break;
            case R.id.main_home:
                toolText.setText("首页");
                showFragment= Contents.Main;
                showHideFragment(getTargetFragment(showFragment),getTargetFragment(hideFragment));
                hideFragment=showFragment;
                break;
            case R.id.main_knowledge:
                toolText.setText("知识体系");
                showFragment= Contents.Knowledge;
                showHideFragment(getTargetFragment(showFragment),getTargetFragment(hideFragment));
                hideFragment=showFragment;
                break;
            case R.id.main_navigation:
                toolText.setText("导航");
                showFragment= Contents.Navigation;
                showHideFragment(getTargetFragment(showFragment),getTargetFragment(hideFragment));
                hideFragment=showFragment;
                break;
            case R.id.main_project:
                toolText.setText("项目");
                showFragment= Contents.Project;
                showHideFragment(getTargetFragment(showFragment),getTargetFragment(hideFragment));
                hideFragment=showFragment;
                break;
        }
    }
}
