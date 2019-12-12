package com.duan.wanandroid.bean;

import com.duan.wanandroid.base.network.RetrofitService;
import com.duan.wanandroid.base.network.factory.RetrofitFactory;
import com.duan.wanandroid.base.network.utils.CommJsonObserver;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Admin on 2019/12/6
 */
public class LoginInfo {

    /**
     * data : {"admin":false,"chapterTops":[],"collectIds":[8337,8335,8334],"email":"","icon":"","id":22637,"nickname":"18738783713","password":"","publicName":"18738783713","token":"","type":0,"username":"18738783713"}
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
         * admin : false
         * chapterTops : []
         * collectIds : [8337,8335,8334]
         * email :
         * icon :
         * id : 22637
         * nickname : 18738783713
         * password :
         * publicName : 18738783713
         * token :
         * type : 0
         * username : 18738783713
         */

        private boolean admin;
        private String email;
        private String icon;
        private int id;
        private String nickname;
        private String password;
        private String publicName;
        private String token;
        private int type;
        private String username;
        private List<?> chapterTops;
        private List<Integer> collectIds;

        public boolean isAdmin() {
            return admin;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPublicName() {
            return publicName;
        }

        public void setPublicName(String publicName) {
            this.publicName = publicName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public List<?> getChapterTops() {
            return chapterTops;
        }

        public void setChapterTops(List<?> chapterTops) {
            this.chapterTops = chapterTops;
        }

        public List<Integer> getCollectIds() {
            return collectIds;
        }

        public void setCollectIds(List<Integer> collectIds) {
            this.collectIds = collectIds;
        }
    }
    public static void Login(CommJsonObserver<LoginInfo> observer, HashMap<String,String>map){
        RetrofitFactory.getInstance().LOGIN_INFO_OBSERVABLE(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
