package com.duan.wanandroid.bean;

import com.duan.wanandroid.base.network.factory.RetrofitFactory;
import com.duan.wanandroid.base.network.utils.CommJsonObserver;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Duan on 2019/11/8
 *
 * @ProjectName: Wanandroid
 * @Package: com.duan.wanandroid.bean
 * @ClassName: HotText
 * @Description: j搜索热词
 * @Author: Duan
 * @CreateDate: 2019/11/8 15:27
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/11/8 15:27
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class HotText {

    /**
     * data : [{"id":6,"link":"","name":"面试","order":1,"visible":1},{"id":9,"link":"","name":"Studio3","order":1,"visible":1},{"id":5,"link":"","name":"动画","order":2,"visible":1},{"id":1,"link":"","name":"自定义View","order":3,"visible":1},{"id":2,"link":"","name":"性能优化 速度","order":4,"visible":1},{"id":3,"link":"","name":"gradle","order":5,"visible":1},{"id":4,"link":"","name":"Camera 相机","order":6,"visible":1},{"id":7,"link":"","name":"代码混淆 安全","order":7,"visible":1},{"id":8,"link":"","name":"逆向 加固","order":8,"visible":1}]
     * errorCode : 0
     * errorMsg :
     */

    private int errorCode;
    private String errorMsg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 6
         * link :
         * name : 面试
         * order : 1
         * visible : 1
         */

        private int id;
        private String link;
        private String name;
        private int order;
        private int visible;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }
    }
    public static void getHotTextinfo(CommJsonObserver<HotText> observer){
        RetrofitFactory.getInstance().HOT_TEXT_OBSERVABLE()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
