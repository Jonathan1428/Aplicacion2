import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miaplicacion.ConfirmationActivity;
import com.google.android.material.textfield.TextInputEditText;

public class ContactFormActivity extends AppCompatActivity {

    private TextInputEditText fullNameEditText;
    private TextInputEditText birthDateEditText;
    private TextInputEditText phoneEditText;
    private TextInputEditText emailEditText;
    private TextInputEditText descriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);

        fullNameEditText = findViewById(R.id.editTextFullName);
        birthDateEditText = findViewById(R.id.editTextBirthDate);
        phoneEditText = findViewById(R.id.editTextPhone);
        emailEditText = findViewById(R.id.editTextEmail);
        descriptionEditText = findViewById(R.id.editTextDescription);

        Button nextButton = findViewById(R.id.buttonNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToConfirmationActivity();
            }
        });
    }

    private void goToConfirmationActivity() {
        Intent intent = new Intent(ContactFormActivity.this, ConfirmationActivity.class);
        intent.putExtra("fullName", fullNameEditText.getText().toString());
        intent.putExtra("birthDate", birthDateEditText.getText().toString());
        intent.putExtra("phone", phoneEditText.getText().toString());
        intent.putExtra("email", emailEditText.getText().toString());
        intent.putExtra("description", descriptionEditText.getText().toString());
        startActivity(intent);
    }
}
