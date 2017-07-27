package itzik.com.simulationscreen.tasks;

/**
 * Created by itzik on 26/07/2017.
 */

public enum TYPE_ALGO {


    DFS{
        public String toString() {
            return " DFS";
        }
    },
    BFS{
        public String toString() {
            return "BFS";
        }
    },
    IDFS{
        public String toString() {
            return "BFS";
        }
    },
    A_STAR{
        public String toString() {
            return "A*";
        }
    }
}
