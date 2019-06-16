package com.linearlayout.apphackathon130619.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result2 {

@SerializedName("promotionID")
@Expose
public Integer promotionID;
@SerializedName("urlImage")
@Expose
public String urlImage;
@SerializedName("promotionName")
@Expose
public String promotionName;
@SerializedName("placeDetail")
@Expose
public PlaceDetail placeDetail;

    public Integer getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(Integer promotionID) {
        this.promotionID = promotionID;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public PlaceDetail getPlaceDetail() {
        return placeDetail;
    }

    public void setPlaceDetail(PlaceDetail placeDetail) {
        this.placeDetail = placeDetail;
    }
}