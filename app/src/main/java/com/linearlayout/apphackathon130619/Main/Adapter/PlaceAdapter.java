package com.linearlayout.apphackathon130619.Main.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linearlayout.apphackathon130619.Model.PlaceResult;
import com.linearlayout.apphackathon130619.Model.Result3;
import com.linearlayout.apphackathon130619.R;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Result3> data;
    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PlaceViewHolder(LayoutInflater.from(context).inflate(R.layout.place_item_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder placeViewHolder, int i) {
      Result3 place = data.get(i);
      placeViewHolder.tvName.setText(place.getPlaceName());
      int a = place.getIsPromotion();
      if(a == 1){
        placeViewHolder.tvPromotion.setVisibility(View.VISIBLE);
      }else {
          placeViewHolder.tvPromotion.setVisibility(View.INVISIBLE);
      }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPromotion;


        public PlaceViewHolder(View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_place);
            tvPromotion = itemView.findViewById(R.id.tv_promotion);
        }
    }


}
