package com.example.algorun;

import static com.example.algorun.ThemeManager.setCustomizedThemes;
import static com.example.algorun.ThemeStorage.getThemeColor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class algorithms extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomizedThemes(this,getThemeColor(this));
        setContentView(R.layout.activity_algorithms);

        getSupportActionBar().setTitle("Algorithms");

        Button beginner = (Button) findViewById(R.id.btnBgnrAlgo);
        Button intermediate = (Button) findViewById(R.id.btnIntmdAlgo);
        Button advanced = (Button) findViewById(R.id.btnAdvncAlgo);

        beginner.setOnClickListener(this);
        intermediate.setOnClickListener(this);
        advanced.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBgnrAlgo:
                Intent intent = new Intent(this, easy_algorithms.class);
                startActivity(intent);
                break;
            case R.id.btnIntmdAlgo:
                Intent intent2 = new Intent(this, medium_algorithms.class);
                startActivity(intent2);
                break;
            case R.id.btnAdvncAlgo:
                Intent intent3 = new Intent(this, advance_algorithms.class);
                startActivity(intent3);
                break;
        }
    }
}