package bwie.com.jingdong.discovery;

import android.os.Bundle;

import bwie.com.jingdong.Constants;
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

public class DiscoveryFragment extends BaseFragment {
    @Override
    protected void initView() {

    }

    @Override
    protected int attachLayoutRes() {
        return 0;
    }
    public static DiscoveryFragment newInstance(String s) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS, s);
        DiscoveryFragment fragment = new DiscoveryFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
