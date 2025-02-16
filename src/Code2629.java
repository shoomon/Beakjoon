//25.02.02
//설계: 분
//구현: 분
//5:28
//N <= 30, M <=7, 분할정복 X DP였다
//i번째 수로 만들 수 있는 경우는 i or sum-i or sum+i
//40001*30 = 120만
import java.util.*;
import java.io.*;

public class Code2629 {

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N, M;
        boolean[] dp = new boolean[40001];
        Queue<Integer> q = new ArrayDeque<>();

        dp[0] = true;
        //추 입력
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            q.offer(cur);
            for(int j = 0; j < 40001; j++){
                if(dp[j]){
//                    System.out.println(cur+" "+j);
                    q.offer(Math.abs(j-cur));
                    if(j+cur < 40001) q.offer(j+cur);
                }
            }
            while(!q.isEmpty()) dp[q.poll()] = true;
        }
//        for(int i = 0; i < 30; i++){
//            System.out.print(dp[i]+" ");
//        }
        //구슬 입력
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int ball = Integer.parseInt(st.nextToken());
            if(dp[ball]) {
                sb.append("Y ");
            }else{
                sb.append("N ");
            }
        }

        System.out.println(sb.toString());
    }
}
