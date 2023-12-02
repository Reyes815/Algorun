package com.example.algorun;

import static com.example.algorun.ThemeManager.setCustomizedThemes;
import static com.example.algorun.ThemeStorage.getThemeColor;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class quiz extends AppCompatActivity {
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomizedThemes(this,getThemeColor(this));
        setContentView(R.layout.activity_quiz);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference easyQuizDoc = db.collection("quiz").document("easyquiz");
        DocumentReference mediumQuizDoc = db.collection("quiz").document("mediumquiz");
        DocumentReference hardQuizDoc = db.collection("quiz").document("hardquiz");

        Spinner dropmenu = (Spinner) findViewById(R.id.quizSpinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(quiz.this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.Difficulty));
        dropmenu.setAdapter(myAdapter);

        Button start = (Button) findViewById(R.id.btnStart);
        //--Question1
        TextView q1 = (TextView) findViewById(R.id.txtQ1);
        RadioButton rdbtn_q1c1 = (RadioButton) findViewById(R.id.RQ1C1);
        RadioButton rdbtn_q1c2 = (RadioButton) findViewById(R.id.RQ1C2);
        RadioButton rdbtn_q1c3 = (RadioButton) findViewById(R.id.RQ1C3);
        //--Question2
        TextView q2 = (TextView) findViewById(R.id.txtQ2);
        RadioButton rdbtn_q2c1 = (RadioButton) findViewById(R.id.RQ2C1);
        RadioButton rdbtn_q2c2 = (RadioButton) findViewById(R.id.RQ2C2);
        RadioButton rdbtn_q2c3 = (RadioButton) findViewById(R.id.RQ2C3);
        //--Question3
        TextView q3 = (TextView) findViewById(R.id.txtQ3);
        RadioButton rdbtn_q3c1 = (RadioButton) findViewById(R.id.RQ3C1);
        RadioButton rdbtn_q3c2 = (RadioButton) findViewById(R.id.RQ3C2);
        RadioButton rdbtn_q3c3 = (RadioButton) findViewById(R.id.RQ3C3);
        //--Question4
        TextView q4 = (TextView) findViewById(R.id.txtQ4);
        RadioButton rdbtn_q4c1 = (RadioButton) findViewById(R.id.RQ4C1);
        RadioButton rdbtn_q4c2 = (RadioButton) findViewById(R.id.RQ4C2);
        RadioButton rdbtn_q4c3 = (RadioButton) findViewById(R.id.RQ4C3);
        //--Question5
        TextView q5 = (TextView) findViewById(R.id.txtQ5);
        RadioButton rdbtn_q5c1 = (RadioButton) findViewById(R.id.RQ5C1);
        RadioButton rdbtn_q5c2 = (RadioButton) findViewById(R.id.RQ5C2);
        RadioButton rdbtn_q5c3 = (RadioButton) findViewById(R.id.RQ5C3);
        //--Submit Button
        Button submit = (Button) findViewById(R.id.btnSubmitAnswers);
        //--RadioGroups
        RadioGroup rgQ1 = (RadioGroup) findViewById(R.id.radioGroupQ1);
        RadioGroup rgQ2 = (RadioGroup) findViewById(R.id.radioGroupQ2);
        RadioGroup rgQ3 = (RadioGroup) findViewById(R.id.radioGroupQ3);
        RadioGroup rgQ4 = (RadioGroup) findViewById(R.id.radioGroupQ4);
        RadioGroup rgQ5 = (RadioGroup) findViewById(R.id.radioGroupQ5);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String diff = dropmenu.getSelectedItem().toString();

                if(diff.equalsIgnoreCase("Easy")){
                    easyQuizDoc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                    if (task.isSuccessful()) {
                                        DocumentSnapshot doc = task.getResult();
                                            //--Question 1 for easy quiz--//
                                            String Question1 = doc.getString("Question1");
                                            String Q1Choice1 = doc.getString("q1c1");
                                            String Q1Choice2 = doc.getString("q1c2");
                                            String Q1Choice3 = doc.getString("q1c3");
                                            q1.setText(Question1);
                                            rdbtn_q1c1.setText(Q1Choice1);
                                            rdbtn_q1c2.setText(Q1Choice2);
                                            rdbtn_q1c3.setText(Q1Choice3);

                                            //--Question 2 for easy quiz--//
                                            String Question2 = doc.getString("Question2");
                                            String Q2Choice1 = doc.getString("q2c1");
                                            String Q2Choice2 = doc.getString("q2c2");
                                            String Q2Choice3 = doc.getString("q2c3");
                                            q2.setText(Question2);
                                            rdbtn_q2c1.setText(Q2Choice1);
                                            rdbtn_q2c2.setText(Q2Choice2);
                                            rdbtn_q2c3.setText(Q2Choice3);

                                            //--Question 3 for easy quiz--//
                                            String Question3 = doc.getString("Question3");
                                            String Q3Choice1 = doc.getString("q3c1");
                                            String Q3Choice2 = doc.getString("q3c2");
                                            String Q3Choice3 = doc.getString("q3c3");
                                            q3.setText(Question3);
                                            rdbtn_q3c1.setText(Q3Choice1);
                                            rdbtn_q3c2.setText(Q3Choice2);
                                            rdbtn_q3c3.setText(Q3Choice3);

                                            //--Question 4 for easy quiz--//
                                            String Question4 = doc.getString("Question4");
                                            String Q4Choice1 = doc.getString("q4c1");
                                            String Q4Choice2 = doc.getString("q4c2");
                                            String Q4Choice3 = doc.getString("q4c3");
                                            q4.setText(Question4);
                                            rdbtn_q4c1.setText(Q4Choice1);
                                            rdbtn_q4c2.setText(Q4Choice2);
                                            rdbtn_q4c3.setText(Q4Choice3);

                                            //--Question 5 for easy quiz--//
                                            String Question5 = doc.getString("Question5");
                                            String Q5Choice1 = doc.getString("q5c1");
                                            String Q5Choice2 = doc.getString("q5c2");
                                            String Q5Choice3 = doc.getString("q5c3");
                                            q5.setText(Question5);
                                            rdbtn_q5c1.setText(Q5Choice1);
                                            rdbtn_q5c2.setText(Q5Choice2);
                                            rdbtn_q5c3.setText(Q5Choice3);
                                        q1.setVisibility(view.VISIBLE);
                                        q2.setVisibility(view.VISIBLE);
                                        q3.setVisibility(view.VISIBLE);
                                        q4.setVisibility(view.VISIBLE);
                                        q5.setVisibility(view.VISIBLE);
                                        rgQ1.setVisibility(view.VISIBLE);
                                        rgQ2.setVisibility(view.VISIBLE);
                                        rgQ3.setVisibility(view.VISIBLE);
                                        rgQ4.setVisibility(view.VISIBLE);
                                        rgQ5.setVisibility(view.VISIBLE);
                                        submit.setVisibility(view.VISIBLE);
                                        submit.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                if(rdbtn_q1c3.isChecked())count++;
                                                if(rdbtn_q2c1.isChecked())count++;
                                                if(rdbtn_q3c2.isChecked())count++;
                                                if(rdbtn_q4c2.isChecked())count++;
                                                if(rdbtn_q5c3.isChecked())count++;
                                                String result = (count*2)+"/10";
                                                Toast.makeText(quiz.this, result, Toast.LENGTH_LONG).show();
                                                count = 0;
                                                rgQ1.clearCheck();
                                                rgQ2.clearCheck();
                                                rgQ3.clearCheck();
                                                rgQ4.clearCheck();
                                                rgQ5.clearCheck();
                                            }
                                        });
                                    }
                                }
                            });
                }
                //--start here
                if(diff.equalsIgnoreCase("Medium")){
                    mediumQuizDoc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot doc = task.getResult();
                                //--Question 1 for easy quiz--//
                                String Question1 = doc.getString("Question1");
                                String Q1Choice1 = doc.getString("q1c1");
                                String Q1Choice2 = doc.getString("q1c2");
                                String Q1Choice3 = doc.getString("q1c3");
                                q1.setText(Question1);
                                rdbtn_q1c1.setText(Q1Choice1);
                                rdbtn_q1c2.setText(Q1Choice2);
                                rdbtn_q1c3.setText(Q1Choice3);

                                //--Question 2 for easy quiz--//
                                String Question2 = doc.getString("Question2");
                                String Q2Choice1 = doc.getString("q2c1");
                                String Q2Choice2 = doc.getString("q2c2");
                                String Q2Choice3 = doc.getString("q2c3");
                                q2.setText(Question2);
                                rdbtn_q2c1.setText(Q2Choice1);
                                rdbtn_q2c2.setText(Q2Choice2);
                                rdbtn_q2c3.setText(Q2Choice3);

                                //--Question 3 for easy quiz--//
                                String Question3 = doc.getString("Question3");
                                String Q3Choice1 = doc.getString("q3c1");
                                String Q3Choice2 = doc.getString("q3c2");
                                String Q3Choice3 = doc.getString("q3c3");
                                q3.setText(Question3);
                                rdbtn_q3c1.setText(Q3Choice1);
                                rdbtn_q3c2.setText(Q3Choice2);
                                rdbtn_q3c3.setText(Q3Choice3);

                                //--Question 4 for easy quiz--//
                                String Question4 = doc.getString("Question4");
                                String Q4Choice1 = doc.getString("q4c1");
                                String Q4Choice2 = doc.getString("q4c2");
                                String Q4Choice3 = doc.getString("q4c3");
                                q4.setText(Question4);
                                rdbtn_q4c1.setText(Q4Choice1);
                                rdbtn_q4c2.setText(Q4Choice2);
                                rdbtn_q4c3.setText(Q4Choice3);

                                //--Question 5 for easy quiz--//
                                String Question5 = doc.getString("Question5");
                                String Q5Choice1 = doc.getString("q5c1");
                                String Q5Choice2 = doc.getString("q5c2");
                                String Q5Choice3 = doc.getString("q5c3");
                                q5.setText(Question5);
                                rdbtn_q5c1.setText(Q5Choice1);
                                rdbtn_q5c2.setText(Q5Choice2);
                                rdbtn_q5c3.setText(Q5Choice3);
                                q1.setVisibility(view.VISIBLE);
                                q2.setVisibility(view.VISIBLE);
                                q3.setVisibility(view.VISIBLE);
                                q4.setVisibility(view.VISIBLE);
                                q5.setVisibility(view.VISIBLE);
                                rgQ1.setVisibility(view.VISIBLE);
                                rgQ2.setVisibility(view.VISIBLE);
                                rgQ3.setVisibility(view.VISIBLE);
                                rgQ4.setVisibility(view.VISIBLE);
                                rgQ5.setVisibility(view.VISIBLE);
                                submit.setVisibility(view.VISIBLE);
                                submit.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if(rdbtn_q1c2.isChecked())count++;
                                        if(rdbtn_q2c3.isChecked())count++;
                                        if(rdbtn_q3c3.isChecked())count++;
                                        if(rdbtn_q4c3.isChecked())count++;
                                        if(rdbtn_q5c1.isChecked())count++;
                                        String result = (count*2)+"/10";
                                        Toast.makeText(quiz.this, result, Toast.LENGTH_LONG).show();
                                        count = 0;
                                        rgQ1.clearCheck();
                                        rgQ2.clearCheck();
                                        rgQ3.clearCheck();
                                        rgQ4.clearCheck();
                                        rgQ5.clearCheck();
                                    }
                                });
                            }
                        }
                    });
                }
                //Start here
                if(diff.equalsIgnoreCase("Hard")){
                    hardQuizDoc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot doc = task.getResult();
                                //--Question 1 for easy quiz--//
                                String Question1 = doc.getString("Question1");
                                String Q1Choice1 = doc.getString("q1c1");
                                String Q1Choice2 = doc.getString("q1c2");
                                String Q1Choice3 = doc.getString("q1c3");
                                q1.setText(Question1);
                                rdbtn_q1c1.setText(Q1Choice1);
                                rdbtn_q1c2.setText(Q1Choice2);
                                rdbtn_q1c3.setText(Q1Choice3);

                                //--Question 2 for easy quiz--//
                                String Question2 = doc.getString("Question2");
                                String Q2Choice1 = doc.getString("q2c1");
                                String Q2Choice2 = doc.getString("q2c2");
                                String Q2Choice3 = doc.getString("q2c3");
                                q2.setText(Question2);
                                rdbtn_q2c1.setText(Q2Choice1);
                                rdbtn_q2c2.setText(Q2Choice2);
                                rdbtn_q2c3.setText(Q2Choice3);

                                //--Question 3 for easy quiz--//
                                String Question3 = doc.getString("Question3");
                                String Q3Choice1 = doc.getString("q3c1");
                                String Q3Choice2 = doc.getString("q3c2");
                                String Q3Choice3 = doc.getString("q3c3");
                                q3.setText(Question3);
                                rdbtn_q3c1.setText(Q3Choice1);
                                rdbtn_q3c2.setText(Q3Choice2);
                                rdbtn_q3c3.setText(Q3Choice3);

                                //--Question 4 for easy quiz--//
                                String Question4 = doc.getString("Question4");
                                String Q4Choice1 = doc.getString("q4c1");
                                String Q4Choice2 = doc.getString("q4c2");
                                String Q4Choice3 = doc.getString("q4c3");
                                q4.setText(Question4);
                                rdbtn_q4c1.setText(Q4Choice1);
                                rdbtn_q4c2.setText(Q4Choice2);
                                rdbtn_q4c3.setText(Q4Choice3);

                                //--Question 5 for easy quiz--//
                                String Question5 = doc.getString("Question5");
                                String Q5Choice1 = doc.getString("q5c1");
                                String Q5Choice2 = doc.getString("q5c2");
                                String Q5Choice3 = doc.getString("q5c3");
                                q5.setText(Question5);
                                rdbtn_q5c1.setText(Q5Choice1);
                                rdbtn_q5c2.setText(Q5Choice2);
                                rdbtn_q5c3.setText(Q5Choice3);
                                q1.setVisibility(view.VISIBLE);
                                q2.setVisibility(view.VISIBLE);
                                q3.setVisibility(view.VISIBLE);
                                q4.setVisibility(view.VISIBLE);
                                q5.setVisibility(view.VISIBLE);
                                rgQ1.setVisibility(view.VISIBLE);
                                rgQ2.setVisibility(view.VISIBLE);
                                rgQ3.setVisibility(view.VISIBLE);
                                rgQ4.setVisibility(view.VISIBLE);
                                rgQ5.setVisibility(view.VISIBLE);
                                submit.setVisibility(view.VISIBLE);
                                submit.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if(rdbtn_q1c2.isChecked())count++;
                                        if(rdbtn_q2c3.isChecked())count++;
                                        if(rdbtn_q3c1.isChecked())count++;
                                        if(rdbtn_q4c1.isChecked())count++;
                                        if(rdbtn_q5c3.isChecked())count++;
                                        String result = (count*2)+"/10";
                                        Toast.makeText(quiz.this, result, Toast.LENGTH_LONG).show();
                                        count = 0;
                                        rgQ1.clearCheck();
                                        rgQ2.clearCheck();
                                        rgQ3.clearCheck();
                                        rgQ4.clearCheck();
                                        rgQ5.clearCheck();
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.studioItem:
                Intent intent = new Intent(this, self_studio.class);
                startActivity(intent);
                return true;
            case R.id.quizItem:
                Intent intent2 = new Intent(this, quiz.class);
                startActivity(intent2);
                return true;
            case R.id.termsItem:
                Intent intent3 = new Intent(this,Terminologies.class);
                startActivity(intent3);
                return true;
            case R.id.ThemeItem:
                Intent intent4 = new Intent(this,Themes.class);
                startActivity(intent4);
                return true;
            case R.id.VideoLecturesItem:
                Intent intent5 = new Intent(this,VideoLectures.class);
                startActivity(intent5);
                return true;
            case R.id.ProgressMapItem:
                Intent intent6 = new Intent(this,ProgressMap.class);
                startActivity(intent6);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}