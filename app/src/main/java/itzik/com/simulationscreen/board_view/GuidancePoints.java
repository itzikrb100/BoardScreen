package itzik.com.simulationscreen.board_view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import itzik.com.simulationscreen.R;
import itzik.com.simulationscreen.Utils.UtilsDisplay;
import itzik.com.simulationscreen.Utils.UtilsView;

/**
 * Created by itrzik on 22/07/2017.
 */

public class GuidancePoints extends RelativeLayout {


    public static final String TAG  = GuidancePoints.class.getSimpleName();


    private TextView textStart,textGoal,textAllowed,textForbidden;
    private ImageView start,goal,allowed,forbidden;


    private  int ID_START, ID_GOAL ,ID_ALLOWED,ID_FORBIDDEN,IMAGE_START,IMAGE_GOAL,IMAGE_ALLOWED,IMAGE_FORBIDDEN;

    public GuidancePoints(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GuidancePoints(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public GuidancePoints(Context context) {
        super(context);
    }



    public void initView(){
        Log.d(TAG, "initView:");
        initIDS();
        RelativeLayout.LayoutParams PARAM = null;



        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        //PARAM.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        PARAM.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        PARAM.addRule(RelativeLayout.CENTER_HORIZONTAL);
        start  = new ImageView(getContext());
        start.setId(IMAGE_START);
        start.setImageResource(R.drawable.start);
        addView(start,PARAM);
        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.addRule(RelativeLayout.RIGHT_OF,start.getId());
        PARAM.addRule(RelativeLayout.CENTER_HORIZONTAL);
        PARAM.setMargins(0,0,convertDp2Px(32f),0);
        textStart = new TextView(getContext());
        textStart.setId(ID_START);
        textStart.setTextSize(20);
        textStart.setText("Start");
        addView(textStart,PARAM);





        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.addRule(RelativeLayout.RIGHT_OF,textStart.getId());
        PARAM.addRule(RelativeLayout.CENTER_HORIZONTAL);
        goal  = new ImageView(getContext());
        goal.setId(IMAGE_GOAL);
        goal.setImageResource(R.drawable.goal);
        addView(goal,PARAM);
        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.addRule(RelativeLayout.RIGHT_OF,goal.getId());
        PARAM.addRule(RelativeLayout.CENTER_HORIZONTAL);
        PARAM.setMargins(0,0,convertDp2Px(32f),0);
        textGoal = new TextView(getContext());
        textGoal.setId(ID_GOAL);
        textGoal.setTextSize(20);
        textGoal.setText("Goal");
        addView(textGoal,PARAM);




        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.addRule(RelativeLayout.RIGHT_OF,textGoal.getId());
        PARAM.addRule(RelativeLayout.CENTER_HORIZONTAL);
        allowed  = new ImageView(getContext());
        allowed.setImageResource(R.drawable.allowed);
        allowed.setId(IMAGE_ALLOWED);
        addView(allowed,PARAM);
        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.addRule(RelativeLayout.RIGHT_OF,allowed.getId());
        PARAM.addRule(RelativeLayout.CENTER_HORIZONTAL);
        PARAM.setMargins(0,0,convertDp2Px(32f),0);
        textAllowed= new TextView(getContext());
        textAllowed.setId(ID_ALLOWED);
        textAllowed.setTextSize(20);
        textAllowed.setText("Allowed");
        addView(textAllowed,PARAM);



        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.addRule(RelativeLayout.RIGHT_OF,textAllowed.getId());
        PARAM.addRule(RelativeLayout.CENTER_HORIZONTAL);
        forbidden  = new ImageView(getContext());
        forbidden.setId(IMAGE_FORBIDDEN);
        forbidden.setImageResource(R.drawable.forbidden);
        addView(forbidden,PARAM);
        PARAM = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        PARAM.addRule(RelativeLayout.RIGHT_OF,forbidden.getId());
        PARAM.addRule(RelativeLayout.CENTER_HORIZONTAL);
        PARAM.setMargins(0,0,convertDp2Px(32f),0);
        textForbidden = new TextView(getContext());
        textForbidden.setId(ID_FORBIDDEN);
        textForbidden.setTextSize(18);
        textForbidden.setText("Forbidden");
        addView(textForbidden,PARAM);
    }


    private int convertDp2Px(float dp){
        return UtilsDisplay.convertDpScaleToPixelScale(getContext().getResources(),dp);
    }

    private void initIDS(){
        ID_START     = UtilsView.generateViewId();
        ID_GOAL      = UtilsView.generateViewId();
        ID_ALLOWED   = UtilsView.generateViewId();
        ID_FORBIDDEN = UtilsView.generateViewId();
        IMAGE_START  = UtilsView.generateViewId();
        IMAGE_GOAL   = UtilsView.generateViewId();
        IMAGE_ALLOWED = UtilsView.generateViewId();
        IMAGE_FORBIDDEN = UtilsView.generateViewId();
    }


}
