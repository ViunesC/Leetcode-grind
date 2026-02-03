import Medium.*;
import Easy.*;
import Hard.*;
import Misc.Graph.BFS;
import Misc.Graph.DFS;
import Misc.Graph.Graph;
import Misc.Graph.ListGraph;

public class Main {
    public static void main(String[] args) {
        Graph mygraph = new ListGraph(new int[][]{{1,2},{0,2},{0,1,3,4},{2},{2}});
//        DFS dfsDriver = new DFS(mygraph);
//
//        dfsDriver.search(0,4);
        BFS bfsDriver = new BFS(mygraph);
        bfsDriver.search(0);
    }
}