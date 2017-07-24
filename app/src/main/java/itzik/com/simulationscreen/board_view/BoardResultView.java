package itzik.com.simulationscreen.board_view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import itzik.com.simulationscreen.Utils.UtilsDisplay;
import itzik.com.simulationscreen.Utils.UtilsView;
import itzik.com.simulationscreen.board_view.table.TableResult;

/**
 * Created by itzik on 23/07/2017.
 */

public class BoardResultView extends RelativeLayout {


    public static final String TAG = "BoardResultView";



    private int ID_TITLE,ID_TABLE;

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



    public void initView(){
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
        tableResult.initTable();
        addView(tableResult,param);

        Log.d(TAG, "initView:");
    }




    private void initGenerateIDS(){
        ID_TITLE   = UtilsView.generateViewId();
        ID_TABLE   = UtilsView.generateViewId();
        Log.d(TAG, "initGenerateIDS: title id? "+ID_TITLE+" , Table id? "+ID_TABLE);
    }


    private int convertDp2Px(float dp){
        return UtilsDisplay.convertDpScaleToPixelScale(getContext().getResources(),dp);
    }


}
