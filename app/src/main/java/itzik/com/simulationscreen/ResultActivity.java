package itzik.com.simulationscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Locale;

import itzik.com.simulationscreen.Utils.UtilsDisplay;
import itzik.com.simulationscreen.board_view.BoardResultView;

/**
 * Created by itzik on 24/07/2017.
 */

public class ResultActivity extends AppCompatActivity {

    public static final String TAG = "ResultActivity";

    private BoardResultView boardResultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UtilsDisplay.updateLayoutDirectionByConfig(this, Locale.ENGLISH);
        setContentView(R.layout.result_activity);
        boardResultView = (BoardResultView)findViewById(R.id.board_result_table);
        boardResultView.initView();
    }



}
