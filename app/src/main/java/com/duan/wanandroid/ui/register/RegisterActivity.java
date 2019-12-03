package com.duan.wanandroid.ui.register;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.duan.wanandroid.R;

import com.duan.wanandroid.base.BaseMvpActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseMvpActivity<RegisterPresent> implements RegisterView {

    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.tool_bar)
    RelativeLayout toolBar;
    @BindView(R.id.login_name)
    EditText loginName;
    @BindView(R.id.login_passward)
    EditText loginPassward;
    @BindView(R.id.login_layout)
    LinearLayout loginLayout;
    @BindView(R.id.login_register)
    Button loginRegister;
    @BindView(R.id.tool_text)
    TextView toolText;
    @BindView(R.id.affirm_passward)
    EditText affirmPassward;


    @OnClick({R.id.back_img, R.id.login_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.login_register:
                if (StringUtils.isEmpty(loginName.getText().toString())
                        || StringUtils.isEmpty(loginPassward.getText().toString())
                        || StringUtils.isEmpty(affirmPassward.getText().toString())) {
                    ToastUtils.showShort("请先填写名字或者密码");
                    return;
                }
                if (!affirmPassward.getText().toString().equals(loginPassward.getText().toString())) {
                    ToastUtils.showShort("两次输入的密码不一致");
                    return;
                }
                presenter.Register(loginName.getText().toString(), loginPassward.getText().toString(), affirmPassward.getText().toString());
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @NonNull
    @Override
    protected RegisterPresent initPresenter() {
        return new RegisterPresentImpl(this, this, this);
    }

    @Override
    public void initView() {

    }
}
