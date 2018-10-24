package com.fynnjason.app.viewpagerguidance;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by FynnJason.
 * Function：
 */
public class FragmentGuidance extends Fragment {

    @BindView(R.id.iv_guidance)
    ImageView ivGuidance;
    Unbinder unbinder;
    private int mPosition;
    private View mView;
    private boolean mViewRepeat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == mView) {
            mView = inflater.inflate(R.layout.fragment_guidance, container, false);
            mPosition = getArguments().getInt("position");
        }
        unbinder = ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!mViewRepeat) {
            mViewRepeat = true;
            int[] mBg = new int[]{R.drawable.ic_guidance_one, R.drawable.ic_guidance_two, R.drawable.ic_guidance_three};
            Glide.with(getContext()).load(mBg[mPosition]).into(ivGuidance);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
