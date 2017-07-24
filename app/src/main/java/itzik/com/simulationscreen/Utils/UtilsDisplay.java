package itzik.com.simulationscreen.Utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import java.util.Locale;

/**
 * Created by itzik on 22/07/2017.
 */

public class UtilsDisplay {


    public static final String TAG = "UtilsDisplay";

    public static int convertDpScaleToPixelScale(Resources res, float dpScale) {

        final float scaleDensity = res.getDisplayMetrics().density;

        final float factor =  getFactorByDensity(scaleDensity);

        final int newPixelScale = (int) (dpScale * scaleDensity * factor + 0.5f);

        Log.d(TAG, " scaleDensity ? " + scaleDensity + " newPixel ? " + newPixelScale + " factor " + factor);

        return newPixelScale;
    }


    public static Point getScreenSizeVars(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Log.d(TAG, "Screen Width ? " + size.x + " , Height ? " + size.y);
        return size;
    }



    public static void updateLayoutDirectionByConfig(Context context, Locale locale) {
        context.getResources().getConfiguration().setLayoutDirection(locale);
    }



    private static float getFactorByDensity(float density){

        float factor = 1;

        if(density>=3)
            factor = 0.7f;

        if(density>1 && density<3)
            factor=0.5f;


        return factor;
    }
}
