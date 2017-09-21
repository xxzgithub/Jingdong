package bwie.com.jingdong.register.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import bwie.com.jingdong.Constants;
import bwie.com.jingdong.R;
import bwie.com.jingdong.base.BaseActivity;
import bwie.com.jingdong.utils.ToastUtil;
import bwie.com.jingdong.widget.CustomEditText;
import bwie.com.jingdong.widget.CustomLoginTitleBar;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/11
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class PhoneCode extends BaseActivity {

    @BindView(R.id.tv_phone_code)
    TextView mTvPhoneCode;
    @BindView(R.id.et_phoneCodes)
    CustomEditText mEtPhoneCodes;
    @BindView(R.id.btn_reset_code)
    Button mBtnResetCode;
    @BindView(R.id.bin_next_code)
    Button mBinNextCode;
    @BindView(R.id.title_bar_code)
    CustomLoginTitleBar mTitleBarCode;
    private EventHandler mEventHandler;
    private String phone;
    public String country = "86";//这是中国区号，如果需要其他国家列表，可以使用getSupportedCountries();获得国家区号

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //计时器
        new CountDownTimer(119000, 1000) {
            public void onTick(long millisUntilFinished) {
                mBtnResetCode.setText("正在发送" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mBtnResetCode.setEnabled(true);
                mBtnResetCode.setText("重新发送");
                mBtnResetCode.setBackgroundColor(Color.RED);
            }
        }.start();
        // 创建EventHandler对象
        mEventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (data instanceof Throwable) {
                    Throwable throwable = (Throwable) data;
                    String msg = throwable.getMessage();
//                    Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
                } else {
                    if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        // 处理你自己的逻辑
                    }
                }
            }
        };
        mEtPhoneCodes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mBinNextCode.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ((mEtPhoneCodes.getText().toString() == null || !mEtPhoneCodes.getText().toString().equals(""))) {
                    mBinNextCode.setEnabled(true);
                } else {
                    mBinNextCode.setEnabled(false);
                }
            }
        });

        mTitleBarCode.setOnImgClickListener(new CustomLoginTitleBar.OnImgClickListener() {
            @Override
            public void onImgClickListener(View view) {
                finish();
            }
        });
        SMSSDK.registerEventHandler(mEventHandler); //注册短信回调（记得销毁，避免泄露内存）
    }

    @Override
    protected int getLayoutId() {
        return R.layout.phonecode;
    }

    @OnClick({R.id.btn_reset_code, R.id.bin_next_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_reset_code:
                ToastUtil.showLongToastCenter("重新发送");
                Intent intent = getIntent();
                phone = intent.getStringExtra(Constants.PHONENUM);
                SMSSDK.getVerificationCode(country, phone);
                new CountDownTimer(119000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        mBtnResetCode.setEnabled(false);
                        mBtnResetCode.setText("正在发送" + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        mBtnResetCode.setEnabled(true);
                        mBtnResetCode.setText("重新发送");
                        mBtnResetCode.setBackgroundColor(Color.RED);
                    }
                }.start();
                break;
            case R.id.bin_next_code:
                //查数据库
                //判断要跳转的页面

                break;
        }
    }

    //销毁短信注册
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 注销回调接口registerEventHandler必须和unregisterEventHandler配套使用，否则可能造成内存泄漏。
        SMSSDK.unregisterEventHandler(mEventHandler);
    }
}
