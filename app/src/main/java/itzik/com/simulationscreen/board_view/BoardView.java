package itzik.com.simulationscreen.board_view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import itzik.com.simulationscreen.R;
import itzik.com.simulationscreen.Utils.UtilsDisplay;
import itzik.com.simulationscreen.Utils.UtilsView;
import itzik.com.simulationscreen.board.Board;

/**
 * Created by itzik on 22/07/2017.
 */

public class BoardView extends RelativeLayout {



    public static final String TAG  = "BoardView";


    private int ID_GUIDANCE,ID_GENERATE,ID_TEXT_LIMIT,ID_EDIT_ITRER,ID_RUN,ID_RESULT,ID_GENERATION_POINTS;

    private Button generateButton,runButton,resultButton;
    private TextView  textIteration;
    private EditText  editIteration;
    private GuidancePoints guidancePoints;
    private GenerationPointsView generationPoints;
    private Board board;




    public BoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public BoardView(Context context) {
        super(context);
    }


    public void initView(Board b){
        Log.d(TAG, "initView:");
        this.board = b;
        RelativeLayout.LayoutParams PARAM = null;
        initGenerateIDS();
        setBackgroundResource(R.drawable.frame_fragment);
        Point sizeScreen = UtilsDisplay.getScreenSizeVars(getContext());
        PARAM = new LayoutParams((int)(sizeScreen.x*0.7f),
                                               ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        PARAM.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        guidancePoints = new GuidancePoints(getContext());
       // guidancePoints.setBackgroundColor(Color.GRAY);
        guidancePoints.setId(ID_GUIDANCE);
        guidancePoints.initView();
        addView(guidancePoints,PARAM);



        PARAM = new LayoutParams((int)(sizeScreen.x*0.7f),(int)(sizeScreen.y*0.9f));
        PARAM.addRule(BELOW,guidancePoints.getId());
        PARAM.addRule(ALIGN_LEFT,guidancePoints.getId());
        PARAM.addRule(ALIGN_RIGHT,guidancePoints.getId());
        generationPoints = new GenerationPointsView(getContext());
        generationPoints.setId(ID_GENERATION_POINTS);
        generationPoints.initView();
        addView(generationPoints,PARAM);


        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                   ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.addRule(ALIGN_PARENT_TOP);
        PARAM.addRule(ALIGN_PARENT_LEFT);
        PARAM.setMargins(0,convertDp2Px(35),0,0);
        generateButton = new Button(getContext());
        generateButton.setId(ID_GENERATE);
        generateButton.setTextSize(18);
        generateButton.setText("Generate");
        generateButton.setBackground(getContext().getResources().getDrawable(R.drawable.grey_button));
        generateButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                generationPoints.redrawPointsGeneration(board.getSpaceBoard());
            }
        });
        addView(generateButton,PARAM);


        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.addRule(ALIGN_PARENT_LEFT);
        PARAM.addRule(BELOW,generateButton.getId());
        PARAM.addRule(ALIGN_LEFT,generateButton.getId());
        PARAM.addRule(ALIGN_RIGHT,generateButton.getId());
        PARAM.setMargins(0,convertDp2Px(40),0,0);
        textIteration = new TextView(getContext());
        textIteration.setId(ID_TEXT_LIMIT);
        textIteration.setTextSize(15);
        textIteration.setText("Max iterations:");
        addView(textIteration,PARAM);


        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.addRule(ALIGN_PARENT_LEFT);
        PARAM.addRule(BELOW,textIteration.getId());
        PARAM.addRule(ALIGN_LEFT,textIteration.getId());
        PARAM.addRule(ALIGN_RIGHT,textIteration.getId());
        editIteration = new EditText(getContext());
        editIteration.setId(ID_EDIT_ITRER);
        editIteration.setTextSize(15);
        editIteration.setBackgroundResource(R.drawable.frame_edite_text);
        addView(editIteration,PARAM);



        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.addRule(ALIGN_PARENT_LEFT);
        PARAM.addRule(BELOW,editIteration.getId());
        PARAM.addRule(ALIGN_LEFT,editIteration.getId());
        PARAM.addRule(ALIGN_RIGHT,editIteration.getId());
        PARAM.setMargins(0,convertDp2Px(12),0,0);
        runButton = new Button(getContext());
        runButton.setId(ID_RUN);
        runButton.setTextSize(18);
        runButton.setText("Run");
        runButton.setBackground(getContext().getResources().getDrawable(R.drawable.grey_button));
        addView(runButton,PARAM);


        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.addRule(ALIGN_PARENT_LEFT);
        PARAM.addRule(BELOW,runButton.getId());
        PARAM.addRule(ALIGN_LEFT,runButton.getId());
        PARAM.addRule(ALIGN_RIGHT,runButton.getId());
        PARAM.setMargins(0,convertDp2Px(12),0,0);
        resultButton = new Button(getContext());
        resultButton.setId(ID_RESULT);
        resultButton.setTextSize(18);
        resultButton.setText("Result");
        resultButton.setBackground(getContext().getResources().getDrawable(R.drawable.grey_button));
        addView(resultButton,PARAM);

    }


    private int convertDp2Px(float dp){
        return UtilsDisplay.convertDpScaleToPixelScale(getContext().getResources(),dp);
    }

    private void initGenerateIDS(){
        ID_GUIDANCE   = UtilsView.generateViewId();
        ID_EDIT_ITRER = UtilsView.generateViewId();
        ID_GENERATE   = UtilsView.generateViewId();
        ID_RESULT     = UtilsView.generateViewId();
        ID_RUN        = UtilsView.generateViewId();
        ID_TEXT_LIMIT = UtilsView.generateViewId();
        ID_GENERATION_POINTS = UtilsView.generateViewId();
    }
}
