package jsondroid.android.com.mvpdemo02.retrofit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jsondroid.android.com.mvpdemo02.mvp.login.ILoginProvider;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wenbaohe on 2017/11/24.
 * <p>
 * <p>
 * if (e instanceof APIException) {
 * APIException exception = (APIException) e;
 * ToastUtil.showToast( exception.message);
 * } else if (e instanceof UnknownHostException) {
 * ToastUtil.showToast("请打开网络");
 * } else if (e instanceof SocketTimeoutException) {
 * ToastUtil.showToast( "请求超时");
 * } else if (e instanceof ConnectException) {
 * ToastUtil.showToast("连接失败");
 * } else if (e instanceof HttpException) {
 * ToastUtil.showToast("请求超时");
 * }else {
 * ToastUtil.showToast("请求失败");
 * }
 * e.printStackTrace();
 */

public class RetrofitClient {
    private static final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();
    private int mTimeOut = 60 * 2;

    public RetrofitClient(int timeOut) {
        this.mTimeOut = timeOut;
    }

    public RetrofitClient() {

    }

    public Retrofit retrofit() {
        return retrofit(mTimeOut);
    }

    public Retrofit retrofit(long timeout) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (IBaseAPIProvider.DEBUG) {
            // Log信息拦截器
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            //设置 Debug Log 模式
            builder.addInterceptor(loggingInterceptor);
        }
        OkHttpClient okHttpClient = builder
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .cookieJar(new CookieJar() {
                    @Override
                    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                        cookieStore.put(httpUrl, list);
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                        List<Cookie> cookies = cookieStore.get(httpUrl);
                        return cookies != null ? cookies : new ArrayList<Cookie>();
                    }
                })
                .build();
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(ServiceRXURL.SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return mRetrofit;
    }


}
