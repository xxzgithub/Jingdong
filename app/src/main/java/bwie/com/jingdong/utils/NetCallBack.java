package bwie.com.jingdong.utils;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/10
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public interface NetCallBack<T> {
    //加载
    void onStart();

    //请求数据成功
    void onNetSuccess(T t);

    //请求数据失败
    void onNetFail(T t);
}
