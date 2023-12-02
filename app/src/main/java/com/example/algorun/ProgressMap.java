package com.example.algorun;

import static com.example.algorun.ThemeManager.setCustomizedThemes;
import static com.example.algorun.ThemeStorage.getThemeColor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ProgressMap extends AppCompatActivity {
    ExpandableListViewAdapter listViewAdapter;
    ExpandableListView expandableListView;
    List<String> mainList;
    HashMap<String, List <String>> subList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomizedThemes(this,getThemeColor(this));
        setContentView(R.layout.activity_progress_map);
        getSupportActionBar().setTitle("Progress Map");

        expandableListView = findViewById(R.id.eListView);

        showList();
        listViewAdapter = new ExpandableListViewAdapter(this,mainList,subList);
        expandableListView.setAdapter(listViewAdapter);


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View v, int i, int i1, long l) {
                View lastColored = null;
                final String selected = (String) listViewAdapter.getChild(i,i1);
                int groupPos = i;

                Intent intent;

                switch (selected){
                    case  "Quiz 1": //if selected button is quiz 1
                        intent = new Intent(ProgressMap.this,quiz.class);
                        startActivity(intent);
                        break;
                    case "Beginner level":
                        intent = new Intent(ProgressMap.this,easy_algorithms.class);
                        startActivity(intent);
                        break;
                    case "Intermediate level":
                        Intent intent2 = new Intent(ProgressMap.this, medium_algorithms.class);
                        startActivity(intent2);
                        break;
                    case "Advanced level":
                        Intent intent3 = new Intent(ProgressMap.this, advance_algorithms.class);
                        startActivity(intent3);
                        break;
                        //you can add more cases for other lesson and quiz classes
                }

                if(lastColored != null) //if not clicked before, color stays the same
                {
                    lastColored.setBackgroundColor(Color.TRANSPARENT);
                    lastColored.invalidate();
                }
                lastColored = v;
                v.setBackgroundColor(Color.rgb(214, 214, 214)); //color change when clicked (gray bg)

                return true;
            }
        });
    }

    private void showList(){
        mainList = new ArrayList<String>();
        subList = new HashMap<String, List<String>>();

        mainList.add("Lessons");
        mainList.add("Quizzes");

        List<String> lesson = new ArrayList<>();
        lesson.add("Beginner level");
        lesson.add("Intermediate level");
        lesson.add("Advanced level");

        List<String> quiz = new ArrayList<>();
        quiz.add("Quiz 1");
        quiz.add("Quiz 2");
        quiz.add("Quiz 3");
        quiz.add("Quiz 4");
        quiz.add("Quiz 5");

        subList.put(mainList.get(0),lesson);
        subList.put(mainList.get(1),quiz);
    }

//    private ExpandableListView.OnChildClickListener myListItemClicked =  new ExpandableListView.OnChildClickListener() {
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

//            System.out.println("group pos: " + groupPosition);
//            System.out.println("child pos: " + childPosition);
//
//
//            if(groupPosition == 0){ //Lessons Tab
//                switch (childPosition){
//                    case 0:
////                        Intent lesson1 = new Intent(ProgressMap.this, Lesson1.class);
////                        startActivity(lesson1);
//                        break;
//                    case 1:
//                        break;
//                    case 2:
//                        break;
//                    case 3:
//                        break;
//                    case 4:
//                        break;
//                }
//            } else if(groupPosition == 1){ //Quiz Tab
//                switch (childPosition){
//                    case 0:
                        Intent quiz1 = new Intent(ProgressMap.this, quiz.class);
                        startActivity(quiz1);
//                        break;
//                    case 1:
//                        break;
//                    case 2:
//                        break;
//                    case 3:
//                        break;
//                    case 4:
//                        break;
//                }
//            }

            return false;
        }
//    };






    //-----------------------------


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