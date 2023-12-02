package com.example.algorun;

import static com.example.algorun.ThemeManager.setCustomizedThemes;
import static com.example.algorun.ThemeStorage.getThemeColor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class easy_algorithms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomizedThemes(this,getThemeColor(this));
        setContentView(R.layout.activity_easy_algorithms);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference bgnrAlgoDoc = db.collection("algorithms").document("beginner");

        Spinner dropmenu = (Spinner) findViewById(R.id.algoSpinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(easy_algorithms.this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.language));
        dropmenu.setAdapter(myAdapter);

        TextView txtfizzbuzzcode = (TextView) findViewById(R.id.txtFizzBuzzCode);
        TextView txtfizzbuzzhist = (TextView) findViewById(R.id.txtFizzBuzzDesc);
        TextView txtquicksortcode = (TextView) findViewById(R.id.txtQuickSortCode);
        TextView txtquicksorthist = (TextView) findViewById(R.id.txtQuickSortDesc);
        Button switchcode = (Button) findViewById(R.id.btnSwitch);

        bgnrAlgoDoc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    String fizzbuzzhist = doc.getString("fizzbuzzhist");
                    txtfizzbuzzhist.setText(fizzbuzzhist);
                    String quicksorthist = doc.getString("quicksorthist");
                    txtquicksorthist.setText(quicksorthist);
                }
            }
        });

        switchcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String diff = dropmenu.getSelectedItem().toString();
                if(diff.equalsIgnoreCase("C")){
                    txtfizzbuzzcode.setText(getString(R.string.BA1C));
                    txtquicksortcode.setText(getString(R.string.BA2C));
                }
                if(diff.equalsIgnoreCase("C++")){
                    txtfizzbuzzcode.setText(getString(R.string.BA1Cpp));
                    txtquicksortcode.setText(getString(R.string.BA2Cpp));
                }
                if(diff.equalsIgnoreCase("Java")){
                    txtfizzbuzzcode.setText(getString(R.string.BA1Java));
                    txtquicksortcode.setText(getString(R.string.BA2Java));
                }
            }
        });
    }
}