package bwie.com.jingdong.register.view;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import bwie.com.jingdong.R;
import bwie.com.jingdong.base.BaseActivity;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/11
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class SetPwd extends BaseActivity {
    @BindView(R.id.et_pwd_set)
    EditText mEtPwdSet;
    @BindView(R.id.check_show_set)
    CheckBox mCheckShowSet;
    @BindView(R.id.btn_done_set)
    Button mBtnDoneSet;

    private boolean flag;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        if (mEtPwdSet != null) {
            String pwdText = mEtPwdSet.getText().toString();
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.setpwd;
    }

    @OnClick({R.id.check_show_set, R.id.btn_done_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.check_show_set:
                if (flag) {
                    //显示密码
                    mEtPwdSet.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //不显示密码
                    mEtPwdSet.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.btn_done_set:
                break;
        }
    }
}
