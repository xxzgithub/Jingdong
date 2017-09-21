package bwie.com.jingdong.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;

import bwie.com.jingdong.R;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/13
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class CustomEditText extends android.support.v7.widget.AppCompatEditText {

    private Drawable mDeleteImage;// 删除的按钮

    public CustomEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomEditText(Context context) {
        this(context, null);

    }

    private void init() {
        addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mDeleteImage = TextUtils.isEmpty(s) ? null : getContext().getResources().getDrawable(R.mipmap.a9y);
                setCompoundDrawablesWithIntrinsicBounds(null, null, mDeleteImage, null);//添加drawable ， position = right
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                if (mDeleteImage != null && !TextUtils.isEmpty(getText())) {//如果删除图片显示，并且输入框有内容
                    if(event.getX() > ( getWidth() - getTotalPaddingRight()) && event.getX() < (getWidth() - getPaddingRight()))
                        //只有在这区域能触发清除内容的效果
                        getText().clear();
                }
                break;

        }


        return super.onTouchEvent(event);
    }

}
