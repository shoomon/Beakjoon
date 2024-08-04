import java.util.Scanner;

public class Code11057 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N;
        long answer=0;
        long[][] dp;

        N = sc.nextInt();
        dp = new long[N+1][10];

        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int i = 1; i <= N; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k <= j; k++){
                    dp[i][j] += dp[i-1][k]%10007;
                }
            }
        }

        for(int i = 0; i < 10; i++){
            answer += dp[N][i]%10007;
        }

        System.out.println((answer+10007)%10007+"");
    }
}
