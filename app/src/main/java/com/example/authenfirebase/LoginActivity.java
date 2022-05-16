package com.example.authenfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    public EditText email,password;
    public Button login;
    public Button tranToRegister;
    public FirebaseAuth loginAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.emailLogin);
        password = findViewById(R.id.passwordLogin);
        login = findViewById(R.id.btnLogin);
        tranToRegister = findViewById(R.id.btnTranToRegister);

        tranToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText,passwordText;
                emailText = email.getText().toString();
                passwordText = password.getText().toString();

                if(TextUtils.isEmpty(emailText)) {
                    Toast.makeText(LoginActivity.this,"Vui lòng nhập email!",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(passwordText)) {
                    Toast.makeText(LoginActivity.this,"Vui lòng nhập mật khẩu!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(passwordText.length() < 6) {
                    Toast.makeText(LoginActivity.this,"Vui lòng nhập hơn 6 kí tự!",Toast.LENGTH_SHORT).show();
                    return;
                }

                loginAuth.signInWithEmailAndPassword(emailText,passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this,"Đăng nhập thành công!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(LoginActivity.this,"Tài khoản hoặc mật khẩu không chính xác!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}