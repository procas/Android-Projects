package com.example.promamukherjee.practiceviews.RecyclerView;

public class ItemObject {
    private String countryName;
    private int resID;

    ItemObject(String name, int id)
    {
        this.countryName=name;
        this.resID=id;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
