package com.careerpathfinder;

import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EnterGradesActivity extends AppCompatActivity {

    //Views
    TextView elec1, elec2, elec3, elec4;
    String subject;
    LinearLayout calculatedGrade;
    Button calcGrade, find;
    ImageView background, cancel;
    RelativeLayout mainContent;
    NestedScrollView nestedScrollView;
    TextView recommended;
    RadioGroup r;


    @Override
    public void onStart(){
        super.onStart();
        Toast.makeText(this, "Come back soon", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(this, "Welcome back. Finish up.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_grades);


        if(savedInstanceState != null){
            savedInstanceState.getString("courses", "Science");
        }

        //Getting the information passed from the intent
        Intent intent = getIntent();
        r = findViewById(R.id.rgroup);
        elec1 = findViewById(R.id.elec1);
        elec2 = findViewById(R.id.elec2);
        elec3 = findViewById(R.id.elec3);
        elec4 = findViewById(R.id.elec4);
        calcGrade = findViewById(R.id.calcGrade);
        mainContent = findViewById(R.id.mainContent);
        background =findViewById(R.id.background);
        calculatedGrade =findViewById(R.id.calculatedValue);
        nestedScrollView =findViewById(R.id.nestedScrollView);
        find = findViewById(R.id.find);
        cancel = findViewById(R.id.cancel);
       // recommended = findViewById(R.id.recommended);



        r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //Create a function and add this to e function and call the function for each radio group.


            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(mainContent);
                calculatedGrade.setVisibility(View.GONE);
                background.setVisibility(View.GONE);
                nestedScrollView.setVisibility(View.VISIBLE);

            }
        });

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Test.class));
            }
        });


        calcGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(mainContent);
                nestedScrollView.setVisibility(View.GONE);
                background.setVisibility(View.VISIBLE);
                calculatedGrade.setVisibility(View.VISIBLE);
            }
        });

        subject = intent.getStringExtra("subject");

        try{

            if(subject.equals("arts")){
                elec1.setText("1. Geography");
                elec2.setText("2. Economics");
                elec3.setText("3. Government");
                elec4.setText("4. E - Maths");
                recommended.setText("With the selected course the recommended universities are UCC, Valley View, and LEGON");
            } else if(subject.equals("science")){
                elec1.setText("1. Physics");
                elec2.setText("2. Chemistry");
                elec3.setText("3. Biology");
                elec4.setText("4. E - Maths");
                recommended.setText("With the selected course the recommended universities are KNUST, Ashesi, and UDS");
            }



        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void calculatesmthn(View view) {
//        Map<String, Integer> gradeNumericalValues = new HashMap<>() {
//            {
//                put("A1", 1);
//            }
//        };

        String [] cGrades = new String[]{"A1", "B2", "B3", "B3"};
        String [] eGrades = new String[]{"C4", "A1", "B2", "B2"};
        ArrayList<String> hiGrades = new ArrayList<String>(){};

         //Toast.makeText(view.getContext(), "value=" + numValue, Toast.LENGTH_LONG).show();


        for (int i =0; i < cGrades.length; i++) {
            if (hiGrades.size() < 3) {
                hiGrades.add(cGrades[i]);
            } else {
                for (int j=0; j < hiGrades.size(); j++) {
                    if (Integer.parseInt(cGrades[i].substring(1)) < Integer.parseInt(hiGrades.get(j).substring(1))) {
                        hiGrades.set(j, cGrades[i]);
                    }
                }
            }
        }

        for (int i =0; i < eGrades.length; i++) {
            if (hiGrades.size() < 6) {
                hiGrades.add(eGrades[i]);
            } else {
                for (int j=4; j < hiGrades.size(); j++) {
                    if (Integer.parseInt(eGrades[i].substring(1)) < Integer.parseInt(hiGrades.get(j).substring(1))) {
                        hiGrades.set(j, eGrades[i]);
                    }
                }
            }
        }

        double agg = 0;

        for (int k=0; k< hiGrades.size(); k++) {
            agg = agg + Integer.parseInt(hiGrades.get(k).substring(1));
        }

        System.out.println(agg);
    }

    public void Do(View view) {
        
    }
}

