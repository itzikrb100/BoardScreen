package itzik.com.simulationscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import itzik.com.simulationscreen.board.Board;
import itzik.com.simulationscreen.board_view.BoardView;

public class SimulationScreen extends AppCompatActivity {


    private BoardView boardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation_screen);
        boardView = (BoardView)findViewById(R.id.board);
        final Board board = new Board(8,13);
        boardView.initView(board);
    }
}
