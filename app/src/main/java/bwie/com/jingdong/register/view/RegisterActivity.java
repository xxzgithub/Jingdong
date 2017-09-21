package bwie.com.jingdong.register.view;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import bwie.com.jingdong.Code;
import bwie.com.jingdong.Constants;
import bwie.com.jingdong.R;
import bwie.com.jingdong.base.BaseActivity;
import bwie.com.jingdong.register.model.SaveBean;
import bwie.com.jingdong.utils.ToastUtil;
import bwie.com.jingdong.widget.CustomEditText;
import bwie.com.jingdong.widget.CustomLoginTitleBar;
import cn.smssdk.SMSSDK;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/11
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注： //对手机号进行加密
 * //对比数据库看看是不是手机号以前注册过...
 * //数据库里有,跳转清除,或直接登录界面
 * //数据里没有直接跳转到设置密码的界面
 */

public class RegisterActivity extends BaseActivity implements ISaveView<SaveBean>, TextWatcher {

    @BindView(R.id.et_phone_register)
    CustomEditText mEtPhoneRegister;
    @BindView(R.id.et_verify_register)
    EditText mEtVerifyRegister;
    @BindView(R.id.img_verification_code)
    ImageView mImgVerificationCode;
    @BindView(R.id.btn_register)
    Button mBtnRegister;
    @BindView(R.id.title_bar_register)
    CustomLoginTitleBar mTitleBarRegister;
    @BindView(R.id.register_loading)
    ImageView mRegisterLoading;

    private String mRealCode;
    private AlertDialog.Builder mBuilder;
    private Dialog mMCameraDialog;

    private String phone;
    public String country = "86";//这是中国区号，如果需要其他国家列表，可以使用getSupportedCountries();获得国家区号
    private Dialog mDialog;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
//        弹窗
        mMCameraDialog = new Dialog(this, R.style.my_dialog);
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.win_protocol_layout, null);
        root.findViewById(R.id.btn_disagree).setOnClickListener(btnlistener);
        root.findViewById(R.id.btn_consent).setOnClickListener(btnlistener);
        mMCameraDialog.setContentView(root);
        Window dialogWindow = mMCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.dialogstyle); // 添加动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = -20; // 新位置Y坐标
        lp.width = (int) getResources().getDisplayMetrics().widthPixels; // 宽度
        //      lp.height = WindowManager.LayoutParams.WRAP_CONTENT; // 高度
        //      lp.alpha = 9f; // 透明度
        root.measure(0, 0);
        lp.height = root.getMeasuredHeight();
        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mMCameraDialog.show();

        //EditText自动获取焦点并弹出键盘，代码：三行
        mEtPhoneRegister.setFocusable(true);
        mEtPhoneRegister.setFocusableInTouchMode(true);
        mEtPhoneRegister.requestFocus();

        mImgVerificationCode.setImageBitmap(Code.getInstance().createBitmap());
        mRealCode = Code.getInstance().getCode();
        mEtPhoneRegister.addTextChangedListener(this);
        mEtVerifyRegister.addTextChangedListener(this);
      /*  WorksSizeCheckUtil.textChangeListener textChangeListener = new WorksSizeCheckUtil.textChangeListener(mBtnRegister);
        textChangeListener.addAllEditText(mEtPhoneRegister, mEtVerifyRegister);
        WorksSizeCheckUtil.setChangeListener(new IEditTextChangeListener() {
            @Override
            public void textChange(boolean isHashContent) {
                if (isHashContent) {
                    mBtnRegister.setEnabled(true);
                    mBtnRegister.setBackgroundColor(Color.RED);
                    mBtnRegister.setTextColor(Color.WHITE);
                } else {
                    mBtnRegister.setEnabled(false);
                }
            }
        });*/
        //初始化对话框
//        mBuilder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
        mDialog = new Dialog(this, R.style.common_dialog);


        mTitleBarRegister.setOnImgClickListener(new CustomLoginTitleBar.OnImgClickListener() {
            @Override
            public void onImgClickListener(View view) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.register_layout;
    }

    @OnClick({R.id.img_verification_code, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_verification_code:
                mImgVerificationCode.setImageBitmap(Code.getInstance().createBitmap());
                mRealCode = Code.getInstance().getCode();
                break;
            case R.id.btn_register:
                if (mRealCode.equalsIgnoreCase(mEtVerifyRegister
                        .getText()
                        .toString())) {
                    //弹出对话框
                    //实例化
                    //发送验证码
                    phone = mEtPhoneRegister.getText().toString().trim().replaceAll("/s", "");


                    /*final AlertDialog alertDialog = mBuilder.create();
                    View inflate = View.inflate(this, R.layout.alert_layout, null);*/
                    LinearLayout alert_layout = (LinearLayout) LayoutInflater.from(this).inflate(
                            R.layout.alert_layout, null);
                    mDialog.show();
                    /*//加载布局
                    alertDialog.setView(inflate);
                    alertDialog.show();*/
                    Button noSend = (Button) alert_layout.findViewById(R.id.btn_no_send);
                    Button yesSend = (Button) alert_layout.findViewById(R.id.btn_yes_send);
                    TextView tvPhoneNum = (TextView) alert_layout.findViewById(R.id.tv_phonenum_alert);
                    mDialog.setContentView(alert_layout);

                    tvPhoneNum.setText(phone);
                    yesSend.setOnClickListener(new View.OnClickListener() {

                        private Intent mIntent;

                        @Override
                        public void onClick(View v) {
                            //定义需要匹配的正则表达式的规则
                            String REGEX_MOBILE_SIMPLE = "[1][358]\\d{9}";
                            //把正则表达式的规则编译成模板
                            Pattern pattern = Pattern.compile(REGEX_MOBILE_SIMPLE);
                            //把需要匹配的字符给模板匹配，获得匹配器
                            Matcher matcher = pattern.matcher(phone);
                            // 通过匹配器查找是否有该字符，不可重复调用重复调用matcher.find()
                            if (matcher.find()) {//匹配手机号是否存在
//                                alterWarning();
                                SMSSDK.getVerificationCode(country, phone);
                                mIntent = new Intent(RegisterActivity.this, PhoneCode.class);
                                mIntent.putExtra(Constants.PHONENUM, phone);
                                startActivity(mIntent);
                                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                            } else {
                                ToastUtil.showShortToastCenter("请确认手机号格式");
                            }
                        }
                    });
                    noSend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mDialog.dismiss();
                        }
                    });

                } else {
                    ToastUtil.showShortToastCenter("验证码错误");
                }
                break;
        }
    }

    @Override
    public void showOrHideLoading(boolean flag) {

    }

    @Override
    public void showOrHideHint(boolean flag) {

    }

    @Override
    public void refreshView(SaveBean saveBean) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        mBtnRegister.setEnabled(false);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if ((mEtPhoneRegister.getText().toString() == null || !mEtPhoneRegister.getText().toString().equals("")) && (mEtVerifyRegister.getText().toString() == null || !mEtVerifyRegister.getText().toString().equals(""))) {
            mBtnRegister.setEnabled(true);
        } else {
            mBtnRegister.setEnabled(false);
        }
    }

    //弹窗的点击事件
    private View.OnClickListener btnlistener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_disagree: // 不同意
                    if (mMCameraDialog != null) {
                        mMCameraDialog.dismiss();
                        finish();
                    }
                    break;
                // 同意
                case R.id.btn_consent:
                    if (mMCameraDialog != null) {
                        mMCameraDialog.dismiss();
//                        finish();
                    }
                    break;
            }
        }
    };
}
