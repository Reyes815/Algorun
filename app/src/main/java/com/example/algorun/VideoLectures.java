package com.example.algorun;

import static com.example.algorun.ThemeManager.setCustomizedThemes;
import static com.example.algorun.ThemeStorage.getThemeColor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class VideoLectures extends AppCompatActivity {

    TextView txtCTutor, txtCppTutor,txtJavaTutor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomizedThemes(this,getThemeColor(this));
        setContentView(R.layout.activity_video_lectures);

        getSupportActionBar().setTitle("Video Lectures");

        txtCTutor = (TextView) findViewById(R.id.txtCTutor);
        txtCppTutor = (TextView) findViewById(R.id.txtCppTutor);
        txtJavaTutor = (TextView) findViewById(R.id.txtJavaTutor);

        txtCTutor.setMovementMethod(LinkMovementMethod.getInstance());
        txtCppTutor.setMovementMethod(LinkMovementMethod.getInstance());
        txtJavaTutor.setMovementMethod(LinkMovementMethod.getInstance());
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