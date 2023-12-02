package com.example.algorun;

import static com.example.algorun.ThemeManager.setCustomizedThemes;
import static com.example.algorun.ThemeStorage.getThemeColor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Terminologies extends AppCompatActivity implements View.OnClickListener{

    TextView txtWords;
    Button a,b,c,d,e,f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomizedThemes(this,getThemeColor(this));
        setContentView(R.layout.activity_terminologies);

        getSupportActionBar().setTitle("Terminologies");
        a = (Button) findViewById(R.id.btnA);
        b = (Button) findViewById(R.id.btnB);
        c = (Button) findViewById(R.id.btnC);
        d = (Button) findViewById(R.id.btnD);
        e = (Button) findViewById(R.id.btnE);
        f = (Button) findViewById(R.id.btnF);

        //the textview that will be replaced to DISPLAY all the terms and definitions
        txtWords = (TextView) findViewById(R.id.txtWords);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnA:
                getText('A');
                break;
            case R.id.btnB:
                getText('B');
                break;
            case R.id.btnC:
                getText('C');
                break;
            case R.id.btnD:
                getText('D');
                break;
            case R.id.btnE:
                getText('E');
                break;
            case R.id.btnF:
                getText('F');
                break;

        }
    }
    private void getText(char letter){
        String text = "";
        try{
            InputStream is = getAssets().open(letter +".txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            text  = new String(buffer);
            is.close();
            txtWords.setText(text);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //------------------------INFLATER---------------
    //I added it manually in every class cuz i didnt know another way
    //u can change it to make it more efficient if u wanna
    public boolean onCreateOptionsMenu(Menu menu) {
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
}