package itzik.com.simulationscreen.board_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;

import java.util.ArrayList;

import itzik.com.simulationscreen.board.SpaceBoard;
import itzik.com.simulationscreen.tasks.PointPath;

/**
 * Created by itzik on 28/07/2017.
 */

public class GenerationPathView extends GenerationPointsView {


    private ArrayList<PointPath> path;


    public GenerationPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GenerationPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public GenerationPathView(Context context) {
        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPath(canvas);
    }


    public void redrawPathGeneration(final SpaceBoard space, ArrayList<PointPath> path){
        Log.d(TAG, "redrawPointsGeneration:");
        redrawPointsNoneGeneration(space);
        this.path = path;
    }


    private void drawPath(Canvas canvas){
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(3);
        paint.setColor(Color.GRAY);

        for(int i = 0 ; i<this.path.size() ; i++){
            Log.d(TAG, "drawPath: i? "+i + " , size? "+this.path.size());
            if(i<this.path.size()-1) {
                 PointPath p1 = this.path.get(i);
                 PointPath p2 = this.path.get(i + 1);
                 Log.d(TAG, "drawPath: row1 ? "+p1.getRow()+" , row2? "+p2.getRow()+", index? "+i);
                 Log.d(TAG, "drawPath: col1? "+p2.getCol()+" , col2? "+p2.getCol());
                 final float x1 = points[p1.getRow()][p1.getCol()].getX();
                 final float y1 = points[p1.getRow()][p1.getCol()].getY();
                 final float x2 = points[p2.getRow()][p2.getCol()].getX();
                 final float y2 = points[p2.getRow()][p2.getCol()].getY();
                // canvas.drawLine(p1.getRow(), p1.getCol(), p2.getRow(), p2.getCol(), paint);
                canvas.drawLine(x1, y1, x2, y2, paint);
            }
        }
    }
}
