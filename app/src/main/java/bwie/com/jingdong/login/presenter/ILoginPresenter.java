package bwie.com.jingdong.login.presenter;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/10
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public interface ILoginPresenter {
    void loadStart();

    void detachView();

    void loadConfig(String urlpath, String name, String pwd);
}
