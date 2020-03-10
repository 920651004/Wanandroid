package com.duan.wanandroid.ui.web;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.Html;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.duan.wanandroid.R;
import com.duan.wanandroid.base.BaseMvcActivity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;
import butterknife.OnClick;

public class WebDetialActivity extends BaseMvcActivity {

    @BindView(R.id.back)
    AppCompatImageView back;
    @BindView(R.id.tv_title)
    AppCompatTextView tvTitle;
    @BindView(R.id.tool_bar)
    RelativeLayout toolBar;
    @BindView(R.id.web)
    WebView webView;
    private String url;//传过来的url
    private String title;//传过来的title

    @Override
    public int getLayoutId() {
        return R.layout.activity_web_detial;
    }

    @Override
    public void initView() {
        url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");
        websetting();
        webView.loadUrl(url);
        tvTitle.setText(Html.fromHtml(title));
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
            showLoading();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            hideLoading();
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

        // For Android 5.0+
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            return true;
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.back)
    public void onViewClicked() {
        finishAfterTransition();
    }


}
