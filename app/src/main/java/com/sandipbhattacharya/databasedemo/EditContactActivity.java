package com.sandipbhattacharya.databasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditContactActivity extends AppCompatActivity {

    TextView tvName;
    EditText etEmail;
    long id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        id = getIntent().getExtras().getLong("id");
        String name = getIntent().getExtras().getString("name");
        String email = getIntent().getExtras().getString("email");
        tvName = findViewById(R.id.tvName);
        etEmail = findViewById(R.id.etEmail);
        tvName.setText(name);
        etEmail.setText(email);
    }

    public void editContact(View view){
        String email = etEmail.getText().toString();
        MainActivity.databaseAdapter.updateEmailNew(id, email);
        startActivity(new Intent(EditContactActivity.this, MainActivity.class));
        finish();
    }

    public void deleteContact(View view) {
        MainActivity.databaseAdapter.deleteDataNew(id);
        startActivity(new Intent(EditContactActivity.this, MainActivity.class));
        finish();
    }
}
