package bwie.com.jingdong.register.model;

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
 * 创建日期: 2017/9/13
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class SaveUserRequest {
    private static volatile SaveUserRequest instance;

    private SaveUserRequest() {
    }

    public static SaveUserRequest getInstance() {
        if (instance == null) {
            synchronized (SaveUserRequest.class) {
                if (instance == null) {
                    instance = new SaveUserRequest();
                }
            }
        }
        return instance;
    }

    public void postSaveRequest(String savepath, Map map, NetCallBack<SaveBean> netcallBack) {
        netcallBack.onStart();
        HttpUtil.doPost(savepath, map, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
