package itzik.com.simulationscreen.tasks;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;

import java.util.ArrayList;

import itzik.com.simulationscreen.represent.search_algoritems.AStar;
import itzik.com.simulationscreen.represent.search_algoritems.BFS;
import itzik.com.simulationscreen.represent.search_algoritems.DFS;

/**
 * Created by itzik on 26/07/2017.
 */

public class PerformsProbSearch extends AsyncTask<TaskInfo,Void,SparseArray<ResultProbSearch>> {

    public static final String TAG = "PerformsProblemsSearch";

    private PerformProbSearchCallback callback;

    public PerformsProbSearch(PerformProbSearchCallback callback){
        Log.d(TAG, "PerformsProblemsSearch:");
        this.callback = callback;
    }


    @Override
    protected void onPostExecute(final SparseArray<ResultProbSearch> results ) {
        super.onPostExecute(results);
        Log.d(TAG, "onPostExecute: size? "+results.size());
        new  Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "onPostExecute : return callback result");
                callback.onEndTask(results);
            }
        });
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute:");
    }

    @Override
    protected SparseArray<ResultProbSearch> doInBackground(TaskInfo... params) {
        final TaskInfo info = params[0];
        ArrayList<PointPath> path = null;
        ResultProbSearch temp;
        int find;
        Log.d(TAG, "doInBackground: info task ? "+info);
        final SparseArray<ResultProbSearch> results = new SparseArray<>();
        init(results,info.getSizePath());

         // bfs
        temp = results.get(TYPE_ALGO.BFS.ordinal());
        path = temp.getPath();
        find = BFS.performBFS(info.getSearchSpace(),path,info.getIterations());
        Log.d(TAG, "doInBackground: BFS find? "+find);
        temp.setSolutionIterations(find);
        temp.setIterations(info.getIterations());


        //dfs
        temp = results.get(TYPE_ALGO.DFS.ordinal());
        path = temp.getPath();
        find = DFS.performDFS(info.getSearchSpace(),path,info.getIterations());
        Log.d(TAG, "doInBackground: DFS find? "+find);
        temp.setSolutionIterations(find);
        temp.setIterations(info.getIterations());



        //Astar
        temp = results.get(TYPE_ALGO.A_STAR.ordinal());
        path = temp.getPath();
        find = AStar.performAStar(info.getSearchSpace(),path,info.getIterations());
        Log.d(TAG, "doInBackground: A_STAR find? "+find);
        temp.setSolutionIterations(find);
        temp.setIterations(info.getIterations());

        return results;
    }




    private void init(SparseArray<ResultProbSearch> resultsProbSearch ,int sizePath){
        TYPE_ALGO[] algos = TYPE_ALGO.values();
        for(TYPE_ALGO type : algos){
            Log.d(TAG, "init: type? "+type);
            ResultProbSearch result = new ResultProbSearch(sizePath);
            result.setType_algo(type.toString());
            resultsProbSearch.append(type.ordinal(),result);
        }
        Log.d(TAG, "init:");
    }



    public interface PerformProbSearchCallback{
        void onEndTask(SparseArray<ResultProbSearch> results);
    }
}
