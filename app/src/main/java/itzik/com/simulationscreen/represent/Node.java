package itzik.com.simulationscreen.represent;

import android.util.Log;

public class Node {


	    public static final String TAG = Node.class.getSimpleName();
		private NodeStatus Status;
		
		public Node(NodeStatus status) {
			Status = status;
		}
		public NodeStatus getStatus() {
			return Status;
		}
		public void setStatus(NodeStatus status) {
			Status = status;
		}


	     @Override
	    public String toString(){
			String string = String.format("status? %s",Status.toString());
			Log.d(TAG, "toString: "+string);
			return  string;
		}
}
