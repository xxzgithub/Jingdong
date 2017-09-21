package bwie.com.jingdong.login.view;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import bwie.com.jingdong.Constants;
import bwie.com.jingdong.R;
import bwie.com.jingdong.base.BaseActivity;
import bwie.com.jingdong.login.presenter.LoginPresenterImp;
import bwie.com.jingdong.register.view.RegisterActivity;
import bwie.com.jingdong.utils.ToastUtil;
import bwie.com.jingdong.widget.CustomEditText;
import bwie.com.jingdong.widget.CustomLoginTitleBar;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/7
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class LoginActivity extends BaseActivity implements IloginView<String>, View.OnTouchListener, TextWatcher {

    @BindView(R.id.user_name_log_activity)
    CustomEditText mUserNameLogActivity;
    @BindView(R.id.user_pwd_log_activity)
    CustomEditText mUserPwdLogActivity;
    @BindView(R.id.show_hide_paw_log_activity)
    CheckBox mShowHidePawLogActivity;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.phone_quick_register)
    TextView mPhoneQuickRegister;
    @BindView(R.id.login_loading)
    ImageView mLoginLoading;
    @BindView(R.id.forget_pwd)
    TextView mForgetPwd;
    @BindView(R.id.qq_login)
    ImageView mQqLogin;
    @BindView(R.id.weixin_login)
    ImageView mWeixinLogin;
    @BindView(R.id.tv_policy_login)
    TextView mTvPolicyLogin;
    @BindView(R.id.linear_policy)
    LinearLayout mLinearPolicy;
    @BindView(R.id.title_bar)
    CustomLoginTitleBar mTitleBar;

    @Override
    protected void initData() {
        LoginPresenterImp loginPresenterImp = new LoginPresenterImp(this);
    }

    @Override
    protected void initView() {
        String phoneNumber = null;
        Intent intent = getIntent();
        if (intent != null) {
            phoneNumber = intent.getStringExtra(Constants.PHONENUM);
        }
        mUserNameLogActivity.setText(phoneNumber);
        mBtnLogin.setEnabled(false);
        //去掉edit光标
        mUserNameLogActivity.setCursorVisible(false);
        //
        mUserPwdLogActivity.setCursorVisible(false);

        mUserNameLogActivity.setOnTouchListener(this);
        mUserPwdLogActivity.setOnTouchListener(this);

        mUserNameLogActivity.addTextChangedListener(this);
        mUserPwdLogActivity.addTextChangedListener(this);

        //初始化关闭按钮
        mTitleBar.setOnImgClickListener(new CustomLoginTitleBar.OnImgClickListener() {
            @Override
            public void onImgClickListener(View view) {
                finish();
//              overridePendingTransition(R.anim.out_to_left, R.anim.out_to_left);
            }
        });

    /*    // //1.创建工具类对象 把要改变颜色的tv先传过去
        WorksSizeCheckUtil.textChangeListener textChangeListener = new WorksSizeCheckUtil.textChangeListener(mBtnLogin);
        //2.把所有要监听的edittext都添加进去
        textChangeListener.addAllEditText(mUserNameLogActivity, mUserPwdLogActivity);
        //3.接口回调 在这里拿到boolean变量 根据isHasContent的值决定 tv 应该设置什么颜色
        WorksSizeCheckUtil.setChangeListener(new IEditTextChangeListener() {
            @Override
            public void textChange(boolean isHashContent) {
                if (isHashContent) {
                    mBtnLogin.setEnabled(true);
                    mBtnLogin.setBackgroundColor(Color.RED);
                    mBtnLogin.setTextColor(Color.WHITE);
                } else {
                    mBtnLogin.setEnabled(false);
                }
            }
        });
        //隐藏和显示
        mShowHidePawLogActivity.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mUserPwdLogActivity.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    mUserPwdLogActivity.setText(mUserPwdLogActivity.getText());//设置EditText控件的内容
                    mUserPwdLogActivity.setSelection(mUserPwdLogActivity.getText().length());//将光标移至文字末尾*//*
                } else {
                    mUserPwdLogActivity.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    mUserPwdLogActivity.setText(mUserPwdLogActivity.getText());//设置EditText控件的内容
                    mUserPwdLogActivity.setSelection(mUserPwdLogActivity.getText().length());//将光标移至文字末尾
                }
            }
        });*/


    }

    @Override
    protected int getLayoutId() {
        return R.layout.login_activity;
    }

    @Override
    public void showOrHideLoading(boolean flag) {
        if (flag) {
            mLoginLoading.setVisibility(View.VISIBLE);
        } else {
            mLoginLoading.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showOrHideError(boolean flag) {
        if (!flag) {
            ToastUtil.showLongToastCenter("密码错误");
        }
    }

    @Override
    public void refreshView(String s) {

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.user_name_log_activity:
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    mUserNameLogActivity.setCursorVisible(true);// 再次点击显示光标
                }
                break;
            case R.id.user_pwd_log_activity:
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    mUserPwdLogActivity.setCursorVisible(true);// 再次点击显示光标
                }

                break;
        }
        return false;
    }

    @OnClick({R.id.btn_login, R.id.phone_quick_register, R.id.forget_pwd, R.id.qq_login, R.id.weixin_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                finish();
                break;
            case R.id.phone_quick_register:
                startActivity(new Intent(this, RegisterActivity.class));
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case R.id.forget_pwd:
                break;
            case R.id.qq_login:

                break;
            case R.id.weixin_login:
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        mBtnLogin.setEnabled(false);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if ((mUserNameLogActivity.getText().toString() == null || !mUserNameLogActivity.getText().toString().equals("")) && (mUserPwdLogActivity.getText().toString() == null || !mUserPwdLogActivity.getText().toString().equals(""))) {
            mBtnLogin.setEnabled(true);
        } else {
            mBtnLogin.setEnabled(false);
        }
    }


}
