package com.duan.wanandroid.utlis;/*
package com.aser.wanandroid.utlis;

import com.lzy.okgo.utils.IOUtils;
import com.lzy.okgo.utils.OkLogger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;

*/
/**
 * Created by Duan 2018/4/17
 *//*


public class TimeInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile TimeInterceptor.Level printLevel;
    private java.util.logging.Level colorLevel;
    private Logger logger;
    public static long tookMs;
    public TimeInterceptor(String tag) {
        this.printLevel = TimeInterceptor.Level.NONE;
        this.logger = Logger.getLogger(tag);
    }

    public void setPrintLevel(TimeInterceptor.Level level) {
        if(this.printLevel == null) {
            throw new NullPointerException("printLevel == null. Use Level.NONE instead.");
        } else {
            this.printLevel = level;
        }
    }

    public void setColorLevel(java.util.logging.Level level) {
        this.colorLevel = level;
    }

    private void log(String message) {
        this.logger.log(this.colorLevel, message);
    }

    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if(this.printLevel == TimeInterceptor.Level.NONE) {
            return chain.proceed(request);
        } else {
            this.logForRequest(request, chain.connection());
            long startNs = System.nanoTime();

            Response response;
            try {
                response = chain.proceed(request);
            } catch (Exception var8) {
                this.log("<-- HTTP FAILED: " + var8);
                throw var8;
            }

             tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
            return this.logForResponse(response, tookMs);
        }
    }

    private void logForRequest(Request request, Connection connection) throws IOException {
        boolean logBody = this.printLevel == TimeInterceptor.Level.BODY;
        boolean logHeaders = this.printLevel == TimeInterceptor.Level.BODY || this.printLevel == TimeInterceptor.Level.HEADERS;
        RequestBody requestBody = request.body();
        boolean hasRequestBody = requestBody != null;
        Protocol protocol = connection != null?connection.protocol(): Protocol.HTTP_1_1;

        try {
            String e = "--> " + request.method() + ' ' + request.url() + ' ' + protocol;
            this.log(e);
            if(logHeaders) {
                if(hasRequestBody) {
                    if(requestBody.contentType() != null) {
                        this.log("\tContents-Type: " + requestBody.contentType());
                    }

                    if(requestBody.contentLength() != -1L) {
                        this.log("\tContents-Length: " + requestBody.contentLength());
                    }
                }

                Headers headers = request.headers();
                int i = 0;

                for(int count = headers.size(); i < count; ++i) {
                    String name = headers.name(i);
                    if(!"Contents-Type".equalsIgnoreCase(name) && !"Contents-Length".equalsIgnoreCase(name)) {
                        this.log("\t" + name + ": " + headers.value(i));
                    }
                }

                this.log(" ");
                if(logBody && hasRequestBody) {
                    if(isPlaintext(requestBody.contentType())) {
                        this.bodyToString(request);
                    } else {
                        this.log("\tbody: maybe [binary body], omitted!");
                    }
                }
            }
        } catch (Exception var16) {
            OkLogger.printStackTrace(var16);
        } finally {
            this.log("--> END " + request.method());
        }

    }

    private Response logForResponse(Response response, long tookMs) {
        Response.Builder builder = response.newBuilder();
        Response clone = builder.build();
        ResponseBody responseBody = clone.body();
        boolean logBody = this.printLevel == TimeInterceptor.Level.BODY;
        boolean logHeaders = this.printLevel == TimeInterceptor.Level.BODY || this.printLevel == TimeInterceptor.Level.HEADERS;

        try {
            this.log("<-- " + clone.code() + ' ' + clone.message() + ' ' + clone.request().url() + " (" + tookMs + "ms）");
            if(logHeaders) {
                Headers e = clone.headers();
                int bytes = 0;

                for(int contentType = e.size(); bytes < contentType; ++bytes) {
                    this.log("\t" + e.name(bytes) + ": " + e.value(bytes));
                }

                this.log(" ");
                if(logBody && HttpHeaders.hasBody(clone)) {
                    if(responseBody == null) {
                        Response var20 = response;
                        return var20;
                    }

                    if(isPlaintext(responseBody.contentType())) {
                        byte[] var19 = IOUtils.toByteArray(responseBody.byteStream());
                        MediaType var21 = responseBody.contentType();
                        String body = new String(var19, getCharset(var21));
                        this.log("\tbody:" + body);
                        responseBody = ResponseBody.create(responseBody.contentType(), var19);
                        Response var13 = response.newBuilder().body(responseBody).build();
                        return var13;
                    }

                    this.log("\tbody: maybe [binary body], omitted!");
                }
            }
        } catch (Exception var17) {
            OkLogger.printStackTrace(var17);
        } finally {
            this.log("<-- END HTTP");
        }

        return response;
    }

    private static Charset getCharset(MediaType contentType) {
        Charset charset = contentType != null?contentType.charset(UTF8):UTF8;
        if(charset == null) {
            charset = UTF8;
        }

        return charset;
    }

    private static boolean isPlaintext(MediaType mediaType) {
        if(mediaType == null) {
            return false;
        } else if(mediaType.type() != null && mediaType.type().equals("text")) {
            return true;
        } else {
            String subtype = mediaType.subtype();
            if(subtype != null) {
                subtype = subtype.toLowerCase();
                if(subtype.contains("x-www-form-urlencoded") || subtype.contains("json") || subtype.contains("xml") || subtype.contains("html")) {
                    return true;
                }
            }

            return false;
        }
    }

    private void bodyToString(Request request) {
        try {
            Request e = request.newBuilder().build();
            RequestBody body = e.body();
            if(body == null) {
                return;
            }

            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            Charset charset = getCharset(body.contentType());
            this.log("\tbody:" + buffer.readString(charset));
        } catch (Exception var6) {
            OkLogger.printStackTrace(var6);
        }

    }

    public static enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY;

        private Level() {
        }
    }

}
*/
