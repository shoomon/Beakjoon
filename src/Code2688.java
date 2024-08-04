import java.io.*;

public class Code2688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T, n;
        long answer=-1;
        long[][] dp = new long[65][10];

        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i < 65; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k <= j; k++){
                    dp[i][j] += dp[i-1][k];
                }
            }
        }

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            n = Integer.parseInt(br.readLine());
            answer = 0;

            for(int j = 0; j < 10; j++){
                answer += dp[n][j];
            }
            bw.write(answer+"\n");
        }

        br.close();
        bw.close();

    }
}
