package itzik.com.simulationscreen.tasks;


import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by itzik on 27/07/2017.
 */

public class PointPath implements Parcelable {


    public static String TAG = "PointPath";

    int row,col;


    public PointPath(Parcel in){
        readFromParcel(in);
    }

    public PointPath(){
        row = -1 ;
        col = -1;
    }




    public void setRow(int row){
        this.row = row;
    }

    public void setCol(int col){
        this.col = col;
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(row);
        dest.writeInt(col);
        Log.d(TAG,"writeToParcel: ");
    }


    private void readFromParcel(Parcel in) {

        // We just need to read back each
        // field in the order that it was
        // written to the parcel
        this.row = in.readInt();
        this.col = in.readInt();
        Log.d(TAG,String.format("readFromParcel: row ? %d ? \ncol ? %d \n"
                ,row,col));
    }



    public static final Creator<PointPath> CREATOR = new Creator<PointPath>() {
        @Override
        public PointPath createFromParcel(Parcel in) {
            return new PointPath(in);
        }

        @Override
        public PointPath[] newArray(int size) {
            return new PointPath[size];
        }
    };
}
