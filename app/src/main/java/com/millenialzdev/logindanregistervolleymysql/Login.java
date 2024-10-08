package com.millenialzdev.logindanregistervolleymysql;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText etUserid, etPassword;
    private Button btnLogin, btnRegister;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserid = findViewById(R.id.etUserid);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        databaseHelper = new DatabaseHelper(this); // Initialize DatabaseHelper

        // Register button leads to the registration activity
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

        // Login button checks credentials from the local SQLite database
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userid = etUserid.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (!(userid.isEmpty() || password.isEmpty())) {
                    // Check if userid and password match in the SQLite database
                    Boolean checkUserPass = databaseHelper.checkUseridPassword(userid, password);
                    if (checkUserPass) {
                        Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Gagal. Password atau Username salah.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Password atau Username Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
