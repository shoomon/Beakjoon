//25.02.03
//설계: 5분
//구현: 14분
//11:26 11:31 11:45
//DP, 31*31, dp[r][c] = dp[r-1][c-1]+dp[r-1][c]
import java.util.*;

public class Code15489 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] dp;
        int R,C,W, answer=0;

        R = sc.nextInt();
        C = sc.nextInt();
        W = sc.nextInt();
        dp = new int[R+W][R+W];

        for(int i = 1; i < R+W; i++) dp[i][1] = dp[i][i] = 1;

        for(int i = 2; i < R+W; i++){
            for(int j = 1; j < i+1; j++) dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
        }

        for(int i = R; i < R+W; i++){
            for(int j = C; j < C+(i-R+1); j++) answer += dp[i][j];
        }

        System.out.println(answer);
    }
}
