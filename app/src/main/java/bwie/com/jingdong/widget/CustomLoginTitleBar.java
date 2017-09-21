package bwie.com.jingdong.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import bwie.com.jingdong.R;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/14
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class CustomLoginTitleBar extends LinearLayout {

    private ImageView mCustomTitleImg;
    private TextView mCustomTitleContext;
    private String mTitleContext;
    private float mTitleSize;
    private int mTitleColor;
    private int mResourceId;

    public CustomLoginTitleBar(Context context) {
        super(context);
    }

    public CustomLoginTitleBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        //找到自定义布局中的控件
        final View view = inflate(context, R.layout.custom_title_layout, this);
        mCustomTitleImg = (ImageView) view.findViewById(R.id.custom_left_img);
        mCustomTitleContext = (TextView) view.findViewById(R.id.custom_title_context);
        if (attrs == null) {
            return;
        }
        //找到自定义的属性
        initAttrs(context, attrs);
        //绑定控件
        initBindWidget();
        mCustomTitleImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnClickListener != null) {
                    mOnClickListener.onImgClickListener(v);
                }
            }
        });
    }

    private void initBindWidget() {
        mCustomTitleImg.setImageResource(mResourceId);
        mCustomTitleContext.setText(mTitleContext);
        mCustomTitleContext.setTextSize(mTitleSize);
        mCustomTitleContext.setTextColor(mTitleColor);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomLoginTitleBar);
        mTitleContext = typedArray.getString(R.styleable.CustomLoginTitleBar_titleContext);
        mTitleSize = typedArray.getDimension(R.styleable.CustomLoginTitleBar_titleSize, 18);
        mTitleColor = typedArray.getColor(R.styleable.CustomLoginTitleBar_titleColor, Color.RED);
        mResourceId = typedArray.getResourceId(R.styleable.CustomLoginTitleBar_titleImgLeft, R.mipmap.ic_launcher_round);
    }

    private OnImgClickListener mOnClickListener;

    public interface OnImgClickListener {
        void onImgClickListener(View view);
    }

    public void setOnImgClickListener(OnImgClickListener onImgClickListener) {
        this.mOnClickListener = onImgClickListener;
    }
}
