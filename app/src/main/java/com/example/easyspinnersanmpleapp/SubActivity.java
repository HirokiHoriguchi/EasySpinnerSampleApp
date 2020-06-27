package com.example.easyspinnersanmpleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class SubActivity extends AppCompatActivity {

    private static String[] spinnerItem = {"img1","img2","img3","img4","img5","img6","img7","img8","img9"};
    private static String[] spinnerImages = {"img","img1","img2","img3","img4","img5","img6","img7","img8"};
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        imageView = findViewById(R.id.image_view);

        Spinner spinner = findViewById(R.id.spinner1);

        TestAdapter adapter = new TestAdapter(this.getApplicationContext(), R.layout.list, spinnerItem, spinnerImages);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(getResources().getIdentifier(spinnerImages[position],"drawable", getPackageName()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }
}
