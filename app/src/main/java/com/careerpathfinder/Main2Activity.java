package com.careerpathfinder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button button;
    RadioButton science, arts, business, vocational,technical;
    String subject;
    TextView selectedCourse;
    LinearLayout artsElectives, scienceElectives;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        arts = findViewById(R.id.arts);
        science = findViewById(R.id.science);
        business = findViewById(R.id.business);
        vocational = findViewById(R.id.vocational);
        technical = findViewById(R.id.technical);
        selectedCourse = findViewById(R.id.textCourseSelect);
        artsElectives = findViewById(R.id.artsElectives);
        scienceElectives = findViewById(R.id.scienceElectives);
        button = findViewById(R.id.addGrades);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), EnterGradesActivity.class);
                if(science.isChecked()){
                    subject = "science";
                } else if(arts.isChecked()){
                    subject = "arts";
                }

                intent.putExtra("subject", subject);
                startActivity(intent);



                Toast.makeText(Main2Activity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        science.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    selectedCourse.setText("The selected course is Science");
                    scienceElectives.setVisibility(View.VISIBLE);
                    artsElectives.setVisibility(View.GONE);
                } else{

                }
            }
        });

        arts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    selectedCourse.setText("The selected course is Arts");
                    scienceElectives.setVisibility(View.GONE);
                    artsElectives.setVisibility(View.VISIBLE);
                }
            }
        });

        business.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    selectedCourse.setText("The selected course is Business");
                }
            }
        });

        vocational.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    selectedCourse.setText("The selected course is Vocational");
                }
            }
        });

        technical.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    selectedCourse.setText("The selected course is Technical");
                }
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        //Check the Science radiobutton on default
        science.setChecked(true);
    }
}

