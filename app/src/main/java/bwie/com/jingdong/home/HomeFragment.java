package bwie.com.jingdong.home;

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

public class HomeFragment extends BaseFragment {

    @Override
    protected void initView() {

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.home_fragment;
    }

    public static HomeFragment newInstance(String s) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS, s);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
