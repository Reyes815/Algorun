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

public class advance_algorithms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomizedThemes(this,getThemeColor(this));
        setContentView(R.layout.activity_advance_algorithms);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference advdAlgoDoc = db.collection("algorithms").document("advanced");

        Spinner dropmenu = (Spinner) findViewById(R.id.algoSpinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(advance_algorithms.this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.language));
        dropmenu.setAdapter(myAdapter);

        TextView txtpyramiddesc = (TextView) findViewById(R.id.txtPyramidDesc);
        TextView txtpyramidcode = (TextView) findViewById(R.id.txtPyramidCode);
        TextView txtcheckprimedesc = (TextView) findViewById(R.id.txtCheckPrimeDesc);
        TextView txtcheckprimecode = (TextView) findViewById(R.id.txtCheckPrimeCode);
        Button switchcode = (Button) findViewById(R.id.btnSwitch);

        advdAlgoDoc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    String pyramiddesc = doc.getString("pyramiddesc");
                    txtpyramiddesc.setText(pyramiddesc);
                    String checkprimedesc = doc.getString("checkprimedesc");
                    txtcheckprimedesc.setText(checkprimedesc);
                }
            }
        });

        switchcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String diff = dropmenu.getSelectedItem().toString();
                if(diff.equalsIgnoreCase("C")){
                    txtpyramidcode.setText(getString(R.string.AA1C));
                    txtcheckprimecode.setText(getString(R.string.AA2C));
                }
                if(diff.equalsIgnoreCase("C++")){
                    txtpyramidcode.setText(getString(R.string.AA1Cpp));
                    txtcheckprimecode.setText(getString(R.string.AA2Cpp));
                }
                if(diff.equalsIgnoreCase("Java")){
                    txtpyramidcode.setText(getString(R.string.AA1Java));
                    txtcheckprimecode.setText(getString(R.string.AA2Java));
                }
            }
        });
    }
}