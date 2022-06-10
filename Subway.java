import java.util.*;
import java.io.*;
 
public class Subway {
    static final int NO_PARENT = -1;

    static void dijkstra(int[][] adjacencyMatrix, int startVertex, int targetVertex){
        int nVertices = adjacencyMatrix[0].length;
 
        int[] shortestDistances = new int[nVertices];
 
        boolean[] added = new boolean[nVertices];
 
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++){
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
         
        shortestDistances[startVertex] = 0;
 
        int[] parents = new int[nVertices];
 
        parents[startVertex] = NO_PARENT;
 
        for (int i = 1; i < nVertices; i++){
 
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++){
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance){
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }
 
            added[nearestVertex] = true;
 
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++){
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];
                 
                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])){
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }
 
        printPath(targetVertex, parents);
    }
 
    static void printPath(int currentVertex, int[] parents){
        if (currentVertex == NO_PARENT){
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }
 
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int E = in.nextInt();
        int[][] grid = new int[V][V];
        for(int i=0;i<E;i++){
            int src = in.nextInt();
            int dest = in.nextInt();
            grid[src][dest] = in.nextInt();
            grid[dest][src] = grid[src][dest];
        }

        int A = in.nextInt();
        int B = in.nextInt();

        dijkstra(grid, A, B);
    }
}