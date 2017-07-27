package itzik.com.simulationscreen.represent;

import itzik.com.simulationscreen.represent.search_algoritems.BFS;
import itzik.com.simulationscreen.represent.search_algoritems.DFS;

public class Tester {
	
	public static void main(String args[])
	{
		SearchSpace s = new SearchSpace(10,10);
		s.generate();
		System.out.println(s.toString());
		
		int rows = s.getspaceSize();
		int[][] path = new int[rows][2];
		for(int i=0;i<path.length;i++)
			for(int j=0;j<path[0].length;j++)
				path[i][j] = -1;
		
		System.out.println("========== com.itzikdev.BFS ===========");
		int solved = BFS.performBFS(s,null /*path*/,1000000);
		if(solved == -1)
			System.out.println("Not solved");
		else
			System.out.println("Solved in "+solved+" iterations");
		
		System.out.println("Path:");
		for(int i=path.length-1;i>=0;i--)
		{
			if(path[i][0]==-1)
				continue;
			else
				System.out.println("("+path[i][0]+","+path[i][1]+")");
		}
		
		System.out.println("\n\n========== com.itzikdev.DFS ===========");
		for(int i=0;i<path.length;i++)
			for(int j=0;j<path[0].length;j++)
				path[i][j] = -1;
		
		solved = DFS.performDFS(s, null/*path*/,1000000);
		if(solved == -1)
			System.out.println("Not solved");
		else
			System.out.println("Solved in "+solved+" iterations");
		
		System.out.println("Path:");
		for(int i=path.length-1;i>=0;i--)
		{
			if(path[i][0]==-1)
				continue;
			else
				System.out.println("("+path[i][0]+","+path[i][1]+")");
		}
	}
}
