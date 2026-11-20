package com.example.esb_2025;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve the content of the variable passed by MainActivity (putExtra("user", ...))
        TextView textViewUser = findViewById(R.id.textView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("user");
            if (value != null) {
                textViewUser.setText(getString(R.string.welcome_user, value));
            }
        }

        // MainActivity was finished after the login, so the button goes back to a fresh login screen
        Button btntjava = findViewById(R.id.btn);
        btntjava.setOnClickListener(v -> {
            startActivity(new Intent(Dashboard.this, MainActivity.class));
            finish();
        });
    }
}
