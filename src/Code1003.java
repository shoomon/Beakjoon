//25.02.05
//설계: 3분
//구현: 12분
//09:14 09:17 09:29
//DP
import java.io.*;

public class Code1003 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()), N;
        int[][] dp = new int[41][2];

        dp[0][0] = dp[1][1] = 1;

        for(int i = 2; i < 41; i++){
            dp[i][0] = dp[i-1][0]+dp[i-2][0];
            dp[i][1] = dp[i-1][1]+dp[i-2][1];
        }

//        for(int i = 0; i < 41; i++) System.out.print(dp[i][0]+" ");
//        System.out.println();
//        for(int i = 0; i < 41; i++) System.out.print(dp[i][1]+" ");

        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            bw.write(dp[N][0]+" "+dp[N][1]+"\n");
        }
        br.close();
        bw.close();
    }
}
