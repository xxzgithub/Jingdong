package bwie.com.jingdong.register;

import java.io.IOException;

import bwie.com.jingdong.utils.HttpUtil;
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

public class QueryRequest {
    public static volatile QueryRequest instance;

    private QueryRequest() {
    }

    public static QueryRequest getInstance() {
        if (instance == null) {
            synchronized (QueryRequest.class) {
                if (instance == null) {
                    instance = new QueryRequest();
                }
            }
        }
        return instance;
    }

    public void getQueryRequst(String phoneNum, final QueryCallBack<Boolean> queryCallBack) {
        StringBuffer buffer = new StringBuffer();
        HttpUtil.doGet(getQueryPath(phoneNum), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                queryCallBack.succeedOrFail();
            }
        });
    }

    private String getQueryPath(String phoneNum) {
        StringBuffer buffer = new StringBuffer();
        StringBuffer append = buffer.append("").append(phoneNum);
        return append.toString();
    }
}
