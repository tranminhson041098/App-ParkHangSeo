package com.linearlayout.apphackathon130619.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.linearlayout.apphackathon130619.R;

public class MainActivity extends AppCompatActivity {

    Button btnContact,btnPlace,btnPromotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        Xuly();
    }

    void init() {
        btnContact = (Button) findViewById(R.id.btn_contact);
        btnPlace = (Button) findViewById(R.id.btn_place);
        btnPromotion = (Button) findViewById(R.id.btn_promotion);
    }

    void Xuly() {
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);


            }
        });

        btnPromotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PromotionActivity.class);
                startActivity(intent);
            }
        });

        btnPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PlaceActivity.class);
                startActivity(intent);

            }
        });
    }
}
