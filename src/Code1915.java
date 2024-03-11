import java.io.*;
import java.util.StringTokenizer;

public class Code1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M, flag = 0, max=0;
        int[][] arr, dp;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];

        for(int i = 0; i < N; i++){
            char[] temp = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                arr[i][j] = temp[j]-'0';
                if(arr[i][j] == 1) flag = 1;
            }
        }

        for(int i = 0; i < N; i++){
            dp[i][0] = arr[i][0];
            max = Math.max(dp[i][0], max);
        }

        for(int i = 0; i < M; i++){
            dp[0][i] = arr[0][i];
            max = Math.max(dp[0][i], max);
        }

        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr[0].length; j++){
                if(arr[i][j] == 1){
                    dp[i][j] = arr[i][j] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }else{
                    continue;
                }
                max = Math.max(dp[i][j], max);
            }
        }

        if(N == 1 || M == 1){
            if(flag == 1){
                bw.write(1+"");
            }else{
                bw.write(0+"");
            }
        }else{
            bw.write((int)Math.pow(max,2)+"");
        }

        br.close();
        bw.close();
    }
}
