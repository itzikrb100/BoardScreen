package itzik.com.simulationscreen.board;

import android.util.Log;

import itzik.com.simulationscreen.represent.Node;
import itzik.com.simulationscreen.represent.SearchSpace;

/**
 * Created by itzik on 22/07/2017.
 */

public class SpaceBoard {


    public static final String TAG = "SpaceBoard";

    private SearchSpace searchSpace;
    private PointState [][] points;


    public SpaceBoard(final int row,final int col){
          initSpace(row,col);
    }


    public PointState [][] getPoints(){
        Log.d(TAG, "getPoints:");
        return points;
    }



    public SearchSpace getSearchSpace(){
        Log.d(TAG, "getSearchSpace: ");
        return searchSpace;
    }


    private void initSpace(int row,int col){
        Log.d(TAG, "initSpace: row? "+row+" , col? "+col);
        searchSpace = new SearchSpace(row,col);
        points = new PointState[row][col];
        Node[][] nodes = searchSpace.getSpace();
        for(int i = 0 ; i <searchSpace.getRows()-1 ; i++){
            for(int j = 0 ; j<searchSpace.getColumns()-1 ; j++){
                points[i][j] = new  PointState(nodes[i][j]);
            }
        }
    }
}
