//25.02.19
//설계: 1분
//구현: 26분/다른 방법으로 다시 풀음 -> 9분
//11:12 11:13 11:39(11:48)
//누적합
import java.util.*;
import java.io.*;

public class Code21921 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N,X, front=0, rear=0, cur = 0, max=0, answer=0;
        int[] visitCnt, sum;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visitCnt = new int[N];
        sum = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) visitCnt[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i< X; i++){
            cur += visitCnt[rear++];
        }
        max = cur;
        answer++;
        for(int i = X; i < N; i++){
            cur += visitCnt[rear++];
            cur -= visitCnt[front++];
            if(max < cur){
                max = cur;
                answer = 1;
            }else if(max == cur){
                answer++;
            }
        }

//        sum[0] = visitCnt[0];
//        for(int i = 1; i < N; i++) sum[i] += sum[i-1]+visitCnt[i];
//
//        for(int i = 0; i < X; i++) visitCnt[i] = sum[i];
//        for(int i = X; i < N; i++) {
//            visitCnt[i] = sum[i] - sum[i-X];
//            max = Math.max(max, visitCnt[i]);
//        }

        if(max == 0){
            System.out.println("SAD");
        }else{
            for(int i = 0; i < N; i++){
                if(max == visitCnt[i]) answer++;
            }
            System.out.println(max+"\n"+answer);
        }

    }
}
