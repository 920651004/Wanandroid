package com.duan.wanandroid.ui.login;

import android.os.Bundle;
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
import com.duan.wanandroid.base.BaseActivity;
import com.duan.wanandroid.utlis.JsonUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

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
    LoginPresenter presenter;
    @BindView(R.id.back_img)
    ImageView backImg;
    @BindView(R.id.tool_bar)
    RelativeLayout toolBar;
    @BindView(R.id.tool_text)
    TextView toolText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
        backImg.setVisibility(View.GONE);
        toolText.setText("登录");
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
}
