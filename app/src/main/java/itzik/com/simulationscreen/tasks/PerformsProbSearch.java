package itzik.com.simulationscreen.tasks;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.widget.ProgressBar;

import java.util.ArrayList;

import itzik.com.simulationscreen.represent.search_algoritems.AStar;
import itzik.com.simulationscreen.represent.search_algoritems.BFS;
import itzik.com.simulationscreen.represent.search_algoritems.DFS;
import itzik.com.simulationscreen.represent.search_algoritems.HeursticDistanceToGoal;

/**
 * Created by itzik on 26/07/2017.
 */

public class PerformsProbSearch extends AsyncTask<TaskInfo,Integer,SparseArray<ResultProbSearch>> {

    public static final String TAG = "PerformsProblemsSearch";

    private PerformProbSearchCallback callback;
    private ProgressBar progressBar;


    public PerformsProbSearch(ProgressBar progressBar,PerformProbSearchCallback callback){
        Log.d(TAG, "PerformsProblemsSearch:");
        this.callback = callback;
        this.progressBar = progressBar;
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
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int currentProgress = values[0];
        Log.d(TAG, "onProgressUpdate: progress? "+currentProgress);
        progressBar.setProgress(currentProgress);
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
        int sum_progress = 0 ;
        final int progress = 100/TYPE_ALGO.values().length;
        Log.d(TAG, "doInBackground: progess? "+progress);
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
        sum_progress+=progress;
        publishProgress(sum_progress);

        //dfs
        temp = results.get(TYPE_ALGO.DFS.ordinal());
        path = temp.getPath();
        find = DFS.performDFS(info.getSearchSpace(),path,info.getIterations());
        Log.d(TAG, "doInBackground: DFS find? "+find);
        temp.setSolutionIterations(find);
        temp.setIterations(info.getIterations());
        sum_progress+=progress;
        publishProgress(sum_progress);


        //Astar
        temp = results.get(TYPE_ALGO.A_STAR.ordinal());
        path = temp.getPath();
        find = AStar.performAStar(info.getSearchSpace(),path,info.getIterations());
        Log.d(TAG, "doInBackground: A_STAR find? "+find);
        temp.setSolutionIterations(find);
        temp.setIterations(info.getIterations());
        sum_progress+=progress;
        publishProgress(sum_progress);


        //Astar HeursticDistanceToGoal ,
        temp = results.get(TYPE_ALGO.HeursticDistanceToGoal.ordinal());
        path = temp.getPath();
        find = HeursticDistanceToGoal.performHeursticDistanceToGoal(info.getSearchSpace()
                ,path,info.getIterations());
        Log.d(TAG, "doInBackground: A_STAR ,HeursticDistanceToGoal find? "+find);
        temp.setSolutionIterations(find);
        temp.setIterations(info.getIterations());
        sum_progress+= 100 - sum_progress;
        publishProgress(sum_progress);

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
