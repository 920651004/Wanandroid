//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.duan.wanandroid.base.network.cookie;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public class CookieJarImpl implements CookieJar {
    private SPCookieStore cookieStore;

    public CookieJarImpl(SPCookieStore cookieStore) {
        if (cookieStore == null) {
            throw new IllegalArgumentException("cookieStore can not be null!");
        } else {
            this.cookieStore = cookieStore;
        }
    }

    public synchronized void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        this.cookieStore.saveCookie(url, cookies);
    }

    public synchronized List<Cookie> loadForRequest(HttpUrl url) {
        return this.cookieStore.loadCookie(url);
    }

    public SPCookieStore getCookieStore() {
        return this.cookieStore;
    }
}
