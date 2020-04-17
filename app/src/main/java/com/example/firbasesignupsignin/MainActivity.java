package com.example.firbasesignupsignin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText emailid,password;
    Button loginbtn;
    TextView signup;


    FirebaseAuth authl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        emailid = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        loginbtn = findViewById(R.id.cirLoginButton);
        signup = findViewById(R.id.textviewsignup);


        authl = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,SignUp.class));

            }
        });


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginUser();

            }
        });

    }
    public void LoginUser()

    {
        String Email = emailid.getText().toString().trim();
        String Passwd = password.getText().toString().trim();

        authl.signInWithEmailAndPassword(Email,Passwd)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {

                        if(task.isSuccessful())
                        {
                            startActivity(new Intent(MainActivity.this,Home.class));
                            emailid.setText("");
                            password.setText("");

                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"EMail id or passwor is incoorect",Toast.LENGTH_LONG).show();
                            emailid.setText("");
                            password.setText("");

                        }

                    }
                });


    }
}
