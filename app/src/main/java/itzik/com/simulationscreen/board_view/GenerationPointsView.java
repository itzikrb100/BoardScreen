package itzik.com.simulationscreen.board_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import itzik.com.simulationscreen.R;
import itzik.com.simulationscreen.Utils.UtilsDisplay;
import itzik.com.simulationscreen.board.PointState;
import itzik.com.simulationscreen.board.SpaceBoard;

/**
 * Created by itzik on 22/07/2017.
 */

public class GenerationPointsView extends View {


    public static final String TAG = GenerationPointsView.class.getSimpleName();

    private int row,col,spaceSize;
    private PointState [][] points;

    public GenerationPointsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public GenerationPointsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public GenerationPointsView(Context context) {
        super(context);
    }


    public void initView(){
        //points = new PointState[0][0];
        final Point screenSize = UtilsDisplay.getScreenSizeVars(getContext());
        int w = getWidth();//(int)(screenSize.x *0.7f);
        int h = getHeight();//(int)(screenSize.y*0.9f);
        Log.d(TAG, String.format("initView: w? %d , h? %s",w,h));
        setBackgroundResource(R.drawable.frame_fragment);


    }


    public void redrawPointsGeneration(final SpaceBoard space){

        space.generateNewSpace(new SpaceBoard.SpaceBoardCallback() {
            @Override
            public void endGenerate(SpaceBoard spaceBoard) {
                Log.d(TAG, "redrawPointsGeneration: endGenerate: ");
                points = spaceBoard.getPoints();
                row = spaceBoard.getSearchSpace().getRows();
                col = spaceBoard.getSearchSpace().getColumns();
                spaceSize = spaceBoard.getSearchSpace().getspaceSize();
                Log.d(TAG, "redrawPointsGeneration: row? "+row);
                Log.d(TAG, "redrawPointsGeneration: col ? "+col);
                invalidate();
            }
        });

        Log.d(TAG, "redrawPointsGeneration:");
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawsPointsView(canvas);
    }


    private void drawsPointsView(Canvas canvas){

        if(points == null)
            return;

        int h = getHeight();
        int w = getWidth();
        final float spaceRaw = h/row;
        final float spaceCol = w/col;
        Log.d(TAG, String.format("drawsPointsView: h? %d\n w? %d\n spaceRaw? %f\n spaceCol? %f",h,
                                     w,spaceRaw,spaceCol));
        int sum_col = convertDp2Px(9f);
        int sum_raw = convertDp2Px(9f);
        for(int i = 0 ;  i<row ; i++){
            for(int j = 0 ; j<col ; j++){
                PointState point = points[i][j];
                Log.d(TAG, "drawsPointsView: point? "+point+" ( x? "+(sum_raw)+" , y? "+sum_col+" )");
                point.drawPoint(canvas,sum_raw,sum_col,convertDp2Px(6f));
                sum_raw+=spaceCol;
                //point.drawPoint(canvas,);
                //canvas.drawCircle(0,0,convertDp2Px(4),);
            }
            sum_raw = convertDp2Px(9f);
            sum_col += spaceRaw;

        }

    }


    private int convertDp2Px(float dp){
        return UtilsDisplay.convertDpScaleToPixelScale(getContext().getResources(),dp);
    }
}
