package com.gacrnd.gcs.bottomnavigation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ThirdFragment extends Fragment {

    private ThirdViewModel mViewModel;
    private ImageView imageView;

    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_fragment, container, false);
        imageView = view.findViewById(R.id.imageView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ThirdViewModel.class);
        imageView.setScaleX(mViewModel.scaleFactor);
        imageView.setScaleY(mViewModel.scaleFactor);
        final ObjectAnimator animatorX = ObjectAnimator.ofFloat(imageView,"scaleX",0,0);
        final ObjectAnimator animatorY = ObjectAnimator.ofFloat(imageView,"scaleY",0,0);
        animatorX.setDuration(500);
        animatorY.setDuration(500);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!animatorX.isRunning()){
                    animatorX.setFloatValues(imageView.getScaleX() + 0.1f);
                    animatorY.setFloatValues(imageView.getScaleY() + 0.1f);
                    mViewModel.scaleFactor += 0.1;
                    animatorX.start();
                    animatorY.start();
                }
            }
        });
    }

}
