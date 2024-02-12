import java.util.*;

public class Code {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, count=0;
        int[] children, dp;

        N = sc.nextInt();
        children = new int[N+1];
        dp = new int[N+1];
        for(int i= 1; i < N+1; i++){
            children[i] = sc.nextInt();
        }

        for(int i = 1; i < N+1; i++){
            for(int j = 0; j < i; j++){
                if(children[j] < children[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                count = Math.max(dp[i], count);
            }
        }

        System.out.println(N-count);
    }
}
