package com.duan.wanandroid.ui.main;

import java.util.List;

/**
 * Created by yanfa-005 on 2018/10/17
 */

public class Mainbean {

    /**
     * data : {"curPage":2,"datas":[{"apkLink":"","author":"斜杠Allen","chapterId":185,"chapterName":"组件化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5160,"link":"https://www.jianshu.com/p/9cf03cff0f0f","niceDate":"2天前","origin":"","projectLink":"","publishTime":1539510171000,"superChapterId":80,"superChapterName":"热门专题","tags":[],"title":"我所理解的Android组件化之通信机制","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xujiaji","chapterId":76,"chapterName":"项目架构","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5159,"link":"https://blog.xujiaji.com/post/xmvp-framework","niceDate":"2天前","origin":"","projectLink":"","publishTime":1539490606000,"superChapterId":80,"superChapterName":"热门专题","tags":[],"title":"XMVP：一个通过泛型实现的MVP框架2年的演化路","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"谷歌开发者","chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":6891,"link":"http://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652047249&idx=1&sn=4f04b17d41cb80f8428c893c3d1653a5&chksm=808ca7d4b7fb2ec27de93f62e14cd4ce5a0c24187e19b7de600ab020532dfc031fce0daf68a8&scene=38#wechat_redirect","niceDate":"2018-10-14","origin":"","projectLink":"","publishTime":1539446400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"离线设计: 让您的应用真正做到随时可用","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" jokermonn","chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5158,"link":"https://juejin.im/post/5bb723036fb9a05d082a3688","niceDate":"2018-10-13","origin":"","projectLink":"","publishTime":1539426039000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"利用 Transform 解决模块化开发服务调用问题","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"谷歌开发者","chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":6320,"link":"http://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652047248&idx=1&sn=122bf9da05cf56bc2f7cb33a07f2dfb2&chksm=808ca7d5b7fb2ec3497005ed98174e09b2b4a5759f7c100bd271361c846f65ff09a3e0a20403&scene=38#wechat_redirect","niceDate":"2018-10-13","origin":"","projectLink":"","publishTime":1539360000000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"游戏用户体验设计洞察之《行尸走肉》","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"谷歌开发者","chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":6159,"link":"http://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652047241&idx=1&sn=e1285c96a0f861f4692b80e321581797&chksm=808ca7ccb7fb2edab94a5a1cc378b80938959a5acafce85d0dfcb7ae6b4d755acdbe22e337cf&scene=38#wechat_redirect","niceDate":"2018-10-12","origin":"","projectLink":"","publishTime":1539273600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"Android Jetpack: LiveData 和 Lifecycle 介绍 | 中文教学视频","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5736,"link":"http://mp.weixin.qq.com/s?__biz=MzIxNzU1Nzk3OQ==&mid=2247487420&idx=1&sn=8c8e9aad327af49192866dedec401474&chksm=97f6b108a081381e2907159ef344192547600a7d0241d2e95b60bc8bdb48087f827534546974&scene=38#wechat_redirect","niceDate":"2018-10-12","origin":"","projectLink":"","publishTime":1539273600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"30条编程名言佳句： 这不是Bug只是未知的特性","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5856,"link":"https://mp.weixin.qq.com/s/EEA0djB4-NLHPXT4lWd6qQ","niceDate":"2018-10-12","origin":"","projectLink":"","publishTime":1539273600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"PageLayout状态页切换 加载中-空数据-错误页","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"郭霖","chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5859,"link":"https://mp.weixin.qq.com/s/17o5ErWh4-syS0BqoGKR3A","niceDate":"2018-10-12","origin":"","projectLink":"","publishTime":1539273600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"新版LitePal发布，一次不可思议的升级","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"玉刚说","chapterId":410,"chapterName":"玉刚说","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5862,"link":"https://mp.weixin.qq.com/s/DXKwYn7pMwQ-oVdBJPBYbA","niceDate":"2018-10-12","origin":"","projectLink":"","publishTime":1539273600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/410/1"}],"title":"我身边读研的程序员，没有一个不后悔的","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5864,"link":"https://mp.weixin.qq.com/s/SyRSfZ1JCMDR-9Qo9eOAgw","niceDate":"2018-10-12","origin":"","projectLink":"","publishTime":1539273600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"30条编程名言佳句： 这不是Bug只是未知的特性","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"凤邪摩羯","chapterId":40,"chapterName":"Context","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3477,"link":"https://www.jianshu.com/p/92392088a7a8","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539264951000,"superChapterId":10,"superChapterName":"四大组件","tags":[],"title":"为什么 Dialog不能使用Application的Context","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"潇湘剑雨_","chapterId":32,"chapterName":"PopupWindow","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3476,"link":"https://www.jianshu.com/p/2386b314714c","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539264925000,"superChapterId":30,"superChapterName":"用户交互","tags":[],"title":"PopupWindow源码分析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"老邢Thierry","chapterId":222,"chapterName":"持续集成","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3475,"link":"https://www.jianshu.com/p/af9020faafc9","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539264903000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"知乎客户端内测和灰度方案演进","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"尹star","chapterId":40,"chapterName":"Context","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3474,"link":"https://www.jianshu.com/p/94e0f9ab3f1d","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539264856000,"superChapterId":10,"superChapterName":"四大组件","tags":[],"title":"Context都没弄明白，还怎么做Android开发？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5641,"link":"http://mp.weixin.qq.com/s?__biz=MzIxNzU1Nzk3OQ==&mid=2247487414&idx=1&sn=cce18c78c28a935ecb3618b54748b3a0&chksm=97f6b102a08138144fd9c02288b12faaa22595c461d357b37ca3b34960e0ed3ae1ef70ec5346&scene=38#wechat_redirect","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539187200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"安卓软件逆向工程基础概念","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"谷歌开发者","chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":6492,"link":"http://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652047240&idx=1&sn=0f827543bf224225de07ee8bb618078e&chksm=808ca7cdb7fb2edbab42302bc3789df6134f9a52ec5940278e9a1cde8d4b29cd9347c6fb1773&scene=38#wechat_redirect","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539187200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"让现实和虚拟无缝连接，来看火爆的 ARCore 应用","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"美团技术团队","chapterId":417,"chapterName":"美团技术团队","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7301,"link":"http://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651748960&idx=1&sn=2bd11c883ecc787e634bc3c29dfbbe50&chksm=bd12a32d8a652a3b25f26de739555341937697e02f2f01017129514624cdb0dd2e2bdd844acb&scene=38#wechat_redirect","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539187200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/417/1"}],"title":"Logan：美团点评的开源移动端基础日志库","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"美团技术团队","chapterId":417,"chapterName":"美团技术团队","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7315,"link":"http://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651748960&idx=3&sn=93b468b875ee1e2d72c0a0c3464831a3&chksm=bd12a32d8a652a3b580b1ccac86c98204691dffa8ef1dbef3ac65fe7bca2ac9d6562a45aa501&scene=38#wechat_redirect","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539187200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/417/1"}],"title":"【基本功】 前端安全系列之二：如何防止CSRF攻击？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"美团技术团队","chapterId":417,"chapterName":"美团技术团队","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7110,"link":"http://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651748960&idx=2&sn=4c637290b0bd35dc5b541d01d76ce574&chksm=bd12a32d8a652a3b24e159f352c835fd7ff4eedead31dd5b0d0ae2c21da4a0fc587f69a99aef&scene=38#wechat_redirect","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539187200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/417/1"}],"title":"基于TensorFlow Serving的深度学习在线预估","type":0,"userId":-1,"visible":1,"zan":0}],"offset":20,"over":false,"pageCount":280,"size":20,"total":5583}
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
         * curPage : 2
         * datas : [{"apkLink":"","author":"斜杠Allen","chapterId":185,"chapterName":"组件化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5160,"link":"https://www.jianshu.com/p/9cf03cff0f0f","niceDate":"2天前","origin":"","projectLink":"","publishTime":1539510171000,"superChapterId":80,"superChapterName":"热门专题","tags":[],"title":"我所理解的Android组件化之通信机制","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xujiaji","chapterId":76,"chapterName":"项目架构","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5159,"link":"https://blog.xujiaji.com/post/xmvp-framework","niceDate":"2天前","origin":"","projectLink":"","publishTime":1539490606000,"superChapterId":80,"superChapterName":"热门专题","tags":[],"title":"XMVP：一个通过泛型实现的MVP框架2年的演化路","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"谷歌开发者","chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":6891,"link":"http://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652047249&idx=1&sn=4f04b17d41cb80f8428c893c3d1653a5&chksm=808ca7d4b7fb2ec27de93f62e14cd4ce5a0c24187e19b7de600ab020532dfc031fce0daf68a8&scene=38#wechat_redirect","niceDate":"2018-10-14","origin":"","projectLink":"","publishTime":1539446400000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"离线设计: 让您的应用真正做到随时可用","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" jokermonn","chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5158,"link":"https://juejin.im/post/5bb723036fb9a05d082a3688","niceDate":"2018-10-13","origin":"","projectLink":"","publishTime":1539426039000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"利用 Transform 解决模块化开发服务调用问题","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"谷歌开发者","chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":6320,"link":"http://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652047248&idx=1&sn=122bf9da05cf56bc2f7cb33a07f2dfb2&chksm=808ca7d5b7fb2ec3497005ed98174e09b2b4a5759f7c100bd271361c846f65ff09a3e0a20403&scene=38#wechat_redirect","niceDate":"2018-10-13","origin":"","projectLink":"","publishTime":1539360000000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"游戏用户体验设计洞察之《行尸走肉》","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"谷歌开发者","chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":6159,"link":"http://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652047241&idx=1&sn=e1285c96a0f861f4692b80e321581797&chksm=808ca7ccb7fb2edab94a5a1cc378b80938959a5acafce85d0dfcb7ae6b4d755acdbe22e337cf&scene=38#wechat_redirect","niceDate":"2018-10-12","origin":"","projectLink":"","publishTime":1539273600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"Android Jetpack: LiveData 和 Lifecycle 介绍 | 中文教学视频","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5736,"link":"http://mp.weixin.qq.com/s?__biz=MzIxNzU1Nzk3OQ==&mid=2247487420&idx=1&sn=8c8e9aad327af49192866dedec401474&chksm=97f6b108a081381e2907159ef344192547600a7d0241d2e95b60bc8bdb48087f827534546974&scene=38#wechat_redirect","niceDate":"2018-10-12","origin":"","projectLink":"","publishTime":1539273600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"30条编程名言佳句： 这不是Bug只是未知的特性","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5856,"link":"https://mp.weixin.qq.com/s/EEA0djB4-NLHPXT4lWd6qQ","niceDate":"2018-10-12","origin":"","projectLink":"","publishTime":1539273600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"PageLayout状态页切换 加载中-空数据-错误页","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"郭霖","chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5859,"link":"https://mp.weixin.qq.com/s/17o5ErWh4-syS0BqoGKR3A","niceDate":"2018-10-12","origin":"","projectLink":"","publishTime":1539273600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"新版LitePal发布，一次不可思议的升级","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"玉刚说","chapterId":410,"chapterName":"玉刚说","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5862,"link":"https://mp.weixin.qq.com/s/DXKwYn7pMwQ-oVdBJPBYbA","niceDate":"2018-10-12","origin":"","projectLink":"","publishTime":1539273600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/410/1"}],"title":"我身边读研的程序员，没有一个不后悔的","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5864,"link":"https://mp.weixin.qq.com/s/SyRSfZ1JCMDR-9Qo9eOAgw","niceDate":"2018-10-12","origin":"","projectLink":"","publishTime":1539273600000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"30条编程名言佳句： 这不是Bug只是未知的特性","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"凤邪摩羯","chapterId":40,"chapterName":"Context","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3477,"link":"https://www.jianshu.com/p/92392088a7a8","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539264951000,"superChapterId":10,"superChapterName":"四大组件","tags":[],"title":"为什么 Dialog不能使用Application的Context","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"潇湘剑雨_","chapterId":32,"chapterName":"PopupWindow","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3476,"link":"https://www.jianshu.com/p/2386b314714c","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539264925000,"superChapterId":30,"superChapterName":"用户交互","tags":[],"title":"PopupWindow源码分析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"老邢Thierry","chapterId":222,"chapterName":"持续集成","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3475,"link":"https://www.jianshu.com/p/af9020faafc9","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539264903000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"知乎客户端内测和灰度方案演进","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"尹star","chapterId":40,"chapterName":"Context","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3474,"link":"https://www.jianshu.com/p/94e0f9ab3f1d","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539264856000,"superChapterId":10,"superChapterName":"四大组件","tags":[],"title":"Context都没弄明白，还怎么做Android开发？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"code小生","chapterId":414,"chapterName":"code小生","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":5641,"link":"http://mp.weixin.qq.com/s?__biz=MzIxNzU1Nzk3OQ==&mid=2247487414&idx=1&sn=cce18c78c28a935ecb3618b54748b3a0&chksm=97f6b102a08138144fd9c02288b12faaa22595c461d357b37ca3b34960e0ed3ae1ef70ec5346&scene=38#wechat_redirect","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539187200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/414/1"}],"title":"安卓软件逆向工程基础概念","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"谷歌开发者","chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":6492,"link":"http://mp.weixin.qq.com/s?__biz=MzAwODY4OTk2Mg==&mid=2652047240&idx=1&sn=0f827543bf224225de07ee8bb618078e&chksm=808ca7cdb7fb2edbab42302bc3789df6134f9a52ec5940278e9a1cde8d4b29cd9347c6fb1773&scene=38#wechat_redirect","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539187200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"让现实和虚拟无缝连接，来看火爆的 ARCore 应用","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"美团技术团队","chapterId":417,"chapterName":"美团技术团队","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7301,"link":"http://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651748960&idx=1&sn=2bd11c883ecc787e634bc3c29dfbbe50&chksm=bd12a32d8a652a3b25f26de739555341937697e02f2f01017129514624cdb0dd2e2bdd844acb&scene=38#wechat_redirect","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539187200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/417/1"}],"title":"Logan：美团点评的开源移动端基础日志库","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"美团技术团队","chapterId":417,"chapterName":"美团技术团队","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7315,"link":"http://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651748960&idx=3&sn=93b468b875ee1e2d72c0a0c3464831a3&chksm=bd12a32d8a652a3b580b1ccac86c98204691dffa8ef1dbef3ac65fe7bca2ac9d6562a45aa501&scene=38#wechat_redirect","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539187200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/417/1"}],"title":"【基本功】 前端安全系列之二：如何防止CSRF攻击？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"美团技术团队","chapterId":417,"chapterName":"美团技术团队","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":7110,"link":"http://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651748960&idx=2&sn=4c637290b0bd35dc5b541d01d76ce574&chksm=bd12a32d8a652a3b24e159f352c835fd7ff4eedead31dd5b0d0ae2c21da4a0fc587f69a99aef&scene=38#wechat_redirect","niceDate":"2018-10-11","origin":"","projectLink":"","publishTime":1539187200000,"superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/417/1"}],"title":"基于TensorFlow Serving的深度学习在线预估","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 20
         * over : false
         * pageCount : 280
         * size : 20
         * total : 5583
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
             * author : 斜杠Allen
             * chapterId : 185
             * chapterName : 组件化
             * collect : false
             * courseId : 13
             * desc :
             * envelopePic :
             * fresh : false
             * id : 5160
             * link : https://www.jianshu.com/p/9cf03cff0f0f
             * niceDate : 2天前
             * origin :
             * projectLink :
             * publishTime : 1539510171000
             * superChapterId : 80
             * superChapterName : 热门专题
             * tags : []
             * title : 我所理解的Android组件化之通信机制
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            private String apkLink;
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
            private String origin;
            private String projectLink;
            private long publishTime;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<?> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
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

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
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

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }
        }
    }
}
