import java.io.*;
import java.util.StringTokenizer;

public class Code2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N, M, K, i , j, x, y, sum=0;
        int[][] nums;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
//        nums = new int[N*M];
        nums = new int[N][M];

        for(int t = 0; t < N; t++){
            st = new StringTokenizer(br.readLine());
            for(int l = 0; l < M; l++){
//                nums[t*M + l] = Integer.parseInt(st.nextToken());
                nums[t][l] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        for(int t = 0; t < K; t++){
            sum=0;
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

//            for(int l = (i-1)*M+j-1; l <= (x-1)*M+y-1; l++){
//                sum += nums[l];
//            }

            for(int l = i-1; l < x; l++){
                for(int a = j-1; a < y; a++){
                    sum += nums[l][a];
                }
            }

            bw.write(sum+"\n");
        }

        br.close();
        bw.close();
    }
}
