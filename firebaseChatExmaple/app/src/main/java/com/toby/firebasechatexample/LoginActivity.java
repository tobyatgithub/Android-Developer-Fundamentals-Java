package com.toby.firebasechatexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText emailETlogin, passwordETlogin;
    Button loginBtn, registerBtn;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onStart() {
        super.onStart();
        // Firebase Auth
        auth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        // checking for users existence: allow the user to save the currentt user.
        if (firebaseUser != null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailETlogin = findViewById(R.id.login_emailEditText);
        passwordETlogin = findViewById(R.id.login_passwordEditText);
        loginBtn = findViewById(R.id.loginButton);
        registerBtn = findViewById(R.id.goToRegisterButton);

        // Login Button:
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_text = emailETlogin.getText().toString();
                String password_text = passwordETlogin.getText().toString();

                // CHecking
                if (TextUtils.isEmpty(email_text) || TextUtils.isEmpty(password_text)) {
                    Toast.makeText(LoginActivity.this, "Please fill all the Fields", Toast.LENGTH_SHORT).show();
                } else {
                    auth.signInWithEmailAndPassword(email_text, password_text)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(LoginActivity.this,
                                                MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Log.d("***[[LoginActivity]]***", task.toString());
                                        Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}