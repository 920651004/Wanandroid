package com.duan.wanandroid.ui.web;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.LogUtils;
import com.duan.wanandroid.R;
import com.duan.wanandroid.utlis.ProgressDialogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebDetialActivity extends AppCompatActivity {

    @BindView(R.id.back)
    AppCompatImageView back;
    @BindView(R.id.tv_title)
    AppCompatTextView tvTitle;
    @BindView(R.id.tool_bar)
    RelativeLayout toolBar;
    @BindView(R.id.web)
    WebView webView;
    String url;//传过来的url
    String title;//传过来的title

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_detial);
        ButterKnife.bind(this);
        url=getIntent().getStringExtra("url");
        title=getIntent().getStringExtra("title");
       websetting();
       initView();
    }

    private void initView() {
        webView.loadUrl(url);
        tvTitle.setText(title);
    }

    private void websetting() {
        WebSettings webSetting = webView.getSettings();
        webSetting.setAllowFileAccess(true);
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        //webView.addJavascriptInterface(new JavaScript(this),"aserboss");//aserboss
        webSetting.setAllowUniversalAccessFromFileURLs(true);
        webView.setWebViewClient(mWebViewClient);
        webView.setWebChromeClient(mWebChromeClient);
    }
    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }
        //页面开始加载
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            ProgressDialogUtil.showLoading(WebDetialActivity.this);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            ProgressDialogUtil.dismissAll();
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }
        //调用<input type="file">标签（此处存在Bug）
        // Android < 3.0 调用这个方法
        public void openFileChooser(ValueCallback<Uri> uploadMsg) {
            Log.d("TAG", "openFileChoose(ValueCallback<Uri> uploadMsg)");


        }

        // 3.0 + 调用这个方法
        public void openFileChooser(ValueCallback uploadMsg, String acceptType) {
            Log.d("TAG", "openFileChoose( ValueCallback uploadMsg, String acceptType )");



        }

        // Android > 4.1.1 调用这个方法
        public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
            Log.d("TAG", "openFileChoose(ValueCallback<Uri> uploadMsg, String acceptType, String capture)");


        }

        // For Android 5.0+
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            Log.e("ss111","click");

            return true;
        }
    };
    @OnClick(R.id.back)
    public void onViewClicked() {
        finishAfterTransition();
    }
}
