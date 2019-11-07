package com.duan.wanandroid.ui.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.duan.wanandroid.R;
import com.duan.wanandroid.base.BaseMvpActivity;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends BaseMvpActivity<LoginPresent> implements LoginView {

    @BindView(R.id.login_name)
    EditText loginName;
    @BindView(R.id.login_passward)
    EditText loginPassward;
    @BindView(R.id.login_layout)
    LinearLayout loginLayout;
    @BindView(R.id.login_register)
    Button loginRegister;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.tool_bar)
    RelativeLayout toolBar;
    @BindView(R.id.tool_text)
    TextView toolText;





    @Override
    public void login(String name, String passward) {

    }

    @Override
    public void register() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMsg(String msg) {

    }

    @NonNull
    @Override
    protected LoginPresent initPresenter() {
        return new LoginPresentImp(this,this,this);
    }

    @OnClick({R.id.login_register, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_register:
                register();
                break;
            case R.id.login:
                if (StringUtils.isEmpty(loginName.getText().toString()) || StringUtils.isEmpty(loginPassward.getText().toString())) {
                    ToastUtils.showShort("请先填写名字或者密码");
                    return;
                }

                // mPresent.login(loginName.getText().toString(), loginPassward.getText().toString());
                presenter.login(loginName.getText().toString(), loginPassward.getText().toString());
                break;
        }
    }
}
