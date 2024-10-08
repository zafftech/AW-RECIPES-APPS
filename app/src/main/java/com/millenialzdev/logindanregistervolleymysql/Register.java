package com.millenialzdev.logindanregistervolleymysql;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText etFullname, etUserid, etPassword;
    private Button btnRegister;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFullname = findViewById(R.id.etFullname);
        etUserid = findViewById(R.id.etUserid);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
        databaseHelper = new DatabaseHelper(this); // Initialize DatabaseHelper

        // Register button stores user data in the SQLite database
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = etFullname.getText().toString().trim();
                String userid = etUserid.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (!(fullname.isEmpty() || userid.isEmpty() || password.isEmpty())) {
                    // Check if the userid already exists in the database
                    Boolean checkUser = databaseHelper.checkUserid(userid);
                    if (!checkUser) {
                        // Insert the new user into the database
                        Boolean insert = databaseHelper.insertData(fullname, userid, password);
                        if (insert) {
                            Toast.makeText(getApplicationContext(), "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Login.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Registrasi Gagal", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "User sudah ada. Silahkan Login.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Ada Data Yang Masih Kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
