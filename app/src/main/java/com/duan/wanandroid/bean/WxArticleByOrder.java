package com.duan.wanandroid.bean;

import com.duan.wanandroid.base.network.factory.RetrofitFactory;
import com.duan.wanandroid.base.network.utils.CommJsonObserver;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Duan on 2019/11/5
 */
public class WxArticleByOrder {

    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10057,"link":"https://mp.weixin.qq.com/s/L5IdAq0nN9ud6_bjJ9UpmQ","niceDate":"2019-11-02","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1572624000000,"selfVisible":0,"shareDate":1572831371000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"我开发了一个神器！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10056,"link":"https://mp.weixin.qq.com/s/_pXtKCW60bIeZFxW8FKdXA","niceDate":"2019-11-01","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1572537600000,"selfVisible":0,"shareDate":1572831354000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Android Studio 还能这么玩？我也是服","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10055,"link":"https://mp.weixin.qq.com/s/m2gQ_OTMs1d47uMquRjI9w","niceDate":"2019-10-30","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1572364800000,"selfVisible":0,"shareDate":1572831335000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"为什么要学习跨平台？ Flutter 跨平台框架应用实战","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10054,"link":"https://mp.weixin.qq.com/s/PmLp31ZUT5f1ETdw5DJRKw","niceDate":"2019-10-29","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1572278400000,"selfVisible":0,"shareDate":1572831317000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"实现仿抖音视频滑动的两个方案","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9925,"link":"https://mp.weixin.qq.com/s/Pg4pKhSScK8NgtT2RDw2uQ","niceDate":"2019-10-24","niceShareDate":"2019-10-25","origin":"","prefix":"","projectLink":"","publishTime":1571846400000,"selfVisible":0,"shareDate":1572007879000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"终于找到一篇极佳的 NDK 入门文章","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9924,"link":"https://mp.weixin.qq.com/s/6zLLtY6ooMbujpF3bJFPPw","niceDate":"2019-10-22","niceShareDate":"2019-10-25","origin":"","prefix":"","projectLink":"","publishTime":1571673600000,"selfVisible":0,"shareDate":1572007860000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"基于Jetpack的全系列加实战 app 教程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9923,"link":"https://mp.weixin.qq.com/s/N3vp91usxclib1NuGEuPgA","niceDate":"2019-10-21","niceShareDate":"2019-10-25","origin":"","prefix":"","projectLink":"","publishTime":1571587200000,"selfVisible":0,"shareDate":1572007835000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"面试官：今日头条启动很快，你觉得可能是做了哪些优化？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9926,"link":"https://mp.weixin.qq.com/s/u3vxC_2u73fk4O9OvJq4tA","niceDate":"2019-10-18","niceShareDate":"2019-10-25","origin":"","prefix":"","projectLink":"","publishTime":1571328000000,"selfVisible":0,"shareDate":1572008005000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"各种版本的 玩Android 来啦！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9748,"link":"https://mp.weixin.qq.com/s/_6pulOeRmA-YVCcC2JfcLQ","niceDate":"2019-10-17","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1571241600000,"selfVisible":0,"shareDate":1571314415000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"都9102年了，Android 冷启动优化除了老三样还有哪些新招？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9747,"link":"https://mp.weixin.qq.com/s/4Ie4bkF8qG3yHWaqRIcbgw","niceDate":"2019-10-16","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1571155200000,"selfVisible":0,"shareDate":1571314396000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"JakeWharton评价我的代码像是在打地鼠？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9746,"link":"https://mp.weixin.qq.com/s/qzyfKv6iOHlVobVYi-Q4Mw","niceDate":"2019-10-15","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1571068800000,"selfVisible":0,"shareDate":1571314374000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"换掉Retrofit+RxJava, 开启 LiveData+Retrofit之路","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9745,"link":"https://mp.weixin.qq.com/s/KU0yFzuv8qxmhKk4NW9ZRw","niceDate":"2019-10-11","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1570723200000,"selfVisible":0,"shareDate":1571314348000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"面试官又来了：你的app卡顿过吗？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9744,"link":"https://mp.weixin.qq.com/s/C9USG-lKBvjg52oUoa9JfA","niceDate":"2019-10-10","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1570636800000,"selfVisible":0,"shareDate":1571314300000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"这交互炸了 第十五式 之 啡常OK","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9743,"link":"https://mp.weixin.qq.com/s/l0YPoqhww98mKO7NP-9egw","niceDate":"2019-10-09","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1570550400000,"selfVisible":0,"shareDate":1571314232000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"走心推荐几个必备的插件","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9742,"link":"https://mp.weixin.qq.com/s/6tAHfoBRx8ZhEZjpNXLUmA","niceDate":"2019-10-08","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1570464000000,"selfVisible":0,"shareDate":1571314216000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"面试常客：Intent 能传递多大 Size 的数据？| 附阿里的建议方案！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9390,"link":"https://mp.weixin.qq.com/s/gs2bojFLBB4IAWMyN9lfnw","niceDate":"2019-09-27","niceShareDate":"2019-09-27","origin":"","prefix":"","projectLink":"","publishTime":1569513600000,"selfVisible":0,"shareDate":1569585904000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"简书，掘金，CSDN，公众号，我要&ldquo;打&rdquo;四个！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9389,"link":"https://mp.weixin.qq.com/s/chcF5vRnFTvSlPti9mfa6A","niceDate":"2019-09-25","niceShareDate":"2019-09-27","origin":"","prefix":"","projectLink":"","publishTime":1569340800000,"selfVisible":0,"shareDate":1569585837000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"关于MVC/MVP/MVVM的一些错误认识","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9388,"link":"https://mp.weixin.qq.com/s/9akzn3SByjjOyo-LBStmTg","niceDate":"2019-09-24","niceShareDate":"2019-09-27","origin":"","prefix":"","projectLink":"","publishTime":1569254400000,"selfVisible":0,"shareDate":1569585820000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Android：你要了解的自定义View基础概念都在这里了！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9387,"link":"https://mp.weixin.qq.com/s/q0Vdx0qqYi54PffFq9pPnA","niceDate":"2019-09-23","niceShareDate":"2019-09-27","origin":"","prefix":"","projectLink":"","publishTime":1569168000000,"selfVisible":0,"shareDate":1569585796000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"GridLayoutManager这么用，你可能还真没尝试过","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9386,"link":"https://mp.weixin.qq.com/s/LzttT_New7ujdTi6mEmDdQ","niceDate":"2019-09-22","niceShareDate":"2019-09-27","origin":"","prefix":"","projectLink":"","publishTime":1569081600000,"selfVisible":0,"shareDate":1569585771000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"不破不立！","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":41,"size":20,"total":820}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10057,"link":"https://mp.weixin.qq.com/s/L5IdAq0nN9ud6_bjJ9UpmQ","niceDate":"2019-11-02","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1572624000000,"selfVisible":0,"shareDate":1572831371000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"我开发了一个神器！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10056,"link":"https://mp.weixin.qq.com/s/_pXtKCW60bIeZFxW8FKdXA","niceDate":"2019-11-01","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1572537600000,"selfVisible":0,"shareDate":1572831354000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Android Studio 还能这么玩？我也是服","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10055,"link":"https://mp.weixin.qq.com/s/m2gQ_OTMs1d47uMquRjI9w","niceDate":"2019-10-30","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1572364800000,"selfVisible":0,"shareDate":1572831335000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"为什么要学习跨平台？ Flutter 跨平台框架应用实战","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":10054,"link":"https://mp.weixin.qq.com/s/PmLp31ZUT5f1ETdw5DJRKw","niceDate":"2019-10-29","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1572278400000,"selfVisible":0,"shareDate":1572831317000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"实现仿抖音视频滑动的两个方案","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9925,"link":"https://mp.weixin.qq.com/s/Pg4pKhSScK8NgtT2RDw2uQ","niceDate":"2019-10-24","niceShareDate":"2019-10-25","origin":"","prefix":"","projectLink":"","publishTime":1571846400000,"selfVisible":0,"shareDate":1572007879000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"终于找到一篇极佳的 NDK 入门文章","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9924,"link":"https://mp.weixin.qq.com/s/6zLLtY6ooMbujpF3bJFPPw","niceDate":"2019-10-22","niceShareDate":"2019-10-25","origin":"","prefix":"","projectLink":"","publishTime":1571673600000,"selfVisible":0,"shareDate":1572007860000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"基于Jetpack的全系列加实战 app 教程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9923,"link":"https://mp.weixin.qq.com/s/N3vp91usxclib1NuGEuPgA","niceDate":"2019-10-21","niceShareDate":"2019-10-25","origin":"","prefix":"","projectLink":"","publishTime":1571587200000,"selfVisible":0,"shareDate":1572007835000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"面试官：今日头条启动很快，你觉得可能是做了哪些优化？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9926,"link":"https://mp.weixin.qq.com/s/u3vxC_2u73fk4O9OvJq4tA","niceDate":"2019-10-18","niceShareDate":"2019-10-25","origin":"","prefix":"","projectLink":"","publishTime":1571328000000,"selfVisible":0,"shareDate":1572008005000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"各种版本的 玩Android 来啦！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9748,"link":"https://mp.weixin.qq.com/s/_6pulOeRmA-YVCcC2JfcLQ","niceDate":"2019-10-17","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1571241600000,"selfVisible":0,"shareDate":1571314415000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"都9102年了，Android 冷启动优化除了老三样还有哪些新招？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9747,"link":"https://mp.weixin.qq.com/s/4Ie4bkF8qG3yHWaqRIcbgw","niceDate":"2019-10-16","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1571155200000,"selfVisible":0,"shareDate":1571314396000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"JakeWharton评价我的代码像是在打地鼠？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9746,"link":"https://mp.weixin.qq.com/s/qzyfKv6iOHlVobVYi-Q4Mw","niceDate":"2019-10-15","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1571068800000,"selfVisible":0,"shareDate":1571314374000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"换掉Retrofit+RxJava, 开启 LiveData+Retrofit之路","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9745,"link":"https://mp.weixin.qq.com/s/KU0yFzuv8qxmhKk4NW9ZRw","niceDate":"2019-10-11","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1570723200000,"selfVisible":0,"shareDate":1571314348000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"面试官又来了：你的app卡顿过吗？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9744,"link":"https://mp.weixin.qq.com/s/C9USG-lKBvjg52oUoa9JfA","niceDate":"2019-10-10","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1570636800000,"selfVisible":0,"shareDate":1571314300000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"这交互炸了 第十五式 之 啡常OK","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9743,"link":"https://mp.weixin.qq.com/s/l0YPoqhww98mKO7NP-9egw","niceDate":"2019-10-09","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1570550400000,"selfVisible":0,"shareDate":1571314232000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"走心推荐几个必备的插件","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9742,"link":"https://mp.weixin.qq.com/s/6tAHfoBRx8ZhEZjpNXLUmA","niceDate":"2019-10-08","niceShareDate":"2019-10-17","origin":"","prefix":"","projectLink":"","publishTime":1570464000000,"selfVisible":0,"shareDate":1571314216000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"面试常客：Intent 能传递多大 Size 的数据？| 附阿里的建议方案！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9390,"link":"https://mp.weixin.qq.com/s/gs2bojFLBB4IAWMyN9lfnw","niceDate":"2019-09-27","niceShareDate":"2019-09-27","origin":"","prefix":"","projectLink":"","publishTime":1569513600000,"selfVisible":0,"shareDate":1569585904000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"简书，掘金，CSDN，公众号，我要&ldquo;打&rdquo;四个！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9389,"link":"https://mp.weixin.qq.com/s/chcF5vRnFTvSlPti9mfa6A","niceDate":"2019-09-25","niceShareDate":"2019-09-27","origin":"","prefix":"","projectLink":"","publishTime":1569340800000,"selfVisible":0,"shareDate":1569585837000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"关于MVC/MVP/MVVM的一些错误认识","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9388,"link":"https://mp.weixin.qq.com/s/9akzn3SByjjOyo-LBStmTg","niceDate":"2019-09-24","niceShareDate":"2019-09-27","origin":"","prefix":"","projectLink":"","publishTime":1569254400000,"selfVisible":0,"shareDate":1569585820000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Android：你要了解的自定义View基础概念都在这里了！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9387,"link":"https://mp.weixin.qq.com/s/q0Vdx0qqYi54PffFq9pPnA","niceDate":"2019-09-23","niceShareDate":"2019-09-27","origin":"","prefix":"","projectLink":"","publishTime":1569168000000,"selfVisible":0,"shareDate":1569585796000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"GridLayoutManager这么用，你可能还真没尝试过","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9386,"link":"https://mp.weixin.qq.com/s/LzttT_New7ujdTi6mEmDdQ","niceDate":"2019-09-22","niceShareDate":"2019-09-27","origin":"","prefix":"","projectLink":"","publishTime":1569081600000,"selfVisible":0,"shareDate":1569585771000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"不破不立！","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : false
         * pageCount : 41
         * size : 20
         * total : 820
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * apkLink :
             * audit : 1
             * author : 鸿洋
             * chapterId : 408
             * chapterName : 鸿洋
             * collect : false
             * courseId : 13
             * desc :
             * envelopePic :
             * fresh : false
             * id : 10057
             * link : https://mp.weixin.qq.com/s/L5IdAq0nN9ud6_bjJ9UpmQ
             * niceDate : 2019-11-02
             * niceShareDate : 1天前
             * origin :
             * prefix :
             * projectLink :
             * publishTime : 1572624000000
             * selfVisible : 0
             * shareDate : 1572831371000
             * shareUser :
             * superChapterId : 408
             * superChapterName : 公众号
             * tags : [{"name":"公众号","url":"/wxarticle/list/408/1"}]
             * title : 我开发了一个神器！
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private int audit;
            private String author;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String niceShareDate;
            private String origin;
            private String prefix;
            private String projectLink;
            private long publishTime;
            private int selfVisible;
            private long shareDate;
            private String shareUser;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<TagsBean> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public int getAudit() {
                return audit;
            }

            public void setAudit(int audit) {
                this.audit = audit;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getNiceShareDate() {
                return niceShareDate;
            }

            public void setNiceShareDate(String niceShareDate) {
                this.niceShareDate = niceShareDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getSelfVisible() {
                return selfVisible;
            }

            public void setSelfVisible(int selfVisible) {
                this.selfVisible = selfVisible;
            }

            public long getShareDate() {
                return shareDate;
            }

            public void setShareDate(long shareDate) {
                this.shareDate = shareDate;
            }

            public String getShareUser() {
                return shareUser;
            }

            public void setShareUser(String shareUser) {
                this.shareUser = shareUser;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public static class TagsBean {
                /**
                 * name : 公众号
                 * url : /wxarticle/list/408/1
                 */

                private String name;
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }

    public static void WxOrder(int page, int id, CommJsonObserver<WxArticleByOrder> observer) {
        RetrofitFactory.getInstance().ARTICLE(id, page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }

    public static void WxByOrder(String k, int page, int id, CommJsonObserver<WxArticleByOrder> observer) {
        RetrofitFactory.getInstance().ARTICLE_BY_ORDER_OBSERVABLE(id, page, k)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
