package itzik.com.simulationscreen.screens;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;

import java.util.Locale;

import itzik.com.simulationscreen.R;
import itzik.com.simulationscreen.Utils.UtilsDisplay;
import itzik.com.simulationscreen.board_view.BoardResultView;
import itzik.com.simulationscreen.board_view.GenerationPathView;
import itzik.com.simulationscreen.config_app.RobotNavigationApp;
import itzik.com.simulationscreen.tasks.ResultProbSearch;

/**
 * Created by itzik on 24/07/2017.
 */

public class ResultActivity extends AppCompatActivity {

    public static final String TAG = "ResultActivity";

    private BoardResultView boardResultView;
    private SparseArray<ResultProbSearch> results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UtilsDisplay.updateLayoutDirectionByConfig(this, Locale.ENGLISH);
        setContentView(R.layout.result_activity);
        boardResultView = (BoardResultView)findViewById(R.id.board_result_table);
        boardResultView.initView(new BoardResultView.BoardResultCallback() {
            @Override
            public void onShowPath(ResultProbSearch resultProbSearch) {
                Log.d(TAG, "onShowPath: rs? "+resultProbSearch);
                showPath(resultProbSearch);
            }
        });
        final Bundle extra = getIntent().getExtras();
        results = extra.getSparseParcelableArray(KeyParams.KEY_RESULTS);
        updateBoardResult(results);
        Log.d(TAG, "onCreate: results size ? "+results.size());
    }




    private void updateBoardResult(SparseArray<ResultProbSearch> list){
        boardResultView.updateViewTable(list);
    }


    private void showPath(ResultProbSearch result){
        final AlertDialog.Builder  pathDialogBuilder = new AlertDialog.Builder(
                this);

        // set title
        pathDialogBuilder.setTitle(result.getType_algo() + " path");
        GenerationPathView generationPathView = new GenerationPathView(getApplicationContext());
        generationPathView.initView();
        generationPathView.redrawPathGeneration(((RobotNavigationApp)getApplication()).getBoard().getSpaceBoard(),
                          result.getPath());
        // set dialog message
        pathDialogBuilder.setView(generationPathView);
        pathDialogBuilder.setNeutralButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
            }
        });

        pathDialogBuilder.create().show();
    }


}
