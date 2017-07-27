package itzik.com.simulationscreen.Utils;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by itzik on 06/04/2016.
 */


public class UtilsPatterns {


    public static final String TAG = "UtilsPatterns";




    private static final String DIGIT_PATTERN = "[0-9+\\s+/()]+";


    private static Pattern patternDigit = Pattern.compile(DIGIT_PATTERN);


    public static boolean isOnlyNumber(String row) {
        Matcher matcher = patternDigit.matcher(row.trim());
        boolean isOnlyDigit = matcher.matches();
        Log.d(TAG, "isOnlyDigit? " + isOnlyDigit);
        return isOnlyDigit;
    }

}
