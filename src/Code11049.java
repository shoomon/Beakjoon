import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N, x, y;
        long[][] dp;
        Point[] rc;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        rc = new Point[N];
        dp = new long[N][N];

        for(int i = 0; i < N; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            rc[i] = new Point(x,y);
        }



        for(int i = 0; i < N-1; i++){
                dp[i][i+1] = rc[i].x*rc[i].y*rc[i+1].y;
                dp[i][i] = 0;
        }
        dp[N-1][N-1] = 0;


        for(int k = 1; k < N; k++){
            for(int i = 0; i+k < N; i++){
                for(int j = i; j < i+k; j++){
                    dp[i][i+k] = Math.min(dp[i][i+k], dp[i][j]+dp[j+1][i+k]+rc[i].x*rc[j].y*rc[i+k].y);
                }
            }
        }

//        for(int i = 0; i < N; i ++){
//            for(int j = 0; j < N; j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        bw.write(dp[0][N-1]+"");

        br.close();
        bw.close();

    }
}
