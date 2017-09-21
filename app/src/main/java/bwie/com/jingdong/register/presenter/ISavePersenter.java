package bwie.com.jingdong.register.presenter;

import java.util.Map;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/13
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public interface ISavePersenter {
    //加载loading
    void onSaveStart();

    //加载数据
    void onSaveData(String phoneNum, Map parameterMap);

    //销毁View
    void onDetachView();
}
