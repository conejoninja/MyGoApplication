package me.conejo.mygoapplication;


import android.util.Log;
import go.mygolibrary.JavaCallback;

public class GoCallback implements JavaCallback {

    public void callFromGo(String data) {
        Log.d("[GO CALLBACK]", data);
        MainActivity.changeText(data);
    }


}