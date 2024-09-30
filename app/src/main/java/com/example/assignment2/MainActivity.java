package com.example.assignment2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CheckBox Brown, Red, Blue, Black;
    ArrayList<String> arr = new ArrayList<>();

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private CompoundButton isChecked;

    private TextView ratingText, ColorArray;
    private RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Brown = findViewById(R.id.brown);
        Red = findViewById(R.id.red);
        Blue = findViewById(R.id.blue);
        Black = findViewById(R.id.black);
        ColorArray = findViewById(R.id.colorArray);

        radioGroup = findViewById(R.id.radioGroup);
        ratingBar = findViewById(R.id.ratingBar);
        ratingText = findViewById(R.id.rating);

        Brown.setOnCheckedChangeListener((buttonView, isChecked) -> {
            check(buttonView, isChecked);
        });
        Red.setOnCheckedChangeListener((buttonView, isChecked) -> {
            check(buttonView, isChecked);
        });
        Blue.setOnCheckedChangeListener((buttonView, isChecked) -> {
            check(buttonView, isChecked);
        });
        Black.setOnCheckedChangeListener((buttonView, isChecked) -> {
            check(buttonView, isChecked);
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = findViewById(checkedId);
            }
        });


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingText.setText("Rating: " + rating);
            }
        });

    }

    void check(CompoundButton buttonView, Boolean isChecked){
            if (isChecked) {
                arr.add(buttonView.getText().toString());
                Log.d("array", String.valueOf(arr));
            } else{
                arr.remove(buttonView.getText().toString());
            }
            ColorArray.setText(String.valueOf(arr));







    }
}