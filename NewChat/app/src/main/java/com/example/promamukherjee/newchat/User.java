package com.example.promamukherjee.newchat;

import android.graphics.Bitmap;

public class User {

    String myName;
    int myId;
    Bitmap myIcon;

    public User(int myId, String myName, Bitmap myIcon){
        this.myIcon=myIcon;
        this.myId=myId;
        this.myName=myName;
    }

    public Bitmap getMyIcon() {
        return myIcon;
    }

    public void setMyIcon(Bitmap myIcon) {

    }

    public int getMyId() {
        return myId;
    }

    public void setMyId(int myId) {
        this.myId = myId;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }
}
