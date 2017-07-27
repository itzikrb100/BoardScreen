package itzik.com.simulationscreen.tasks;

import itzik.com.simulationscreen.represent.SearchSpace;

/**
 * Created by itzik on 26/07/2017.
 */

public class TaskInfo {

    public static final String TAG = TaskInfo.class.getSimpleName();

    private SearchSpace searchSpace;
    private int iterations;
    private int sizePath;

    public TaskInfo(SearchSpace searchSpace,int sizePah,int iterations){
        this.searchSpace = searchSpace;
        this.sizePath    = sizePah;
        this.iterations  = iterations;
    }




    @Override
    public String toString() {
        String string = String.format("info : iteration? %d\n siz path? %s\n search space?\n %s"
                            ,iterations,sizePath,searchSpace);
        return string;
    }

    public SearchSpace getSearchSpace(){
        return  searchSpace;
    }


    public int getIterations(){
        return iterations;
    }

    public int getSizePath(){
        return sizePath;
    }
}
