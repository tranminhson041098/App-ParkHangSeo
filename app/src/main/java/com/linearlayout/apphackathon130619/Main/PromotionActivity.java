package com.linearlayout.apphackathon130619.Main;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.linearlayout.apphackathon130619.Model.PromotionResult;
import com.linearlayout.apphackathon130619.Model.Result2;
import com.linearlayout.apphackathon130619.R;
import com.linearlayout.apphackathon130619.Utils.UtilsPromotion;
import com.squareup.picasso.Picasso;

public class PromotionActivity extends AppCompatActivity {

    RecyclerView rvPromotion;
    PromotionResult promotionResult;
    ImageView imgAvatar;
    TextView tvPlaceName,tvPromotionName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);
        init();
        docJson();
        rvPromotionConfig();
    }
    void init()
    {
        rvPromotion = findViewById(R.id.rv_promotion);
        imgAvatar = findViewById(R.id.imv_avatar);
        tvPlaceName = findViewById(R.id.tv_place_name);
        tvPromotionName = findViewById(R.id.tv_promotion_name);


    }
    void docJson()
    {
        String strPromotionData = UtilsPromotion.loadJSONFromAsset(PromotionActivity.this);
        Gson gson = new Gson();
        promotionResult = gson.fromJson(strPromotionData,PromotionResult.class);
    }
    public class PromotionViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvPromotionName;
        TextView tvPlaceName;
        ImageView imgAvatar;
        public PromotionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlaceName=itemView.findViewById(R.id.tv_place_name);
            tvPromotionName=itemView.findViewById(R.id.tv_promotion_name);
            imgAvatar = itemView.findViewById(R.id.imv_avatar);

        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
    void rvPromotionConfig()
    {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvPromotion.setLayoutManager(linearLayoutManager);
        final RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
               View view = LayoutInflater.from(PromotionActivity.this).inflate(R.layout.promotion_item_layout,viewGroup,false);
               PromotionViewHolder viewHolder = new PromotionViewHolder(view) {
                   @Override
                   public String toString() {
                       return super.toString();
                   }
               };


                return viewHolder;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                Result2 result2 = promotionResult.getResult2().get(i);
                ((PromotionViewHolder)viewHolder).tvPromotionName.setText(result2.getPromotionName());
                ((PromotionViewHolder)viewHolder).tvPlaceName.setText(result2.getPlaceDetail().getPlaceName());
                Picasso.get().load(result2.getUrlImage()).into(((PromotionViewHolder) viewHolder).imgAvatar);

            }

            @Override
            public int getItemCount() {
                return promotionResult.getResult2().size();
            }
        };
        rvPromotion.setAdapter(adapter);


    }


}
