import java.util.*;

public class Code{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N;
        int[][] tp;
        int[] dp;
        int max;

        N = sc.nextInt();
        tp = new int[N][2];
        dp = new int[N+1];

        for(int i = 0; i < N; i++){
            tp[i][0] = sc.nextInt();
            tp[i][1] = sc.nextInt();
        }

        for(int i = N-1; i > -1; i--){
            if(i + tp[i][0] > N){
                if(i+1 < N){
                    dp[i] = dp[i+1];
                }
            }else{
                dp[i] = Math.max(tp[i][1]+dp[tp[i][0]+i], dp[i+1]);
            }
        }
        System.out.println(dp[0]);
    }
}