import java.util.*;
import java.io.*;

public class CountIsland{

static class Pair{
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

  private static final int[] row = { -1, -1, -1, 0, 1, 0, 1, 1 };
  private static final int[] col = { -1, 1, 0, -1, -1, 1, 0, 1 };

  public static boolean isSafe(int[][] mat, int x, int y,
              boolean[][] processed)
  {
    return (x >= 0) && (x < processed.length) &&
        (y >= 0) && (y < processed[0].length) &&
        (mat[x][y] == 1 && !processed[x][y]);
  }

  public static void BFS(int[][] mat, boolean[][] processed, int i, int j)
  {
    Queue<Pair> q = new ArrayDeque<>();
    q.add(new Pair(i, j));

    processed[i][j] = true;

    while (!q.isEmpty())
    {
      int x = q.peek().x;
      int y = q.peek().y;
      q.poll();

      for (int k = 0; k < 8; k++)
      {
        if (isSafe(mat, x + row[k], y + col[k], processed))
        {
          processed[x + row[k]][y + col[k]] = true;
          q.add(new Pair(x + row[k], y + col[k]));
        }
      }
    }
  }

  public static void main(String[] args)
  {
  Scanner in = new Scanner(System.in);
      int N = in.nextInt();
      int M = in.nextInt();
      int[][] grid = new int[N][M];
      for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
          grid[i][j] = in.nextInt();
        }
      }

    boolean[][] processed = new boolean[N][M];

    int island = 0;
    for (int i = 0; i < N; i++)
    {
      for (int j = 0; j < M; j++)
      {
        if (grid[i][j] == 1 && !processed[i][j])
        {
          BFS(grid, processed, i, j);
          island++;
        }
      }
    }

    System.out.println(island);
  }
}
