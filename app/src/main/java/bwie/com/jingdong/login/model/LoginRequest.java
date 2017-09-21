package bwie.com.jingdong.login.model;

import java.io.IOException;
import java.util.Map;

import bwie.com.jingdong.utils.HttpUtil;
import bwie.com.jingdong.utils.NetCallBack;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/9
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class LoginRequest {
    private static volatile LoginRequest Instance;

    private LoginRequest() {

    }

    public static LoginRequest getInstance() {
        if (Instance == null) {
            synchronized (LoginRequest.class) {
                if (Instance == null) {
                    Instance = new LoginRequest();
                }
            }
        }
        return Instance;
    }

    public void postLoginRequest(String urlpath, Map<String, String> map, final NetCallBack<LoginBean> netcallBack) {

        HttpUtil.doPost(urlpath, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                netcallBack.onNetFail(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                //bean
//                callBack.onNetSuccess();
            }
        });
    }
}
