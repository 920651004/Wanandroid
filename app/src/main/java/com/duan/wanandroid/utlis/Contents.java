package com.duan.wanandroid.utlis;

/**
 * Created by yanfa-005 on 2018/10/15
 */

public class Contents {
    public static final int Main=100;
    public static final int Knowledge=101;
    public static final int Navigation=102;
    public static final int Project=103;
    public static final int WxActicle=104;
    /*
    * 方法：POST
    * 参数：username，password
    * */
    public  static String Login="http://www.wanandroid.com/user/login";
    /*
    * 方法：POST
    * 参数：username，password
    * */
    public static  String Register="http://www.wanandroid.com/user/register";
    /*
    * 方法：GET
    *  参数：无
    *  轮播图
    * */
    public static  String Baner="http://www.wanandroid.com/banner/json";
    public static  String Main_article="http://www.wanandroid.com/article/list/%d/json";
    /*
    * 知识体系
    * */
    public static String Main_Know="http://www.wanandroid.com/tree/json";
    /*
    * 导航
    * */
    public static String Main_Nav="http://www.wanandroid.com/navi/json";
    /*
    * 项目*/
    public static String Main_Pro="http://www.wanandroid.com/project/tree/json";
    /*
    * 项目分类
    * 参数 cid
    * get
    * */
    public static  String Main_Pro_artice="http://www.wanandroid.com/project/list/%d/json";
}
