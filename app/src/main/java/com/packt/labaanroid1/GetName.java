package com.packt.labaanroid1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
/*
 * GetName(Activity)
 *
 * Version 1.0
 *
 * October2024
 *
 * Practice work for android (Взаимодействие activities/ Interaction between activities)
 */
public class GetName extends AppCompatActivity {
    private EditText nameEditText;// Поле для ввода имени пользователя
    private Button submitButton;//кнопка для подтверждения
    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);

        nameEditText = findViewById(R.id.nameEditText);
        submitButton = findViewById(R.id.submitButton);
        messageTextView = findViewById(R.id.messageTextView);
        // Получаем Intent
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        if (message != null) {
            messageTextView.setText(message);
        }
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim(); // Получаем введенное имя пользователя
                // Проверяем, ввел ли пользователь имя
                if (name.isEmpty()) {
                    Toast.makeText(GetName.this, "Введите имя", Toast.LENGTH_SHORT).show(); // Подсказка
                } else {
                    Intent resultIntent = new Intent(); // создаем Intent
                    resultIntent.putExtra("name", name);
                    resultIntent.putExtra("message", message);
                    setResult(RESULT_OK, resultIntent);
                    finish(); // Закрываем и возвращаемся
                }
            }
        });
    }
}
