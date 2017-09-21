package bwie.com.jingdong.login.presenter;

import java.util.HashMap;

import bwie.com.jingdong.login.model.LoginBean;
import bwie.com.jingdong.login.model.LoginRequest;
import bwie.com.jingdong.login.view.IloginView;
import bwie.com.jingdong.utils.NetCallBack;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/10
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class LoginPresenterImp implements ILoginPresenter {
    private IloginView mIloginView;

    private LoginPresenterImp() {
    }

    public LoginPresenterImp(IloginView Iview) {
        this.mIloginView = Iview;
    }

    @Override
    public void loadStart() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void loadConfig(String loginPath, String name, String pwd) {
        LoginRequest.getInstance().postLoginRequest(loginPath, new HashMap<String, String>(), new NetCallBack<LoginBean>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onNetSuccess(LoginBean loginBean) {

            }

            @Override
            public void onNetFail(LoginBean loginBean) {

            }


        });
    }
}
