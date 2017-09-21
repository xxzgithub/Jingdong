package bwie.com.jingdong;

import android.support.v4.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import bwie.com.jingdong.base.BaseActivity;
import bwie.com.jingdong.classify.ClassifyFragment;
import bwie.com.jingdong.discovery.DiscoveryFragment;
import bwie.com.jingdong.home.HomeFragment;
import bwie.com.jingdong.my.MyFragment;
import bwie.com.jingdong.shoppingcar.ShoppingCarFragment;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private HomeFragment mHomeFragment;
    private ClassifyFragment mClassifyFragment;
    private ShoppingCarFragment mShoppingFragment;
    private MyFragment mMyFragment;
    private FragmentTransaction mTransaction;
    private DiscoveryFragment mDiscoveryFragment;


    @Override
    protected void initData() {

    }

    protected void initView() {
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.home, "首页"))
                .addItem(new BottomNavigationItem(R.mipmap.classify, "分类"))
                .addItem(new BottomNavigationItem(R.mipmap.discovery, "发现"))
                .addItem(new BottomNavigationItem(R.mipmap.shoppingcar, "购物车"))
                .addItem(new BottomNavigationItem(R.mipmap.my, "我的"))
                .setFirstSelectedPosition(0)
                .initialise();//所有的设置需在调用该方法前完成
        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void setDefaultFragment() {
        mTransaction = getSupportFragmentManager().beginTransaction();
        mHomeFragment = HomeFragment.newInstance("home_fragment");
        mTransaction.replace(R.id.fragment_container, mHomeFragment).commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance("home_fragment");
                }
                transaction.replace(R.id.fragment_container, mHomeFragment);
                break;
            case 1:
                if (mClassifyFragment == null) {
                    mClassifyFragment = mClassifyFragment.newInstance("classify_fragment");
                }
                transaction.replace(R.id.fragment_container, mClassifyFragment);
                break;
            case 2:
                if (mDiscoveryFragment == null) {
                    mDiscoveryFragment = mDiscoveryFragment.newInstance("discover_fragment");
                }
                transaction.replace(R.id.fragment_container, mDiscoveryFragment);
            case 3:
                if (mShoppingFragment == null) {
                    mShoppingFragment = ShoppingCarFragment.newInstance("shopping_fragment");
                }
                transaction.replace(R.id.fragment_container, mShoppingFragment);
                break;
            case 4:
                if (mMyFragment == null) {
                    mMyFragment = mMyFragment.newInstance("my_fragment");
                }
                transaction.replace(R.id.fragment_container, mMyFragment);
                break;
            default:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance("home_fragment");
                }
                transaction.replace(R.id.fragment_container, mHomeFragment);
                break;
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
