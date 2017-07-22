package itzik.com.simulationscreen.board;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import itzik.com.simulationscreen.represent.Node;

/**
 * Created by itzik on 22/07/2017.
 */

public class PointState {


    public static final String TAG = "PointState";

    private Node node;
    private int color;


    public PointState(Node node){
        this.node = node;
        generateColor(node);
    }


    public void drawPoint(Canvas canvas,float x , float y,int rad){
        Log.d(TAG, "drawPoint:");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);
        canvas.drawCircle(x,y,rad,paint);
    }

     @Override
    public String toString(){
         String string = String.format("node? %s\n color? %s ",node,getRepresentColor(color));
         Log.d(TAG, "toString: "+string);
         return string;
    }


    public Node getRepresentPoint(){
        return node;
    }


    public int getColor(){
        return color;
    }


    private String getRepresentColor(final int color){
        String stringColor = "Non";
        switch (color){
            case Color.BLACK:
                stringColor = "BLACK";
                break;
            case Color.GREEN:
                stringColor = "GREEN";
                break;
            case Color.BLUE:
                stringColor = "BLUE";
                break;

            case Color.RED:
                stringColor = "RED";
                break;
        }

        return stringColor;
    }

    private void generateColor(final Node node){
        switch (node.getStatus()){
            case Allowed:
                this.color = Color.BLACK;
                break;

            case Goal:
                this.color = Color.GREEN;
                break;

            case Start:
                this.color = Color.BLUE;
                break;

            case Restricted:
                this.color = Color.RED;
                break;
        }
    }
}
