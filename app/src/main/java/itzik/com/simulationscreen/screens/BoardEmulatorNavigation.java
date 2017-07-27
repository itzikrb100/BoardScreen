package itzik.com.simulationscreen.screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;

import java.util.Locale;

import itzik.com.simulationscreen.R;
import itzik.com.simulationscreen.Utils.UtilsDisplay;
import itzik.com.simulationscreen.board.Board;
import itzik.com.simulationscreen.board_view.BoardView;
import itzik.com.simulationscreen.board_view.callbacks.OnBoardCallback;
import itzik.com.simulationscreen.tasks.PerformsProbSearch;
import itzik.com.simulationscreen.tasks.ResultProbSearch;
import itzik.com.simulationscreen.tasks.TaskInfo;

public class BoardEmulatorNavigation extends AppCompatActivity {


    public static final String TAG = BoardEmulatorNavigation.class.getSimpleName();

    private BoardView boardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UtilsDisplay.updateLayoutDirectionByConfig(this, Locale.ENGLISH);
        setContentView(R.layout.activity_simulation_screen);

        boardView = (BoardView)findViewById(R.id.board);
        final Board board = new Board(13,13);//(8,13);
        boardView.initView(board, new OnBoardCallback() {
            @Override
            public void onResultClick() {
                Log.d(TAG, "onResultClick:");
                //launchToResultScreen();
            }

            @Override
            public void onRunClick() {
                Log.d(TAG, "onRunClick:");
                clickAlgoTask(boardView.getIterations());
            }

            @Override
            public void onGenerateClick() {
                Log.d(TAG, "onGenerateClick:");
            }
        });


    }



    private void clickAlgoTask(final int iteration){
        Log.d(TAG, "clickAlgoRun: iteration? "+iteration);
        final PerformsProbSearch algoTask = new PerformsProbSearch(new PerformsProbSearch.PerformProbSearchCallback() {
            @Override
            public void onEndTask(SparseArray<ResultProbSearch> results) {
                Log.d(TAG, "clickAlgoTask: onEndTask: size? "+results.size());
                boardView.setRunButtonEnable(true);
                launchToResultScreen(results);
            }
        });

        final int sizePath = boardView.getBoard().getSpaceBoard().getSearchSpace().getspaceSize();
        Log.d(TAG, "clickAlgoTask: size? "+sizePath);
        TaskInfo info = new TaskInfo(boardView.getBoard().getSpaceBoard().getSearchSpace(),
                            sizePath,iteration);
        algoTask.execute(info);
        Log.d(TAG, "clickAlgoTask: info? "+info);

    }


    private void launchToResultScreen(SparseArray<ResultProbSearch> list){
        Log.d(TAG, "launchToResultScreen:");
        Intent launch = new Intent(this,ResultActivity.class);
        Bundle bundleExtras = new Bundle();
        bundleExtras.putSparseParcelableArray(KeyParams.KEY_RESULTS,list);
        launch.putExtras(bundleExtras);
        startActivity(launch);
    }
}
