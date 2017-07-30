package itzik.com.simulationscreen.board_view.table;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import itzik.com.simulationscreen.Utils.UtilsDisplay;
import itzik.com.simulationscreen.Utils.UtilsView;
import itzik.com.simulationscreen.tasks.ResultProbSearch;

/**
 * Created by itzik on 23/07/2017.
 */

public class RowResult extends TableRow {

    public static final String TAG = "RowResult";


    private int ID_1_ROW,ID_2_ROW,ID_3_ROW,ID_4_ROW;
    private TextView text_1,text_2,text_3;
    private Button path;
    private ResultProbSearch solution;



    public RowResult(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RowResult(Context context) {
        super(context);
    }


    public void setRow1Text(final String text){
        text_1.setText(text);
    }

    public void setRow2Text(final String text){
        text_2.setText(text);
    }

    public void setRow3Text(final String text){
        text_3.setText(text);
    }

    public void setRow4Text(final String text){
        path.setText(text);
    }

    public void setPathEnable(boolean is){
        path.setEnabled(is);
    }

    public void setVisiblePath(int visible){
        path.setVisibility(visible);
    }


    public void setResultProbSearch(ResultProbSearch solution){
        this.solution = solution;
    }

    public void initRow(final RowResultCallback callback){
        initGenerateIDS();
        TableRow.LayoutParams PARAM = null;

        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.setMargins(0,0,convertDp2Px(25),0);
        text_1 = new TextView(getContext());
        text_1.setId(ID_1_ROW);
        text_1.setTextSize(15);
        addView(text_1,PARAM);


        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.setMargins(0,0,convertDp2Px(25),0);
        text_2 = new TextView(getContext());
        text_2.setId(ID_2_ROW);
        text_2.setTextSize(15);
        addView(text_2,PARAM);


        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.setMargins(0,0,convertDp2Px(25),0);
        text_3 = new TextView(getContext());
        text_3.setId(ID_3_ROW);
        text_3.setTextSize(15);
        addView(text_3,PARAM);

        path = new Button(getContext());
        path.setId(ID_4_ROW);
        path.setTextSize(17);
        path.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                   callback.onShowPath(text_1.getText().toString());
            }
        });
        path.setEnabled(false);
        addView(path);
        Log.d(TAG, "initRow:");
    }


    private int convertDp2Px(float dp){
        return UtilsDisplay.convertDpScaleToPixelScale(getContext().getResources(),dp);
    }

    private void initGenerateIDS(){
        ID_1_ROW = UtilsView.generateViewId();
        ID_2_ROW = UtilsView.generateViewId();
        ID_3_ROW = UtilsView.generateViewId();
        ID_4_ROW = UtilsView.generateViewId();
        Log.d(TAG, "initGenerateIDS:");
    }


    public interface RowResultCallback{
        void onShowPath(String algo);
    }
}
