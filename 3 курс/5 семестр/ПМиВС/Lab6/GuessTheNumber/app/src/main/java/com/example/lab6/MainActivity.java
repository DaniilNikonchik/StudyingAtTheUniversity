package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;
public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int random_num = (int)(Math.random() * 100);
    boolean endgame = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView3);
        etInput = (EditText) findViewById(R.id.editTextNumber2);
        bControl = (Button)findViewById(R.id.button);
    }
    public void onClick(View V){
        int user_number = Integer.parseInt(etInput.getText().toString());
        if (user_number <= 0 || user_number > 100){
            tvInfo.setText(getResources().getString(R.string.error));
        }
        if (user_number == random_num){
            tvInfo.setText(getResources().getString(R.string.hit));
        }
        else if (user_number > random_num){
            tvInfo.setText(getResources().getString(R.string.ahead));
        }
        else{
            tvInfo.setText(getResources().getString(R.string.behind));
        }

    }
}