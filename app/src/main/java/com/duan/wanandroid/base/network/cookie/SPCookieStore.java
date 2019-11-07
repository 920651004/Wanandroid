//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.duan.wanandroid.base.network.cookie;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Cookie;
import okhttp3.HttpUrl;

public class SPCookieStore{
    private static final String COOKIE_PREFS = "okhttp_cookie";
    private final Map<String, ConcurrentHashMap<String, Cookie>> cookies;
    private final SharedPreferences cookiePrefs;

    public SPCookieStore(Context context) {
        this.cookiePrefs = context.getSharedPreferences(COOKIE_PREFS, 0);
        this.cookies = new HashMap<>();
        Map<String, ?> prefsMap = this.cookiePrefs.getAll();
        Iterator var3 = prefsMap.entrySet().iterator();

        while(true) {
            Entry entry;
            do {
                do {
                    if (!var3.hasNext()) {
                        return;
                    }

                    entry = (Entry)var3.next();
                } while(entry.getValue() == null);
            } while(((String)entry.getKey()).startsWith("cookie_"));

            String[] cookieNames = TextUtils.split((String)entry.getValue(), ",");

            for (String name : cookieNames) {
                String encodedCookie = this.cookiePrefs.getString("cookie_" + name, null);
                if (encodedCookie != null) {
                    Cookie decodedCookie = SerializableCookie.decodeCookie(encodedCookie);
                    if (decodedCookie != null) {
                        String key = String.valueOf(entry.getKey());
                        if (!this.cookies.containsKey(key)) {
                            this.cookies.put(key, new ConcurrentHashMap<String, Cookie>());
                        } else {
                            ConcurrentHashMap<String, Cookie> cookieMap = this.cookies.get(key);
                            if (cookieMap != null) {
                                cookieMap.put(name, decodedCookie);
                            }
                        }
                    }
                }
            }
        }
    }

    private String getCookieToken(Cookie cookie) {
        return cookie.name() + "@" + cookie.domain();
    }

    private static boolean isCookieExpired(Cookie cookie) {
        return cookie.expiresAt() < System.currentTimeMillis();
    }

    public synchronized void saveCookie(HttpUrl url, List<Cookie> urlCookies) {
        for (Cookie cookie : urlCookies) {
            this.saveCookie(url, cookie);
        }
    }

    public synchronized void saveCookie(HttpUrl url, Cookie cookie) {
        if (!this.cookies.containsKey(url.host())) {
            this.cookies.put(url.host(), new ConcurrentHashMap<String, Cookie>());
        }

        if (isCookieExpired(cookie)) {
            this.removeCookie(url, cookie);
        } else {
            this.saveCookie(url, cookie, this.getCookieToken(cookie));
        }

    }

    private void saveCookie(HttpUrl url, Cookie cookie, String cookieToken) {
        ConcurrentHashMap<String, Cookie> cookieMap = this.cookies.get(url.host());
        if (cookieMap != null){
            cookieMap.put(cookieToken, cookie);
            Editor prefsWriter = this.cookiePrefs.edit();
            prefsWriter.putString(url.host(), TextUtils.join(",", cookieMap.keySet()));
            prefsWriter.putString("cookie_" + cookieToken, SerializableCookie.encodeCookie(url.host(), cookie));
            prefsWriter.apply();
        }
    }

    public synchronized List<Cookie> loadCookie(HttpUrl url) {
        List<Cookie> ret = new ArrayList<>();
        if (!this.cookies.containsKey(url.host())) {
            return ret;
        } else {
            ConcurrentHashMap<String, Cookie> cookieMap = this.cookies.get(url.host());
            if (cookieMap != null){
                Collection<Cookie> urlCookies = cookieMap.values();

                for (Cookie cookie : urlCookies) {
                    if (isCookieExpired(cookie)) {
                        this.removeCookie(url, cookie);
                    } else {
                        ret.add(cookie);
                    }
                } 
            }
            return ret;
        }
    }

    public synchronized boolean removeCookie(HttpUrl url, Cookie cookie) {
        if (!this.cookies.containsKey(url.host())) {
            return false;
        } else {
            ConcurrentHashMap<String, Cookie> cookieMap = this.cookies.get(url.host());
            if (cookieMap == null)
                return false;
            String cookieToken = this.getCookieToken(cookie);
            if (!cookieMap.containsKey(cookieToken)) {
                return false;
            } else {
                cookieMap.remove(cookieToken);
                Editor prefsWriter = this.cookiePrefs.edit();
                if (this.cookiePrefs.contains("cookie_" + cookieToken)) {
                    prefsWriter.remove("cookie_" + cookieToken);
                }

                prefsWriter.putString(url.host(), TextUtils.join(",", cookieMap.keySet()));
                prefsWriter.apply();
                return true;
            }
        }
    }

    public synchronized boolean removeCookie(HttpUrl url) {
        if (!this.cookies.containsKey(url.host())) {
            return false;
        } else {
            ConcurrentHashMap<String, Cookie> urlCookie = this.cookies.remove(url.host());
            if (urlCookie == null)
                return false;
            Set<String> cookieTokens = urlCookie.keySet();
            Editor prefsWriter = this.cookiePrefs.edit();

            for (String cookieToken : cookieTokens) {
                if (this.cookiePrefs.contains("cookie_" + cookieToken)) {
                    prefsWriter.remove("cookie_" + cookieToken);
                }
            }

            prefsWriter.remove(url.host());
            prefsWriter.apply();
            return true;
        }
    }

    public synchronized boolean removeAllCookie() {
        this.cookies.clear();
        Editor prefsWriter = this.cookiePrefs.edit();
        prefsWriter.clear();
        prefsWriter.apply();
        return true;
    }

    public synchronized List<Cookie> getAllCookie() {
        List<Cookie> ret = new ArrayList<>();

        for (String key : this.cookies.keySet()) {
            ConcurrentHashMap<String, Cookie> cookieMap = this.cookies.get(key);
            if (cookieMap != null){
                ret.addAll(cookieMap.values());
            }
        }

        return ret;
    }

    public synchronized List<Cookie> getCookie(HttpUrl url) {
        List<Cookie> ret = new ArrayList<>();
        ConcurrentHashMap<String, Cookie> cookieMap = this.cookies.get(url.host());
        if (cookieMap != null) {
            ret.addAll(cookieMap.values());
        }

        return ret;
    }
}
