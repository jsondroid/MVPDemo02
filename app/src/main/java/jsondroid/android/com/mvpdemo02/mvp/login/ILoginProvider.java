package jsondroid.android.com.mvpdemo02.mvp.login;

import jsondroid.android.com.mvpdemo02.retrofit.ServiceRXURL;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by wenbaohe on 2018/7/4.
 */

public interface ILoginProvider<RP, RQ> {
    /**
     * 登录
     */
    @Headers("Content-Type: application/json")
    @POST(ServiceRXURL.LOGIN_PATH)
    Observable<RP> loginpost(@Body RQ requestBody);
}
