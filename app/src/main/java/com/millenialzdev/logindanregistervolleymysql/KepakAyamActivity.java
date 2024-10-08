package com.millenialzdev.logindanregistervolleymysql;

import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class KepakAyamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kepakayam);

        // Handle back button click
        ImageButton backButton = findViewById(R.id.ImageBackButton);
        backButton.setOnClickListener(v -> finish()); // Close the activity and go back to the previous one
    }
}
