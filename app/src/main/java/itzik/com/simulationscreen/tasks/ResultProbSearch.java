package itzik.com.simulationscreen.tasks;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by itzik on 26/07/2017.
 */

public class ResultProbSearch implements Parcelable {

    public static final String TAG = "ResultProbSearch";

    private int solutionIterations;
    private int iterations;
    private String type_algo;
    private ArrayList<PointPath>path; //int [][]path;



    public ResultProbSearch(Parcel in) {
        initPath();
        readFromParcel(in);
    }


    public ResultProbSearch(int row){
        solutionIterations = -1;
        iterations = 0;
        type_algo = null;
        initPath();
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.d(TAG, "writeToParcel: flag? "+flags);
        dest.writeInt(solutionIterations);
        dest.writeInt(iterations);
        dest.writeString(type_algo);
        dest.writeTypedList(path);
    }


    public void setType_algo(String type){
        this.type_algo = type;
    }

    public void setIterations(int iterations){
        this.iterations = iterations;
    }

    public void setSolutionIterations(final int iterations){
        this.solutionIterations = iterations;
    }


    public void setPath(ArrayList<PointPath> path){
        this.path = path;
    }

    public String getType_algo(){
       return this.type_algo;
   }


    public int getIterations(){
        return iterations;
    }

    public boolean isFind(){
        if(solutionIterations!=-1){
            return true;
        }else{
            return false;
        }
    }


    public ArrayList<PointPath> getPath(){
        return this.path;
    }

    public int getSolutionIterations(){
        return solutionIterations;
    }


    private void  readFromParcel(Parcel in) {

        // We just need to read back each
        // field in the order that it was
        // written to the parcel
        this.solutionIterations = in.readInt();
        this.iterations = in.readInt();
        this.type_algo = in.readString();
        in.readTypedList(this.path,PointPath.CREATOR);
        Log.d(TAG,String.format("readFromParcel: solutionIt ? %d ? \nTYPE_ALGO ? %s \n"
                ,solutionIterations,type_algo));
    }

    private void initPath(){
        Log.d(TAG, "initPath: row? ");
        path = new ArrayList<>();
//        path = new int [row][2];
//        for(int  i = 0 ;i<path.length ; i++){
//            for(int j = 0 ; j<path[0].length ; j++){
//                path[i][j] = -1;
//            }
//        }
    }



    public static final Creator<ResultProbSearch> CREATOR = new Creator<ResultProbSearch>() {
        @Override
        public ResultProbSearch createFromParcel(Parcel in) {
            return new ResultProbSearch(in);
        }

        @Override
        public ResultProbSearch[] newArray(int size) {
            return new ResultProbSearch[size];
        }
    };

}
