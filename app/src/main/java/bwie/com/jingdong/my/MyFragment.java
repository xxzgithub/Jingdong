package bwie.com.jingdong.my;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;
import bwie.com.jingdong.Constants;
import bwie.com.jingdong.R;
import bwie.com.jingdong.base.BaseFragment;
import bwie.com.jingdong.login.view.LoginActivity;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/6
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class MyFragment extends BaseFragment {


    @BindView(R.id.my_img_bg_fragment)
    ImageView mMyImgBgFragment;
    @BindView(R.id.my_img_head)
    ImageView mMyImgHead;
    @BindView(R.id.my_set_img)
    ImageView mMySetImg;
    @BindView(R.id.my_word_img)
    ImageView mMyWordImg;
    @BindView(R.id.relative_head_my)
    RelativeLayout mRelativeHeadMy;
    @BindView(R.id.my_relative_order)
    LinearLayout mMyRelativeOrder;


    @Override
    protected void initView() {

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.my_fragment;
    }

    public static MyFragment newInstance(String s) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS, s);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @OnClick(R.id.relative_head_my)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), LoginActivity.class));
        getActivity().overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }
}
