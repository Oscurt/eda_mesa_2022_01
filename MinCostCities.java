import java.util.*;
 
public class MinCostCities{
     
    static int minnode(int n, int keyval[], boolean mstset[]){
        int mini = Integer.MAX_VALUE;
        int mini_index = 0;
        
        for(int i = 0; i < n; i++){
            if (mstset[i] == false && keyval[i] < mini){
                mini = keyval[i];
                mini_index = i;
            }
        }
        return mini_index;
    }
 
    static void findcost(int n, int city[][]){
        
        int parent[] = new int[n];
        
        int keyval[] = new int[n];
        
        boolean mstset[] = new boolean[n];
    
        for(int i = 0; i < n; i++){
            keyval[i] = Integer.MAX_VALUE;
            mstset[i] = false;
        }
    
        parent[0] = -1;
        keyval[0] = 0;
    
        for(int i = 0; i < n - 1; i++){
            
            int u = minnode(n, keyval, mstset);
        
            mstset[u] = true;
        
            for(int v = 0; v < n; v++){
                if (city[u][v] > 0 && mstset[v] == false && city[u][v] < keyval[v]){
                    keyval[v] = city[u][v];
                    parent[v] = u;
                }
            }
        }
    
        int cost = 0;
        for(int i = 1; i < n; i++) cost += city[parent[i]][i];
            
        System.out.println(cost);
    }
 
    public static void main(String args[]){
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

        findcost(V, grid);    
        
    }
}