package com.example.lab6_calculator_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView resultField; // текстовое поле для вывода результата
    TextView numberField;   // поле для ввода числа
    Spinner upSpinner;
    Spinner downSpinner;
    HashMap<String, Double> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map.put("USD", 1.0);
        map.put("EUR", 1.3);
        map.put("BYN", 0.34);
        map.put("RUB", 0.02);
        map.put("AUD", 1.3);
        map.put("ARP", 1.2);
        map.put("DZD", 3.5);
        map.put("BRL", 0.24);
        map.put("GEL", 1.22);
        map.put("AED", 0.77);
        map.put("IND", 0.54);
        map.put("CAD", 1.1);
        // получаем все поля по id из activity_main.xml
        resultField =(TextView) findViewById(R.id.resultTextView);
        numberField = (TextView) findViewById(R.id.numberTextView);
        upSpinner = (Spinner) findViewById(R.id.upSpinner);
        downSpinner = (Spinner) findViewById(R.id.downSpinner);

    }
    // обработка нажатия на числовую кнопку
    public void onNumberClick(View view){
        Button button = (Button)view;
        numberField.append(button.getText());
    }
    // обработка нажатия на кнопку операции
    public void onOperationClick(View view){
        String number = numberField.getText().toString();
        String currency1 = upSpinner.getSelectedItem().toString();
        String currency2 = downSpinner.getSelectedItem().toString();
        // если введенно что-нибудь
        if(number.length()>0){
            number = number.replace(',', '.');
            try{
                Double result = Double.parseDouble(number);
                result *= getConversationCoefficient(result, currency1, currency2);
                resultField.setText(result.toString());
            }catch (NumberFormatException ex){
                numberField.setText("");
            }
        }
        numberField.setText("");
    }

    private Double getConversationCoefficient(double number, String currency1, String currency2){
        return map.get(currency1) / map.get(currency2);
    }

}