package com.example.algorun;

import static com.example.algorun.ThemeManager.setCustomizedThemes;
import static com.example.algorun.ThemeStorage.getThemeColor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class MainActivity extends AppCompatActivity
{
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomizedThemes(this,getThemeColor(this));
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        firestore = FirebaseFirestore.getInstance();

        Button login = (Button) findViewById(R.id.btnLogin);
        Button register = (Button) findViewById(R.id.btnReg);
        EditText email = (EditText) findViewById(R.id.editTextEmailLog);
        EditText pwd = (EditText) findViewById(R.id.editTextPasswordLog);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
                } else if (pwd.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter valid password", Toast.LENGTH_SHORT).show();
                }
                firestore.collection("client")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot doc : task.getResult()) {
                                        int count = 0;
                                        String a = doc.getString("Email");
                                        String b = doc.getString("Password");
                                        String a1 = email.getText().toString().trim();
                                        String b1 = pwd.getText().toString().trim();
                                        if (a != null && a.equalsIgnoreCase(a1) && b != null && b.equalsIgnoreCase(b1)) {
                                            Intent home = new Intent(MainActivity.this, algorithms.class);
                                            startActivity(home);
                                            Toast.makeText(MainActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
                                            count++;
                                            break;
                                        }else {
                                            if(count == 10){
                                                Toast.makeText(MainActivity.this, "Incorrect Email or Password. Try again", Toast.LENGTH_SHORT).show();
                                                email.setText("");
                                                pwd.setText("");
                                            }

                                        }
                                    }
                                }
                                Toast.makeText(MainActivity.this, "Incorrect Email or Password. Try again", Toast.LENGTH_SHORT).show();
                                email.setText("");
                                pwd.setText("");
                            }
                        });
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }
}