package itzik.com.simulationscreen.config_app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import itzik.com.simulationscreen.board.Board;

/**
 * Created by itzik on 30/07/2017.
 */

public class RobotNavigationApp extends Application {

    public static final String TAG = "RobotNavigationApp";

    private Board board;


    @Override
    public void onTerminate() {
        Log.d(TAG, "onTerminate:");
        super.onTerminate();
    }



    @Override
    public void onCreate() {
        super.onCreate();
        board = new Board(13,13);
        Log.d(TAG, "onCreate: board size :"+board.getSpaceBoard());
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        Log.d(TAG, "attachBaseContext:");
        super.attachBaseContext(newBase);
    }

    public Board getBoard(){
        Log.d(TAG, "getBoard:");
        return board;
    }
}
