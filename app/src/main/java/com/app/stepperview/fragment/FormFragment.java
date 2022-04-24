package com.app.stepperview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.app.stepperview.R;
import com.app.stepperview.stepperFragment;

public class FormFragment extends stepperFragment {

    public FormFragment(){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.formfragment, container, false);
    }


    @Override
    public boolean onNextButtonHandler() {
        return true;
    }
}
