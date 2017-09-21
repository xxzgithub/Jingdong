package bwie.com.jingdong.register.view;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/13
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public interface ISaveView<T> {
    //显示隐藏进度条
    void showOrHideLoading(boolean flag);

    //显示隐藏提示
    void showOrHideHint(boolean flag);

    //刷新View
    void refreshView(T t);
}
