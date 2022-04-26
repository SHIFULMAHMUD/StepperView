package com.app.stepperview.model;

import android.view.View;
import android.widget.TextView;

public class Stepper {
    private TextView title;
    private View step;

    public Stepper(TextView title, View step) {
        this.title = title;
        this.step = step;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public View getStep() {
        return step;
    }

    public void setStep(View step) {
        this.step = step;
    }
}
