package com.example.esb_2025;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Static ("fake") data used to check the combination (LAB 4 - 1.4)
    private static final String VALID_USERNAME = "Admin";
    private static final String VALID_PASSWORD = "Admin";

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

        // Retrieve the button using its ID
        Button btnconnect1java = findViewById(R.id.btnconnect1);

        // Associate an onClickListener event to the button
        btnconnect1java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to be executed when we click on the connect button
                EditText userjava = findViewById(R.id.editTextusername);
                EditText pwdjava = findViewById(R.id.editTextPassword);
                String userstr = userjava.getText().toString().trim();
                String pwdstr = pwdjava.getText().toString();

                TextView txtformvaljava = findViewById(R.id.txtformval);
                TextView txtuserjava = findViewById(R.id.txtusername);
                TextView txtpwdjava = findViewById(R.id.txtpwd);

                // Clear the previous global error message
                txtformvaljava.setText("");

                // Both fields are mandatory
                boolean valid = true;
                if (userstr.isEmpty()) {
                    txtuserjava.setText(R.string.log_err_requis);
                    valid = false;
                } else {
                    txtuserjava.setText("");
                }
                if (pwdstr.isEmpty()) {
                    txtpwdjava.setText(R.string.log_err_requis);
                    valid = false;
                } else {
                    txtpwdjava.setText("");
                }

                // Check the combination against the static data
                if (valid) {
                    if (userstr.equals(VALID_USERNAME) && pwdstr.equals(VALID_PASSWORD)) {
                        Intent dashboardActivity = new Intent(MainActivity.this, Dashboard.class);
                        dashboardActivity.putExtra("user", userstr);
                        startActivity(dashboardActivity);
                        // The user is logged in: he must not be able to come back to the login screen
                        finish();
                    } else {
                        txtformvaljava.setText(R.string.log_err_cnx);
                    }
                }
            }
        });
    }
}
