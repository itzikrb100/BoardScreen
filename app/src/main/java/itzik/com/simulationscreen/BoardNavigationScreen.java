package itzik.com.simulationscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Locale;

import itzik.com.simulationscreen.Utils.UtilsDisplay;
import itzik.com.simulationscreen.board.Board;
import itzik.com.simulationscreen.board_view.BoardView;
import itzik.com.simulationscreen.board_view.callbacks.OnBoardCallback;

public class BoardNavigationScreen extends AppCompatActivity {


    public static final String TAG = BoardNavigationScreen.class.getSimpleName();

    private BoardView boardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UtilsDisplay.updateLayoutDirectionByConfig(this, Locale.ENGLISH);
        setContentView(R.layout.activity_simulation_screen);

        boardView = (BoardView)findViewById(R.id.board);
        final Board board = new Board(8,13);
        boardView.initView(board, new OnBoardCallback() {
            @Override
            public void onResultClick() {
                Log.d(TAG, "onResultClick:");
                launchToResultScreen();
            }

            @Override
            public void onRunClick() {
                Log.d(TAG, "onRunClick:");
            }

            @Override
            public void onGenerateClick() {
                Log.d(TAG, "onGenerateClick:");
            }
        });


    }


    private void launchToResultScreen(){
        Log.d(TAG, "launchToResultScreen:");
        Intent launch = new Intent(this,ResultActivity.class);
        startActivity(launch);
    }
}
