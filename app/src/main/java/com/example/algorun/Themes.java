package com.example.algorun;

import static android.content.ContentValues.TAG;
import static com.example.algorun.ThemeManager.setCustomizedThemes;
import static com.example.algorun.ThemeStorage.getThemeColor;
import static com.example.algorun.ThemeStorage.setThemeColor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Themes extends AppCompatActivity{

    Button btnDef,btnNeo,btnDark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomizedThemes(this,getThemeColor(this));
        setContentView(R.layout.activity_themes);

        getSupportActionBar().setTitle("Themes");


        btnDef = (Button) findViewById(R.id.btnDef);
        btnNeo = (Button) findViewById(R.id.btnNeo);
        btnDark = (Button) findViewById(R.id.btnDark);
        final ColorDialogCallBack callback = null;

        btnDef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chosenColor = "tea";
                if(chosenColor.equals(getThemeColor(getApplicationContext()))){
                    Toast.makeText(Themes.this, "Theme has already been chosen", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d(TAG,chosenColor);
                setThemeColor(getApplicationContext(),chosenColor);
                setCustomizedThemes(getApplicationContext(),chosenColor);
                Toast.makeText(Themes.this, "Restart app to apply theme", Toast.LENGTH_SHORT).show();
                recreate();

            }
        });

        btnDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chosenColor = "dark";
                if(chosenColor.equals(getThemeColor(getApplicationContext()))){
                    Toast.makeText(Themes.this, "Theme has already been chosen", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d(TAG,chosenColor);
                setThemeColor(getApplicationContext(),chosenColor);
                setCustomizedThemes(getApplicationContext(),chosenColor);
                Toast.makeText(Themes.this, "Restart app to apply theme", Toast.LENGTH_SHORT).show();
                recreate();
            }
        });

        btnNeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chosenColor = "neo";
                if(chosenColor.equals(getThemeColor(getApplicationContext()))){
                    Toast.makeText(Themes.this, "Theme has already been chosen", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d(TAG,chosenColor);
                setThemeColor(getApplicationContext(),chosenColor);
                setCustomizedThemes(getApplicationContext(),chosenColor);
                Toast.makeText(Themes.this, "Restart app to apply theme", Toast.LENGTH_SHORT).show();
                recreate();
            }
        });
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