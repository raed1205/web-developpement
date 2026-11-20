package com.example.esb;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /**
     * LAB 2 - 2.3: called by the button thanks to android:onClick="validateAction"
     * in activity_main.xml. The method must be public, return void and take a View.
     * It displays a pop-up (Toast) summarising what the user typed.
     */
    public void validateAction(View v) {
        EditText firstname = findViewById(R.id.editTextFirstname);
        EditText lastname = findViewById(R.id.editTextLastname);
        EditText birthDate = findViewById(R.id.editTextBirthDate);
        EditText birthCity = findViewById(R.id.editTextBirthCity);

        String f = firstname.getText().toString().trim();
        String l = lastname.getText().toString().trim();
        String d = birthDate.getText().toString().trim();
        String c = birthCity.getText().toString().trim();

        if (f.isEmpty() || l.isEmpty() || d.isEmpty() || c.isEmpty()) {
            Toast.makeText(this, R.string.fill_all_fields, Toast.LENGTH_SHORT).show();
            return;
        }

        // e.g. "Raed Meddeb, born on 01/01/2004 in Tunis" (translated by the string resource)
        String summary = getString(R.string.summary_format, f, l, d, c);
        Toast.makeText(this, summary, Toast.LENGTH_LONG).show();
    }
}
