package bwie.com.jingdong.register.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import bwie.com.jingdong.Constants;
import bwie.com.jingdong.R;
import bwie.com.jingdong.base.BaseActivity;
import bwie.com.jingdong.login.view.LoginActivity;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/11
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class EstimatePhoneRegister extends BaseActivity {
    @BindView(R.id.tv_phone_estimate)
    TextView mTvPhoneEstimate;
    @BindView(R.id.btn_yes_estimate)
    Button mBtnYesEstimate;
    @BindView(R.id.btn_no_estimate)
    Button mBtnNoEstimate;
    private String mPhoneNumber;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        mPhoneNumber = intent.getStringExtra("phoneNumber");
        mTvPhoneEstimate.setText(mPhoneNumber);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.estimate_phone_register;
    }


    @OnClick({R.id.btn_yes_estimate, R.id.btn_no_estimate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_yes_estimate:
                Intent intentYes = new Intent(this, LoginActivity.class);
                intentYes.putExtra(Constants.PHONENUM, mPhoneNumber);
                startActivity(intentYes);
                break;
            case R.id.btn_no_estimate:
                Intent intentNO = new Intent(this, PhoneCode.class);
                intentNO.putExtra(Constants.PHONENUM, mPhoneNumber);
                startActivity(intentNO);
                break;
        }
    }
}
