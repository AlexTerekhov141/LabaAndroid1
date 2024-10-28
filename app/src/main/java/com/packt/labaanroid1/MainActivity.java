package com.packt.labaanroid1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создание Intent для перехода на GetName
                Intent i = new Intent(MainActivity.this, GetName.class);
                i.putExtra("message", "hello");
                startActivityForResult(i, REQUEST_CODE_GET_NAME);
            }
        });
        Toast.makeText(MainActivity.this, "onCreate called!", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case (REQUEST_CODE_GET_NAME):
                if(resultCode == RESULT_OK){
                    String name = data.getStringExtra("name");//Получаем имя
                    if (name != null) {
                        String greetingMessage = getString(R.string.Greeting) + ", " + name + "!";//Формируем сообщение
                        greetingTextView.setText(greetingMessage);// Отображаем сообщение
                    }
                }
                break;
        }
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