package bwie.com.jingdong.login.view;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/10
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public interface IloginView<T> {
    //显示隐藏进度条
    void showOrHideLoading(boolean flag);

    //显示隐藏容错页
    void showOrHideError(boolean flag);

    //刷新界面
    void refreshView(T t);
}
