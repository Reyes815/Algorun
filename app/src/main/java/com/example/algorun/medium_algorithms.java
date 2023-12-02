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

public class medium_algorithms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomizedThemes(this,getThemeColor(this));
        setContentView(R.layout.activity_medium_algorithms);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference intmdAlgoDoc = db.collection("algorithms").document("intermediate");

        Spinner dropmenu = (Spinner) findViewById(R.id.algoSpinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(medium_algorithms.this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.language));
        dropmenu.setAdapter(myAdapter);

        TextView txtneondesc = (TextView) findViewById(R.id.txtNeonDesc);
        TextView txtneoncode = (TextView) findViewById(R.id.txtNeonCode);
        TextView txtmulttbldesc = (TextView) findViewById(R.id.txtMultTblDesc);
        TextView txtmulttblcode = (TextView) findViewById(R.id.txtMultTblCode);
        Button switchcode = (Button) findViewById(R.id.btnSwitch);

        intmdAlgoDoc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    String neondesc = doc.getString("neondesc");
                    txtneondesc.setText(neondesc);
                    String multtbldesc = doc.getString("multtbldesc");
                    txtmulttbldesc.setText(multtbldesc);
                }
            }
        });

        switchcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String diff = dropmenu.getSelectedItem().toString();
                if(diff.equalsIgnoreCase("C")){
                    txtneoncode.setText(getString(R.string.IA1C));
                    txtmulttblcode.setText(getString(R.string.IA2C));
                }
                if(diff.equalsIgnoreCase("C++")){
                    txtneoncode.setText(getString(R.string.IA1Cpp));
                    txtmulttblcode.setText(getString(R.string.IA2Cpp));
                }
                if(diff.equalsIgnoreCase("Java")){
                    txtneoncode.setText(getString(R.string.IA1Java));
                    txtmulttblcode.setText(getString(R.string.IA2Java));
                }
            }
        });
    }
}