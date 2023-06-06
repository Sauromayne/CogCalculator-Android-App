package com.sauromayne.cogcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectionActivity extends AppCompatActivity implements View.OnClickListener {

    private String cogLevel, cogHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        Button level1 = findViewById(R.id.level1);
        Button level2 = findViewById(R.id.level2);
        Button level3 = findViewById(R.id.level3);
        Button level4 = findViewById(R.id.level4);
        Button level5 = findViewById(R.id.level5);
        Button level6 = findViewById(R.id.level6);
        Button level7 = findViewById(R.id.level7);
        Button level8 = findViewById(R.id.level8);
        Button level9 = findViewById(R.id.level9);
        Button level10 = findViewById(R.id.level10);
        Button level11 = findViewById(R.id.level11);
        Button level12 = findViewById(R.id.level12);
        Button level13 = findViewById(R.id.level13);
        Button level14 = findViewById(R.id.level14);
        Button level15 = findViewById(R.id.level15);
        Button level16 = findViewById(R.id.level16);
        Button level17 = findViewById(R.id.level17);
        Button level18 = findViewById(R.id.level18);
        Button level19 = findViewById(R.id.level19);
        Button level20 = findViewById(R.id.level20);


        // set on click listeners
        level1.setOnClickListener(this);
        level2.setOnClickListener(this);
        level3.setOnClickListener(this);
        level4.setOnClickListener(this);
        level5.setOnClickListener(this);
        level6.setOnClickListener(this);
        level7.setOnClickListener(this);
        level8.setOnClickListener(this);
        level9.setOnClickListener(this);
        level10.setOnClickListener(this);
        level11.setOnClickListener(this);
        level12.setOnClickListener(this);
        level13.setOnClickListener(this);
        level14.setOnClickListener(this);
        level15.setOnClickListener(this);
        level16.setOnClickListener(this);
        level17.setOnClickListener(this);
        level18.setOnClickListener(this);
        level19.setOnClickListener(this);
        level20.setOnClickListener(this);


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        // set cogLevel depending on button clicked
        switch (view.getId()){
            case R.id.level1:
                cogLevel = "1";
                cogHp = getString(R.string.hp_1);
                break;
            case R.id.level2:
                cogLevel = "2";
                cogHp = getString(R.string.hp_2);
                break;
            case R.id.level3:
                cogLevel = "3";
                cogHp = getString(R.string.hp_3);
                break;
            case R.id.level4:
                cogLevel = "4";
                cogHp = getString(R.string.hp_4);
                break;
            case R.id.level5:
                cogLevel = "5";
                cogHp = getString(R.string.hp_5);
                break;
            case R.id.level6:
                cogLevel = "6";
                cogHp = getString(R.string.hp_6);
                break;
            case R.id.level7:
                cogLevel = "7";
                cogHp = getString(R.string.hp_7);
                break;
            case R.id.level8:
                cogLevel = "8";
                cogHp = getString(R.string.hp_8);
                break;
            case R.id.level9:
                cogLevel = "9";
                cogHp = getString(R.string.hp_9);
                break;
            case R.id.level10:
                cogLevel = "10";
                cogHp = getString(R.string.hp_10);
                break;
            case R.id.level11:
                cogLevel = "11";
                cogHp = getString(R.string.hp_11);
                break;
            case R.id.level12:
                cogLevel = "12";
                cogHp = getString(R.string.hp_12);
                break;
            case R.id.level13:
                cogLevel = "13";
                cogHp = getString(R.string.hp_13);
                break;
            case R.id.level14:
                cogLevel = "14";
                cogHp = getString(R.string.hp_14);
                break;
            case R.id.level15:
                cogLevel = "15";
                cogHp = getString(R.string.hp_15);
                break;
            case R.id.level16:
                cogLevel = "16";
                cogHp = getString(R.string.hp_16);
                break;
            case R.id.level17:
                cogLevel = "17";
                cogHp = getString(R.string.hp_17);
                break;
            case R.id.level18:
                cogLevel = "18";
                cogHp = getString(R.string.hp_18);
                break;
            case R.id.level19:
                cogLevel = "19";
                cogHp = getString(R.string.hp_19);
                break;
            case R.id.level20:
                cogLevel = "20";
                cogHp = getString(R.string.hp_20);
                break;
        }

        // Calculator Activity Intent
        Intent intent = new Intent(this, CalculatorActivity.class);
        // create bundle of extras
        Bundle extras = new Bundle();
        extras.putString("COG_LEVEL", cogLevel);
        extras.putString("COG_HP", cogHp);
        // add the bundle to the intent
        intent.putExtras(extras);
        // start Calculator Activity
        startActivity(intent);
    }
}