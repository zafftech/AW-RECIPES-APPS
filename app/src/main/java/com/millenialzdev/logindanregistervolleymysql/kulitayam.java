package com.millenialzdev.logindanregistervolleymysql;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class kulitayam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kulitayam);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.imageButtonKulitAyamContent), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton imageBackButton = findViewById(R.id.ImageBackButton);
        imageBackButton.setOnClickListener(v -> finish());
    }
}
