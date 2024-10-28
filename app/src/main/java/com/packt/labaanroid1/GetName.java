package com.packt.labaanroid1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);

        nameEditText = findViewById(R.id.nameEditText);
        submitButton = findViewById(R.id.submitButton);
        // Получаем Intent
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();// Получаем введенное имя пользователя
                Intent resultIntent = new Intent();//создаем Intent
                resultIntent.putExtra("name", name);
                setResult(RESULT_OK, resultIntent);
                finish();// Закрываем и возвращаемся
            }
        });
    }
    //Для самопроверки
    protected void onStart(){
        Toast.makeText(this, "onStart called!", Toast.LENGTH_LONG).show();
        super.onStart();
        //Toast.makeText(this, "onStart called!", Toast.LENGTH_LONG).show();
    }
    protected void onRestart(){
        Toast.makeText(this, "onRestart called!", Toast.LENGTH_LONG).show();
        super.onRestart();
        //Toast.makeText(this, "onRestart called!", Toast.LENGTH_LONG).show();
    }
    protected void onResume(){
        Toast.makeText(this, "onResume called!", Toast.LENGTH_LONG).show();
        super.onResume();
        //Toast.makeText(this, "onResume called!", Toast.LENGTH_LONG).show();
    }
    protected void onPause(){
        Toast.makeText(this, "onPause called!", Toast.LENGTH_LONG).show();
        super.onPause();
        //Toast.makeText(this, "onPause called!", Toast.LENGTH_LONG).show();
    }

    protected void onStop(){
        Toast.makeText(this, "onStop called!", Toast.LENGTH_LONG).show();
        super.onStop();
        //Toast.makeText(this, "onStop called!", Toast.LENGTH_LONG).show();
    }
    protected void onDestroy(){
        Toast.makeText(this, "onDestroy called!", Toast.LENGTH_LONG).show();
        super.onDestroy();
        //Toast.makeText(this, "onDestroy called!", Toast.LENGTH_LONG).show();
    }
}
