package com.linearlayout.apphackathon130619.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.linearlayout.apphackathon130619.Main.Adapter.PlaceAdapter;
import com.linearlayout.apphackathon130619.Model.PlaceResult;
import com.linearlayout.apphackathon130619.R;
import com.linearlayout.apphackathon130619.Utils.UtilsPlace;

public class PlaceActivity extends AppCompatActivity {

    PlaceResult placeData;
    RecyclerView rvPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        init();
        docJson();
        configRvPlace();
    }
    void init()
    {
        rvPlace = findViewById(R.id.rv_place);


    }
    void docJson()
    {

        String placeHome = UtilsPlace.loadJSONFromAsset(PlaceActivity.this);
        Gson gson = new Gson();
        placeData = gson.fromJson(placeHome, PlaceResult.class);


    }
    void configRvPlace()
    {

        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(PlaceActivity.this, LinearLayoutManager.VERTICAL, false);
        rvPlace.setLayoutManager(linearLayoutManager);
        PlaceAdapter adapter = new PlaceAdapter();
        adapter.data = placeData.getResult3();
        adapter.setContext(this);
        rvPlace.setAdapter(adapter);
    }
}
