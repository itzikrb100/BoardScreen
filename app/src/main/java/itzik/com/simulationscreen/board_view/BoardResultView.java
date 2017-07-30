package itzik.com.simulationscreen.board_view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import itzik.com.simulationscreen.Utils.UtilsDisplay;
import itzik.com.simulationscreen.Utils.UtilsView;
import itzik.com.simulationscreen.board_view.table.TableResult;
import itzik.com.simulationscreen.tasks.ResultProbSearch;
import itzik.com.simulationscreen.tasks.TYPE_ALGO;

/**
 * Created by itzik on 23/07/2017.
 */

public class BoardResultView extends RelativeLayout {


    public static final String TAG = "BoardResultView";



    private int ID_TITLE,ID_TABLE;

    private BoardResultCallback callback;

    private final int COL_SOLUTION  = 1;
    private final int COL_ITERATION = 2;
    private final int COL_PATH      = 3;

    private TextView title;
    private TableResult tableResult;

    public BoardResultView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BoardResultView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public BoardResultView(Context context) {
        super(context);
    }



    public void initView(final BoardResultCallback callback){
        initGenerateIDS();
        RelativeLayout.LayoutParams param = null;

        param = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        param.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        param.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        param.setMargins(convertDp2Px(10),convertDp2Px(10),0,convertDp2Px(10));
        title = new TextView(getContext());
        title.setId(ID_TITLE);
        title.setTextSize(20);
        title.setText("Results");
        addView(title,param);


        param = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT);
        param.addRule(RelativeLayout.BELOW,title.getId());
        param.addRule(RelativeLayout.ALIGN_LEFT,title.getId());
        tableResult = new TableResult(getContext());
        tableResult.setId(ID_TABLE);
        tableResult.initTable(new TableResult.OnTableCallback(){
            @Override
            public void onShowPath(ResultProbSearch prob) {
                Log.d(TAG, "onShowPath: prob? "+prob);
                callback.onShowPath(prob);
            }
        });
        addView(tableResult,param);

        Log.d(TAG, "initView:");
    }


    public void updateViewTable(final SparseArray<ResultProbSearch> results){
        Log.d(TAG, "updateTable: result size? "+results.size());
        updateTable(results);

    }


    private void updateTable(final SparseArray<ResultProbSearch> results){
        Log.d(TAG, "updateTable:");
        ResultProbSearch rs = null;
        String find = null;
        rs = results.get(TYPE_ALGO.BFS.ordinal());
        //Log.d(TAG, "updateTable: rs? "+rs);
        find = "No";
        if(rs.isFind()){
            find = " Yes";
            tableResult.setEnableRow1Path(true);
        }
        tableResult.setRow1Text(COL_SOLUTION,find);
        tableResult.setRow1Text(COL_ITERATION,rs.getSolutionIterations()+"");




        rs = results.get(TYPE_ALGO.DFS.ordinal());
        find = "No";
        if(rs.isFind()){
            find = " Yes";
            tableResult.setEnableRow2Path(true);
        }
        tableResult.setRow2Text(COL_SOLUTION,find);
        tableResult.setRow2Text(COL_ITERATION,rs.getSolutionIterations()+"");



        rs = results.get(TYPE_ALGO.HeursticDistanceToGoal.ordinal());
        Log.d(TAG, "updateTable: TYPE_ALGO.HeursticDistanceToGoal");
        find = "No";
        if(rs.isFind()){
            find = " Yes";
            tableResult.setEnableRow3Path(true);
        }
        tableResult.setRow3Text(COL_SOLUTION,find);
        tableResult.setRow3Text(COL_ITERATION,rs.getSolutionIterations()+"");



        rs = results.get(TYPE_ALGO.A_STAR.ordinal());
        find = "No";
        if(rs.isFind()){
            find = " Yes";
            tableResult.setEnableRow4Path(true);
        }
        tableResult.setRow4Text(COL_SOLUTION,find);
        tableResult.setRow4Text(COL_ITERATION,rs.getSolutionIterations()+"");
        tableResult.setResults(results);
    }

    private void initGenerateIDS(){
        ID_TITLE   = UtilsView.generateViewId();
        ID_TABLE   = UtilsView.generateViewId();
        Log.d(TAG, "initGenerateIDS: title id? "+ID_TITLE+" , Table id? "+ID_TABLE);
    }


    private int convertDp2Px(float dp){
        return UtilsDisplay.convertDpScaleToPixelScale(getContext().getResources(),dp);
    }



    public interface BoardResultCallback{
        void onShowPath(ResultProbSearch resultProbSearch);
    }


}
