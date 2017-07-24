package itzik.com.simulationscreen.board_view.table;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TableLayout;

import itzik.com.simulationscreen.Utils.UtilsView;

/**
 * Created by itzik on 23/07/2017.
 */

public class TableResult extends TableLayout {

    public static final String TAG = "TableResult";


   // private Button pathBFS,pathDFS,pathIDFS , pathAStar;

    private RowTitleResult rowTitleResult;
    private RowResult row1,row2,row3,row4;
    private int ID_ROW1,ID_ROW2,ID_ROW3,ID_ROW4,ID_ROW5;

    public TableResult(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TableResult(Context context) {
        super(context);
    }


    public void setRow1Text(final int col,String text){
        Log.d(TAG, "setRow1Text: col? "+col+" , text? "+text);
        switch (col){
            case 0:
                row1.setRow1Text(text);
                break;
            case 1:
                row1.setRow2Text(text);
                break;
            case 2:
                row1.setRow3Text(text);
                break;
            case 3:
                row1.setRow4Text(text);
                break;
        }
    }




    public void setRow2Text(final int col,String text){
        Log.d(TAG, "setRow1Text: col? "+col+" , text? "+text);
        switch (col){
            case 0:
                row2.setRow1Text(text);
                break;
            case 1:
                row2.setRow2Text(text);
                break;
            case 2:
                row2.setRow3Text(text);
                break;
            case 3:
                row2.setRow4Text(text);
                break;
        }
    }



    public void setRow3Text(final int col,String text){
        Log.d(TAG, "setRow1Text: col? "+col+" , text? "+text);
        switch (col){
            case 0:
                row3.setRow1Text(text);
                break;
            case 1:
                row3.setRow2Text(text);
                break;
            case 2:
                row3.setRow3Text(text);
                break;
            case 3:
                row3.setRow4Text(text);
                break;
        }
    }




    public void setRow4Text(final int col,String text){
        Log.d(TAG, "setRow1Text: col? "+col+" , text? "+text);
        switch (col){
            case 0:
                row4.setRow1Text(text);
                break;
            case 1:
                row4.setRow2Text(text);
                break;
            case 2:
                row4.setRow3Text(text);
                break;
            case 3:
                row4.setRow4Text(text);
                break;
        }
    }



    public void initTable(){
        initGenerateIDS();
        rowTitleResult = new RowTitleResult(getContext());
        rowTitleResult.setId(ID_ROW1);
        rowTitleResult.initRow();
        rowTitleResult.setRow1Text("Algoritem");
        rowTitleResult.setRow2Text("Solution find");
        rowTitleResult.setRow3Text("Iteration");
        rowTitleResult.setRow4Text("Path");
        addView(rowTitleResult);

        row1 = new RowResult(getContext());
        row1.setId(ID_ROW2);
        row1.initRow();
        row1.setRow1Text("BFS");
        row1.setRow4Text("Show");
        addView(row1);

        row2 = new RowResult(getContext());
        row2.setId(ID_ROW3);
        row2.initRow();
        row2.setRow1Text("DFS");
        row2.setRow4Text("Show");
        addView(row2);

        row3 = new RowResult(getContext());
        row3.setId(ID_ROW4);
        row3.initRow();
        row3.setRow1Text("IDFS");
        row3.setRow4Text("Show");
        addView(row3);


        row4 = new RowResult(getContext());
        row4.setId(ID_ROW5);
        row4.initRow();
        row4.setRow1Text("A*");
        row4.setRow4Text("Show");
        addView(row4);

        Log.d(TAG, "initTable: ");

    }


//    private void initPathButtons(){
//        Log.d(TAG, "initPathButtons:");
//        pathAStar = new Button(getContext());
//        pathAStar.setId(ID_ASTAR);
//        pathAStar.setTextSize(17);
//        pathAStar.setText("A*");
//
//        pathBFS = new Button(getContext());
//        pathBFS.setId(ID_BFS);
//        pathBFS.setTextSize(17);
//        pathBFS.setText("BFS");
//
//        pathDFS = new Button(getContext());
//        pathDFS.setId(ID_DFS);
//        pathDFS.setTextSize(17);
//        pathDFS.setText("DFS");
//
//        pathIDFS = new Button(getContext());
//        pathIDFS.setId(ID_IDFS);
//        pathIDFS.setTextSize(17);
//        pathIDFS.setText("IDFS");
//    }

    private void initGenerateIDS(){
        ID_ROW1   = UtilsView.generateViewId();
        ID_ROW2   = UtilsView.generateViewId();
        ID_ROW3   = UtilsView.generateViewId();
        ID_ROW4   = UtilsView.generateViewId();
        ID_ROW5   = UtilsView.generateViewId();
        Log.d(TAG, "initGenerateIDS:");
    }
}
