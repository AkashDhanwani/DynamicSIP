package com.akash.dynamicsip.data.network.model;

public class ApiResponse {

    public String date;
    public String sensex;
    public String equity;
    public String point;
    public boolean isSelected;

    public ApiResponse(){

    }

    public ApiResponse(String date, String sensex, String equity, String point, boolean isSelected) {
        this.date = date;
        this.sensex = sensex;
        this.equity = equity;
        this.point = point;
        this.isSelected = isSelected;
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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
