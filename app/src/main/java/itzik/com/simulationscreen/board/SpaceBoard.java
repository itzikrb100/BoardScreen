package itzik.com.simulationscreen.board;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
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


    public void generateNewSpace(final SpaceBoardCallback callback){
        Log.d(TAG, "generateNewSpace:");
        performGenerateSpace(callback);
    }

    private void initSpace(int row,int col){
        Log.d(TAG, "initSpace: row? "+row+" , col? "+col);
        searchSpace = new SearchSpace(row,col);
    }

    private void performGenerateSpace(final SpaceBoardCallback callback){
        Log.d(TAG, "performGenerateSpace: ");
        new AsyncTask<SearchSpace,Void,SearchSpace>(){
            @Override
            protected SearchSpace doInBackground(SearchSpace... params) {
                SearchSpace searchSpace = params[0];
                searchSpace.generate();
                points = new PointState[searchSpace.getRows()][searchSpace.getColumns()];
                Node[][] nodes = searchSpace.getSpace();
                for(int i = 0 ; i <searchSpace.getRows() ; i++){
                    for(int j = 0 ; j<searchSpace.getColumns() ; j++){
                        points[i][j] = new  PointState(nodes[i][j]);
                    }
                }
                Log.d(TAG, "redrawPointsGeneration: doInBackground generateNewSpace:");
                return searchSpace;
            }

            @Override
            protected void onPostExecute(final SearchSpace searchSpace) {
                super.onPostExecute(searchSpace);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        callback.endGenerate(SpaceBoard.this);
                    }
                });
            }
        }.execute(searchSpace);

    }


    public interface SpaceBoardCallback{
        void endGenerate(SpaceBoard spaceBoard);
    }
}
