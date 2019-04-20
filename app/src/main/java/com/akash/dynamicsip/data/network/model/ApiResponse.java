package com.akash.dynamicsip.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {


    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("sensex")
    @Expose
    public String sensex;
    @SerializedName("equity")
    @Expose
    public String equity;
    @SerializedName("point")
    @Expose
    public String point;

    public ApiResponse(){

    }

    public ApiResponse(String date, String sensex, String equity, String point) {
        this.date = date;
        this.sensex = sensex;
        this.equity = equity;
        this.point = point;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSensex() {
        return sensex;
    }

    public void setSensex(String sensex) {
        this.sensex = sensex;
    }

    public String getEquity() {
        return equity;
    }

    public void setEquity(String equity) {
        this.equity = equity;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
