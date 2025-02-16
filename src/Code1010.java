//25.02.05
//뽑기만 하면 순서는 정해진다. 조합 경우의 수 생각을 못 함
import java.util.*;

public class Code1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, N, M, answer;
        int[][] dp = new int[31][31];

        for(int i = 0; i < 31; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for(int i = 1; i < 31; i++){
            for(int j = 1; j < i; j++) dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
        }

//        for(int i = 0; i < 30; i++) System.out.println(Arrays.toString(dp[i]));

        T = sc.nextInt();

        for(int t = 0; t < T; t++){
            N = sc.nextInt();
            M = sc.nextInt();
            System.out.println(dp[M][N]);
        }
    }
}
