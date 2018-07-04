package jsondroid.android.com.mvpdemo02.mvp.login;

import jsondroid.android.com.mvpdemo02.retrofit.RetrofitClient;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wenbaohe on 2018/7/4.
 */

public class LoginHelper {
    private RetrofitClient  retrofitClient;

    public LoginHelper() {
        retrofitClient=new RetrofitClient();
    }
    /**
     * 登录
     */
    public Observable<Object> onLoginPost(String baseBody) {
        ILoginProvider iapiProvider = retrofitClient.retrofit().create(ILoginProvider.class);
        Observable<Object> observable = iapiProvider.loginpost(baseBody)
//                .timeout(5, TimeUnit.SECONDS)//重连间隔时间
//                .retry(2)//重连次数
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }
}
