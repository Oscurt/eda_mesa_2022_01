import java.util.*;

public class CoinExchange {
    static int deno[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
    static int n = deno.length;
  
    static void findMin(int V){
        Vector<Integer> ans = new Vector<>();
  
        for (int i = n - 1; i >= 0; i--){
            while (V >= deno[i]) {
                V -= deno[i];
                ans.add(deno[i]);
            }
        }

        System.out.print(ans.size());
        
    }
  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        findMin(n);
    }
}