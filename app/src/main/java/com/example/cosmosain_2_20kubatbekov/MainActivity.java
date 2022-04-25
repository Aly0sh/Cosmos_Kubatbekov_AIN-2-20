package com.example.cosmosain_2_20kubatbekov;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button f_button;
    private Button s_button;
    private EditText text;
    private String textToSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f_button = findViewById(R.id.f_btn);
        s_button = findViewById(R.id.s_btn);
        text = findViewById(R.id.txt);

        f_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f_button.setVisibility(View.GONE);
                text.setVisibility(View.VISIBLE);
                s_button.setVisibility(View.VISIBLE);
            }
        });

        s_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    textToSend = text.getText().toString();
                    final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                    emailIntent.setType("plain/text");
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                            new String[] {"kubatbekovalaken@gmail.com"});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                            "Пожелания астронавту Шарипову Салижану");
                    emailIntent.putExtra(Intent.EXTRA_TEXT,
                            textToSend);
                    MainActivity.this.startActivity(Intent.createChooser(emailIntent,
                            "Отправка письма..."));
                    text.setText("");
                } catch (Exception e){
                    System.out.print(e.getMessage());
                }

            }
        });
    }

}