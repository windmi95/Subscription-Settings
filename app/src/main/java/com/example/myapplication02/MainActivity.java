package com.example.myapplication02;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.nickname);
        button = findViewById(R.id.next_btn);
        textView = findViewById(R.id.text_count);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //text가 바뀌기 전 호출

            }

            @SuppressLint("ResourceType")
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //text가 바뀔 때마다 호출
                int count = editText.length();

                textView.setText(count+"/5");


                if (count > 4) {
                    button.setClickable(true);
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.complete_btn));

                } else {
                    button.setClickable(false);
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.next_btn_color));

                }
                String input = editText.getText().toString();
                textView.setText((input.length())+"/5");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}