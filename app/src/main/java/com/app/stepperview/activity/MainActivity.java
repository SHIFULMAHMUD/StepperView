package com.app.stepperview.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.stepperview.R;
import com.app.stepperview.model.Stepper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    View step0, step1, step2;
    View view0, view1, view2;
    TextView stepperText0, stepperText1, stepperText2;
    int totalSteps = 3;
    List<Stepper> steps = new ArrayList<>(totalSteps);
    List<View> views = new ArrayList<>(totalSteps);

    Button stepButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initStep();
        initView();
        stepButton1 = findViewById(R.id.stepButton1);
        stepButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeStepView(1);
            }
        });

        for (int i = 0; i < totalSteps; i++) {
            int finalI = i;
            steps.get(i).getStep().setOnClickListener(v -> {
                changeStepView(finalI);
            });
        }
    }

    private void initView() {
        view0 = findViewById(R.id.view0);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        views.add(view0);
        views.add(view1);
        views.add(view2);
        views.get(0).setVisibility(View.VISIBLE);
        changeStepView(0);
    }

    private void initStep() {
        step0 = findViewById(R.id.step0);
        step1 = findViewById(R.id.step1);
        step2 = findViewById(R.id.step2);
        stepperText0 = findViewById(R.id.stepperText0);
        stepperText1 = findViewById(R.id.stepperText1);
        stepperText2 = findViewById(R.id.stepperText2);
        steps.add(new Stepper(stepperText0, step0));
        steps.add(new Stepper(stepperText1, step1));
        steps.add(new Stepper(stepperText2, step2));
    }

    private void changeStepView(int index) {
        for (int i = 0; i < totalSteps; i++) {
            if (i == index) {
                views.get(i).setVisibility(View.VISIBLE);
                changeStep(i);
            } else {
                views.get(i).setVisibility(View.GONE);
            }
        }
    }

    private void changeStep(int index){
        for(int i = 0; i < totalSteps; i++){
            if(i == index){
                steps.get(i).getStep().setBackgroundColor(getResources().getColor(R.color.purple_700));
                steps.get(i).getTitle().setTextColor(getResources().getColor(R.color.white));
            }else{
                steps.get(i).getStep().setBackgroundColor(getResources().getColor(R.color.grey_light));
                steps.get(i).getTitle().setTextColor(getResources().getColor(R.color.black));
            }
        }
    }
}