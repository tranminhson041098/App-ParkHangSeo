package com.linearlayout.apphackathon130619.Main;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.linearlayout.apphackathon130619.Model.ContactResult;
import com.linearlayout.apphackathon130619.Model.Result;
import com.linearlayout.apphackathon130619.R;
import com.linearlayout.apphackathon130619.Utils.Utils;

public class ContactActivity extends AppCompatActivity {

    TextView tvName,tvPhoneNumber;
    ContactResult contactResult;
    RecyclerView rvContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        init();
        docJson();
        rvContactConfig();
    }
    void init()
    {
        tvName=findViewById(R.id.tv_name);
        tvPhoneNumber = findViewById(R.id.tv_phone_number);
        rvContact=findViewById(R.id.rv_contact);
    }
    void docJson()
    {
        String strContactData = Utils.loadJSONFromAsset(ContactActivity.this);
        Gson gson = new Gson();
        contactResult = gson.fromJson(strContactData,ContactResult.class);
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName;
        TextView tvPhoneNumber;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tv_name);
            tvPhoneNumber=itemView.findViewById(R.id.tv_phone_number);

        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
    void rvContactConfig()
    {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvContact.setLayoutManager(linearLayoutManager);
        RecyclerView.Adapter adapter = new RecyclerView.Adapter() {

            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(ContactActivity.this).inflate(R.layout.contact_item_layout,viewGroup,false);
                ContactViewHolder viewHolder = new ContactViewHolder(view);

                return viewHolder;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

                Result result = contactResult.getResult().get(i);
                ((ContactViewHolder)viewHolder).tvName.setText(result.getName());
                ((ContactViewHolder)viewHolder).tvPhoneNumber.setText(result.getPhone());


            }

            @Override
            public int getItemCount() {
                return contactResult.getResult().size();
            }
        };


        rvContact.setAdapter(adapter);

    }

}
