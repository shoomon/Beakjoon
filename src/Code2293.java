import java.util.Scanner;

public class Code2293 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, K;
        int[] coin, dp;

        N = sc.nextInt();
        K = sc.nextInt();
        coin = new int[N];
        dp = new int[K+1];

        for(int i = 0; i < N; i++){
            coin[i] = sc.nextInt();
        }

        dp[0] = 1;
        for(int i = 0; i < N; i++){
            for(int j = coin[i]; j < K+1; j++){
                dp[j] += dp[j-coin[i]];
            }
        }
        System.out.println(dp[K]);
    }
}
