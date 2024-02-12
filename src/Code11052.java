import java.io.*;
import java.util.*;

public class Code11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N;
        int[] p, dp;

        N = Integer.parseInt(br.readLine());
        p = new int[N+1];
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            p[i+1] = Integer.parseInt(st.nextToken());
        }
        dp[1] = p[1];
        for(int i = 2; i <= N; i++){
            dp[i] = p[i];
            for(int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i-j]+p[j], dp[i]);
            }
        }

        bw.write(dp[N]+"");
        br.close();
        bw.close();
    }
}
