package itzik.com.simulationscreen.board;

import android.util.Log;

/**
 * Created by itzik on 22/07/2017.
 */

public class Board {

    public static final String TAG = "Board";


    private SpaceBoard space;


    public Board(int sizeRow,int sizeCol){
        Log.d(TAG, "Board: row? "+sizeCol+" , size col? "+sizeCol);
        initBoard(sizeRow,sizeCol);
    }



    public SpaceBoard getSpaceBoard(){
        return space;
    }


    private void initBoard(int sizeR,int sizeC){
        Log.d(TAG, "initBoard:");
        space = new SpaceBoard(sizeR,sizeC);
    }
}
