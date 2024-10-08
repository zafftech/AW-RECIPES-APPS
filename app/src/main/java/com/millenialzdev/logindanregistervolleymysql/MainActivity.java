package com.millenialzdev.logindanregistervolleymysql;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference to the logout button
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear user session or shared preferences to perform logout
                SharedPreferences preferences = getSharedPreferences("user_session", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();

                // Redirect to LoginActivity
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish(); // Close current activity
            }
        });

        // Set up image buttons
        ImageButton imageButtonAyamG = findViewById(R.id.imageButtonAyamG);
        ImageButton imageButtonKulitAyam = findViewById(R.id.imageButtonKulitAyam);
        ImageButton imageButtonWaffle = findViewById(R.id.imageButtonWaffle);
        ImageButton imageButtonSosejJumbo = findViewById(R.id.imageButtonSosejJumbo);
        ImageButton imageButtonAbout = findViewById(R.id.imageButtonAbout);
        ImageButton imageButtonUserGuide = findViewById(R.id.imageButtonUserGuide);
        ImageButton imageButtonKepakAyam = findViewById(R.id.imageButtonkepakayam);


        imageButtonAyamG.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Ayamg.class)));
        imageButtonKulitAyam.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, kulitayam.class)));
        imageButtonWaffle.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Waffle.class)));
        imageButtonSosejJumbo.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SosejJumbo.class)));
        imageButtonAbout.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, about.class)));
        imageButtonUserGuide.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, UserGuide.class)));
        imageButtonKepakAyam.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, KepakAyamActivity.class)));

    }
}
