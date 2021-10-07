package com.example.touristfinderapp;

import android.util.Log;

/*this class makes the item to object when item are fetch from layout_list image scroll*/
/*and put that objects in recycler view*/
public class modelClassApp {
    private static final String TAG = "modelClassApp";
    //store image id
    int image;
    //text
    String Content;


    public modelClassApp(int image, String content) {
        this.image = image;
        Log.i(TAG, "modelClassApp: "+image);
        this.Content = content;
    }

    public int getImage() {
        return image;
    }

    public String getContent() {
        return Content;
    }
}
