package com.duan.wanandroid.utlis;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.duan.wanandroid.R;
import com.duan.wanandroid.base.BaseApplication;
import com.duan.wanandroid.ui.callback.CallBackActivity;
import com.duan.wanandroid.ui.search.SearchMvpActivity;
import com.duan.wanandroid.ui.searchlist.SearchListActivity;
import com.duan.wanandroid.ui.web.WebDetialActivity;

import java.util.UUID;

/**
 * Created by Duan on 2019/11/19
 *
 * @ProjectName: Wanandroid
 * @Package: com.duan.wanandroid.utlis
 * @ClassName: JumpUtlis
 * @Description: 用于acticity的跳转
 * @Author: Duan
 * @CreateDate: 2019/11/19 10:28
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/19 10:28
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class JumpUtlis {
    public static boolean checkPermissionAllGranted(String permissions,Context context) {
        PackageManager pm = context.getPackageManager();
        boolean permission_readStorage = (PackageManager.PERMISSION_GRANTED ==
                pm.checkPermission(permissions, AppUtils.getAppPackageName()));
        return permission_readStorage;
    }
    private static Intent intent;
    /**
     *@author Duan
     *@time 2019/11/19  11:33
     *@describe  WebDetialActivity
     */
    
    public static void  ToWebDetial(Context mContext,String url,String title,ActivityOptions options){
        intent=new Intent(mContext, CallBackActivity.class);
        intent.putExtra("url",url);
        intent.putExtra("title",title);
        mContext.startActivity(intent,options.toBundle());
    }
    /**
     *@author Duan
     *@time 2019/11/19  11:34
     *@describe  SearchListActivity
     */
    public static void GoSearchDetial(Context mContext, String text){
        intent=new Intent(mContext,SearchListActivity.class);
        intent.putExtra("search_text",text);
        mContext.startActivity(intent);
    }
    /**
     *@author Duan
     *@time 2019/11/19  11:31
     *@describe  跳转到SearchMvpActivity
     */
    public static void ToSearch(Context mContext){
        intent=new Intent(mContext, SearchMvpActivity.class);
        mContext.startActivity(intent);
    }
}
