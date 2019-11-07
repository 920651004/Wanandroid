package com.duan.wanandroid.base;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.duan.wanandroid.R;

/**
 * Created by Duan on 2019/10/14.
 *
 * Activity中加载框
 */

public class BaseLoadingDialog extends Dialog {
    private String msg = "";
    private ObjectAnimator cycleAnimator;

    private LottieAnimationView animationView;
    public BaseLoadingDialog(Context context) {
        super(context, R.style.LoadingDialog);
    }

    public BaseLoadingDialog(Context context, String msg) {
        super(context, R.style.LoadingDialog);
        this.msg = msg;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_base_loading);
        setCancelable(false);
        animationView=findViewById(R.id.loading_anima);
        animationView.setAnimation("load.json");
        animationView.loop(true);
        animationView.playAnimation();
        /*TextView textView = this.findViewById(R.id.msg_tv);
        ImageView imageView = this.findViewById(R.id.iv);

        cycleAnimator = ObjectAnimator.ofFloat(imageView, "rotation", 360f);
        cycleAnimator.setDuration(1500);
        cycleAnimator.setInterpolator(new LinearInterpolator());
        cycleAnimator.setRepeatCount(ValueAnimator.INFINITE);
        cycleAnimator.start();

        if (msg == null) {
            textView.setVisibility(View.GONE);
        } else if (msg.length() == 0) {
            textView.setText("加载中");
        } else {
            textView.setText(msg);
        }*/
    }

    @Override
    public void dismiss() {
        if (animationView!=null&&animationView.isAnimating()){
            animationView.cancelAnimation();
            animationView=null;
        }
        super.dismiss();
    }
}
