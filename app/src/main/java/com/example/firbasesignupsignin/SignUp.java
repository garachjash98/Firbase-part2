package com.example.firbasesignupsignin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUp extends AppCompatActivity {



    EditText Emailid,Passwrod;
    Button regbtn;
    TextView login;

    FirebaseAuth auth;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Emailid = findViewById(R.id.emailedittext);
        Passwrod = findViewById(R.id.passwordedittext);
        regbtn = findViewById(R.id.signupbutton);
        login = findViewById(R.id.signintextview);

        auth = FirebaseAuth.getInstance();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignUp.this,MainActivity.class));

            }
        });


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                RegisterUser();

            }
        });














    }

    public  void RegisterUser()
    {
        String email = Emailid.getText().toString();
        String pass = Passwrod.getText().toString();


        auth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful())
                        {
                            Toast.makeText(SignUp.this,"Registration Done",Toast.LENGTH_LONG).show();
                            Emailid.setText("");
                            Passwrod.setText("");
                        }
                        else
                        {
                            Toast.makeText(SignUp.this,"Registration Not Done",Toast.LENGTH_LONG).show();
                            Emailid.setText("");
                            Passwrod.setText("");
                        }

                    }
                });

    }


}
