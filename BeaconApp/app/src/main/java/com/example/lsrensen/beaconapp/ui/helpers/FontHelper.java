package com.example.lsrensen.beaconapp.ui.helpers;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by mlorenzen on 23-05-2015.
 */
public class FontHelper {

    public static void updateFont(Activity activity, int textViewId) {
        TextView tv=(TextView)activity.findViewById(textViewId);
        Typeface face= Typeface.createFromAsset(activity.getAssets(),
                "fonts/Lato.ttf");

        tv.setTypeface(face);
    }

}
