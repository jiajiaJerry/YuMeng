package com.jiajia.coco.yumeng.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiajia.coco.yumeng.R;
import com.jiajia.coco.yumeng.ui.base.BaseActivity;
import com.jiajia.coco.yumeng.ui.fragment.home.HomeFragment;
import com.jiajia.coco.yumeng.ui.fragment.home.MessageFragment;
import com.jiajia.coco.yumeng.ui.fragment.home.MineFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {
    /**
     * fragment 相关
     */
    private FragmentManager fm;
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;
    private Fragment mCurrent;


    @BindView(R.id.home_image_view)
    TextView mHomeView;
    @BindView(R.id.home_layout_view)
    RelativeLayout mHomeLayout;
    @BindView(R.id.fish_image_view)
    TextView mPondView;
    @BindView(R.id.pond_layout_view)
    RelativeLayout mPondLayout;
    @BindView(R.id.message_image_view)
    TextView mMessageView;
    @BindView(R.id.message_layout_view)
    RelativeLayout mMessageLayout;
    @BindView(R.id.mine_image_view)
    TextView mMineView;
    @BindView(R.id.mine_layout_view)
    RelativeLayout mMineLayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_home_layout;
    }

    @Override
    protected void init() {
        //添加默认显示fragment
        mHomeFragment = new HomeFragment();
        fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout,mHomeFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 隐藏具体的Fragment
     *
     * @param fragment
     * @param ft
     */
    private void hideFragment(Fragment fragment, FragmentTransaction ft) {
        if (fragment != null)
            ft.hide(fragment);
    }

    @OnClick({R.id.home_layout_view, R.id.message_layout_view, R.id.mine_layout_view,})
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.home_layout_view:
                mHomeView.setBackgroundResource(R.mipmap.comui_tab_home_selected);
                mPondView.setBackgroundResource(R.mipmap.comui_tab_pond);
                mMessageView.setBackgroundResource(R.mipmap.comui_tab_message);
                mMineView.setBackgroundResource(R.mipmap.comui_tab_person);
                hideFragment(mMessageFragment,fragmentTransaction);
                hideFragment(mMineFragment,fragmentTransaction);
                //显示HomeFragment
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout, mHomeFragment);
                } else {
                    fragmentTransaction.show(mHomeFragment);
                }
                break;

            case R.id.message_layout_view:
                mMessageView.setBackgroundResource(R.mipmap.comui_tab_message_selected);
                mHomeView.setBackgroundResource(R.mipmap.comui_tab_home);
                mPondView.setBackgroundResource(R.mipmap.comui_tab_pond);
                mMineView.setBackgroundResource(R.mipmap.comui_tab_person);
                hideFragment(mHomeFragment,fragmentTransaction);
                hideFragment(mMineFragment,fragmentTransaction);
                //显示MessageFragment
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.content_layout, mMessageFragment);
                } else {
                    fragmentTransaction.show(mMessageFragment);
                }
                break;

            case R.id.mine_layout_view:
                mMineView.setBackgroundResource(R.mipmap.comui_tab_person_selected);
                mHomeView.setBackgroundResource(R.mipmap.comui_tab_home);
                mPondView.setBackgroundResource(R.mipmap.comui_tab_pond);
                mMessageView.setBackgroundResource(R.mipmap.comui_tab_message);
                hideFragment(mMessageFragment,fragmentTransaction);
                hideFragment(mHomeFragment,fragmentTransaction);
                //显示MineFragment
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout, mMineFragment);
                } else {
                    fragmentTransaction.show(mMineFragment);
                }
                break;

        }
        fragmentTransaction.commit();
    }

}
