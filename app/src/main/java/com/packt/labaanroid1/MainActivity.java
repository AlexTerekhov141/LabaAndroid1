package com.packt.labaanroid1;

import android.content.Intent;
import android.net.Uri;
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
 * MainActivity
 *
 * Version 1.0
 *
 * October2024
 *
 * Practice work for android (Взаимодействие activities/ Interaction between activities)
 */
public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_GET_NAME = 1;// Код запроса для идентификации Intent
    Button bOk; //Кнопка
    TextView greetingTextView; //отображение приветствия

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bOk = findViewById(R.id.bOk);
        greetingTextView = findViewById(R.id.greetingTextView);
        EditText greetingEditText = findViewById(R.id.greetingEditText);
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String greetingMessage = greetingEditText.getText().toString();//Возможность самому вписать текст приветствия || если ничего то Hello или Привет
                if (greetingMessage.isEmpty()) {
                    greetingMessage = getString(R.string.Greeting);
                }
                // Создание Intent для перехода на GetName
                Intent i = new Intent(MainActivity.this, GetName.class);
                i.putExtra("message",greetingMessage);
                startActivityForResult(i, REQUEST_CODE_GET_NAME);
            }
        });
        Toast.makeText(MainActivity.this, "onCreate called!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (REQUEST_CODE_GET_NAME):
                if (resultCode == RESULT_OK) {
                    String name = data.getStringExtra("name");//Получаем имя
                    String message = data.getStringExtra("message");//Получаем message
                    if (name != null) {
                        String greetingMessage = message + ", " + name + "!";//Формируем сообщение
                        greetingTextView.setText(greetingMessage);// Отображаем сообщение
                    }
                }
                break;
        }
    }
}
