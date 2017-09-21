package bwie.com.jingdong.classify;

import android.os.Bundle;

import bwie.com.jingdong.Constants;
import bwie.com.jingdong.R;
import bwie.com.jingdong.base.BaseFragment;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/6
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class ClassifyFragment extends BaseFragment {
    @Override
    protected void initView() {

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.classify_fragment;
    }
    public static ClassifyFragment newInstance(String s) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS, s);
        ClassifyFragment fragment = new ClassifyFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
