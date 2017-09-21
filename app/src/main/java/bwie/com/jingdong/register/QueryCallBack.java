package bwie.com.jingdong.register;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/13
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public interface QueryCallBack<T> {
    Boolean succeedOrFail(T t);
}
