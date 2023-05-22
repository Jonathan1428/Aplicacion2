package com.example.miaplicacion;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    private TextView fullNameTextView;
    private TextView birthDateTextView;
    private TextView phoneTextView;
    private TextView emailTextView;
    private TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        fullNameTextView = findViewById(R.id.textViewFullName);
        birthDateTextView = findViewById(R.id.textViewBirthDate);
        phoneTextView = findViewById(R.id.textViewPhone);
        emailTextView = findViewById(R.id.textViewEmail);
        descriptionTextView = findViewById(R.id.textViewDescription);

        Button editButton = findViewById(R.id.buttonEdit);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToContactFormActivity();
            }
        });

        // Obtén los datos pasados desde la actividad anterior
        Intent intent = getIntent();
        String fullName = intent.getStringExtra("fullName");
        String birthDate = intent.getStringExtra("birthDate");
        String phone = intent.getStringExtra("phone");
        String email = intent.getStringExtra("email");
        String description = intent.getStringExtra("description");

        // Muestra los datos en la UI
        fullNameTextView.setText(fullName);
        birthDateTextView.setText(birthDate);
        phoneTextView.setText(phone);
        emailTextView.setText(email);
        descriptionTextView.setText(description);
    }

    private void goToContactFormActivity() {
        Intent intent = new Intent(ConfirmationActivity.this, ContactFormActivity.class);
        intent.putExtra("fullName", fullNameTextView.getText().toString());
        intent.putExtra("birthDate", birthDateTextView.getText().toString());
        intent.putExtra("phone", phoneTextView.getText().toString());
        intent.putExtra("email", emailTextView.getText().toString());
        intent.putExtra("description", descriptionTextView.getText().toString());
        startActivity(intent);
    }
}
