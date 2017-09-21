package bwie.com.jingdong.register.presenter;

import java.util.Map;

import bwie.com.jingdong.register.model.SaveBean;
import bwie.com.jingdong.register.model.SaveUserRequest;
import bwie.com.jingdong.utils.NetCallBack;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/13
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class SavePersenterImp implements ISavePersenter {


    public SavePersenterImp() {

    }

    @Override
    public void onSaveStart() {

    }

    @Override
    public void onSaveData(String phoneNum, Map parameterMap) {
        SaveUserRequest.getInstance().postSaveRequest(phoneNum, parameterMap, new NetCallBack<SaveBean>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onNetSuccess(SaveBean saveBean) {

            }

            @Override
            public void onNetFail(SaveBean saveBean) {

            }
        });
    }

    @Override
    public void onDetachView() {

    }

}
