package com.fynnjason.app.viewpagerguidance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.iv_1)
    ImageView iv1;
    @BindView(R.id.iv_2)
    ImageView iv2;
    @BindView(R.id.iv_3)
    ImageView iv3;

    private List<ImageView> mIvList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ImmersionBar.with(this).init();

        mIvList.add(iv1);
        mIvList.add(iv2);
        mIvList.add(iv3);

        for (int i = 0; i < mIvList.size(); i++) {
            FragmentGuidance fragment = new FragmentGuidance();
            Bundle bundle = new Bundle();
            bundle.putInt("position", i);
            fragment.setArguments(bundle);
            mFragmentList.add(fragment);
        }
        VPQAdapter adapter = new VPQAdapter(getSupportFragmentManager(), mFragmentList);
        viewPager.setAdapter(adapter);

        mIvList.get(0).setSelected(true);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                for (ImageView view : mIvList) {
                    view.setSelected(false);
                }
                mIvList.get(position).setSelected(true);
            }
        });
    }

    @OnClick(R.id.tv_skip)
    public void onViewClicked() {
        Toast.makeText(this, "跳过", Toast.LENGTH_SHORT).show();
    }
}
