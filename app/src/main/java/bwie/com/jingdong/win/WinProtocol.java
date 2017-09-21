package bwie.com.jingdong.win;

import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import bwie.com.jingdong.R;
import bwie.com.jingdong.base.BaseActivity;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/14
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class WinProtocol extends BaseActivity {

    @BindView(R.id.btn_disagree)
    Button mBtnDisagree;
    @BindView(R.id.btn_consent)
    Button mBtnConsent;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.win_protocol_layout;
    }

    @OnClick({R.id.btn_disagree, R.id.btn_consent})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_disagree:
                finish();
                break;
            case R.id.btn_consent:
                finish();
                break;
        }
    }
}
