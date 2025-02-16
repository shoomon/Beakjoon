//25.01.31
//설계: 0분
//구현: 30분
//11;48 11:56 12:20
import java.util.*;
import java.io.*;

public class Code2003 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr;
        int N, M, front=0, rear=0, cnt=0;
        long sum=0;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        while(front < N){
            if(rear >= N && sum <= M) break;

            while(front < N && sum > M) sum -= arr[front++];
            while(rear < N && sum < M) sum += arr[rear++];
//            System.out.println(front+" "+rear+" "+sum);
            if(sum == M) {
                cnt++;
                if(rear >= N && front < N) {
                    sum -= arr[front++];
                }else if(rear < N){
                    sum += arr[rear++];
                }else{
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
