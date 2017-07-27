package itzik.com.simulationscreen.screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;

import java.util.Locale;

import itzik.com.simulationscreen.R;
import itzik.com.simulationscreen.Utils.UtilsDisplay;
import itzik.com.simulationscreen.board_view.BoardResultView;
import itzik.com.simulationscreen.tasks.ResultProbSearch;

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
        final Bundle extra = getIntent().getExtras();
        SparseArray<ResultProbSearch> results = extra.getSparseParcelableArray(KeyParams.KEY_RESULTS);
        updateBoardResult(results);
        Log.d(TAG, "onCreate: results size ? "+results.size());
    }



    private void updateBoardResult(SparseArray<ResultProbSearch> list){
        boardResultView.updateViewTable(list);
    }


}
