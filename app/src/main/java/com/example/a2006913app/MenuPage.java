package com.example.a2006913app;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MenuPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
        Button stButton = findViewById(R.id.button3);
        Button instButton = findViewById(R.id.button4);

        stButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

        instButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstructions();
            }
        });

        }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openInstructions() {
        Intent intent = new Intent(this, InstructionsPage.class);
        startActivity(intent);
    }
}