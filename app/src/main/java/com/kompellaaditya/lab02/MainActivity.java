package com.kompellaaditya.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button incrementButton;
    TextView greetingDisplay;
    EditText name;
    int count = 0;
    String[] planets;
    RadioButton left, right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementButton = findViewById(R.id.increment_button);
        greetingDisplay = findViewById(R.id.greeting_textview);
        planets = getResources().getStringArray(R.array.planets_array);
        left = findViewById(R.id.radio_left);
        right = findViewById(R.id.radio_right);
        name   = (EditText)findViewById(R.id.plain_text_input);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                System.out.println("incrementing: " + ++count);
//                Log.i("incrementing", ""+count);
//                greetingDisplay.setText(getString(R.string.likes_count,count));

                if(right.isChecked())
                    count = ++count % planets.length;
                greetingDisplay.setText(planets[count]);
            }
        });
    }

    public void decrement(View view) {
//        System.out.println("decrementing: " + --count);
//        greetingDisplay.setText(getString(R.string.likes_count,count));
        if(left.isChecked())
            if(--count < 0) count = planets.length-1;
        greetingDisplay.setText(planets[count]);
    }
    public void set(View view) {
        greetingDisplay.setText(String.valueOf(name.getText()));
    }


}