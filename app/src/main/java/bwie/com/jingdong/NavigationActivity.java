package bwie.com.jingdong;

import android.app.Service;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import bwie.com.jingdong.widget.WidgetNavigationVideo;

import static java.lang.Thread.sleep;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/6
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class NavigationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mNavigation_img;
    private RelativeLayout mNavigationProtocolRelative;
    private Button mNavigationDiasgree;
    private Button mNavigationContent;
    private RelativeLayout mNavigationViewRelative;
    private TextView mNavigationJump;
    private TextView mNavigationJumpTime;
    private WidgetNavigationVideo videoview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_layout);
        initView();
    }

    private void initView() {
        mNavigation_img = (ImageView) findViewById(R.id.navigation_img);
        mNavigationProtocolRelative = (RelativeLayout) findViewById(R.id.navigation_protocol_relative);
        mNavigationDiasgree = (Button) findViewById(R.id.navigation_disagree);
        mNavigationContent = (Button) findViewById(R.id.navigation_content);
        mNavigationViewRelative = (RelativeLayout) findViewById(R.id.navigation_video);
        mNavigationJump = (TextView) findViewById(R.id.navigation_jump);
        mNavigationJumpTime = (TextView) findViewById(R.id.navigation_jump_time);
        videoview = (WidgetNavigationVideo) findViewById(R.id.navigation_video_view);
        mNavigation_img.setOnClickListener(this);
        mNavigationDiasgree.setOnClickListener(this);
        mNavigationContent.setOnClickListener(this);

        //设置播放加载路径
       // videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.minion_09));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navigation_img:
                mNavigation_img.setVisibility(View.GONE);
                mNavigationProtocolRelative.setVisibility(View.VISIBLE);
                break;
            case R.id.navigation_disagree:
                Toast.makeText(this, "不同意不让用,呵呵", Toast.LENGTH_SHORT).show();
                try {
                    sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(0);
                break;
            case R.id.navigation_content:
                mNavigationProtocolRelative.setVisibility(View.GONE);
                mNavigationViewRelative.setVisibility(View.VISIBLE);
               /* //播放
                videoview.start();
                setVoiceVolume(0, this);
                //循环播放
                videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        videoview.start();
                    }
                });*/
                break;
            case R.id.navigation_vocality:
                //setVoiceVolume(1, this);
                break;
            case R.id.navigation_jump_time:
                //计时器
                break;
            case R.id.navigation_jump:
                //跳转
                break;
        }
    }

    /**
     * 使用AudioManager控制音量
     *
     * @param value
     * @param context //    https://github.com/lucid-lynxz/BlogSamples/blob/master/VideoViewDemo/app/src/main/java/org/lynxz/videoviewdemo/MainActivity.java
     */
    private void setVoiceVolume(float value, Context context) {
        try {
            AudioManager audioManager =
                    (AudioManager) context.getSystemService(Service.AUDIO_SERVICE);
            int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);//(最大值是15)
            int flag = value > 0 ? -1 : 1;
            currentVolume += flag * 0.1 * maxVolume;
            // 对currentVolume进行限制
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
