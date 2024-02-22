import java.util.Scanner;

public class Code1912 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N,  max=Integer.MIN_VALUE;
        int[] seq, dp;

        N = sc.nextInt();
        seq = new int[N+1];
        dp = new int[N+1];

        for(int i = 1; i < N+1; i++){
            seq[i] = sc.nextInt();
            dp[i] = dp[i-1] + seq[i];

            if(dp[i] < seq[i]){
                dp[i] = seq[i];
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max+"");

    }
}
