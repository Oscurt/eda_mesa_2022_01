import java.io.*;
import java.util.*;

public class CourseSched {
    static boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> set = new HashSet<>();
        for (int[] arr: prerequisites) {
            set.add(arr[0]);
            set.add(arr[1]);
        }
        List<Integer> sortedList = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> inDMap = new HashMap<>();
        for (int s: set) {
            map.put(s, new ArrayList<>());
            inDMap.put(s, 0);
        }
    
        for (int[] entry: prerequisites) {
            int a = entry[1];
            int b = entry[0];
            List<Integer> list = map.get(a);
            list.add(b);
        }
    
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> llll = entry.getValue();
            for (int lllll: llll) {
                inDMap.put(lllll, inDMap.getOrDefault(lllll, 0)+1);
            }
        }
    
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry: inDMap.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            int val = queue.poll();
            sortedList.add(val);
            List<Integer> ll = map.get(val);
            for (int iii: ll) {
                int degree = inDMap.get(iii);
                degree--;
                inDMap.put(iii, degree);
                if (degree == 0) {
                    queue.offer(iii);
                }
            }
        }
        if (sortedList.size() < set.size()) {
          return false;
        }
        return true;
    }

    public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      int len = in.nextInt();
      int cases = in.nextInt();
      int[][] grafo = new int[cases][2];
      for(int i=0;i<cases;i++){
        grafo[i][0] = in.nextInt();
        grafo[i][1] = in.nextInt();
      }
      System.out.println(canFinish(len,grafo));
    }
}