import java.util.*;
import java.io.*;
//날짜 24.10.16
//설계 시간: 분
//구현 시간: 분
//메모리: kb
//시간: ms
public class Code2805 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N;
        long M, trees[], left=0, right=Long.MIN_VALUE, mid=-1, answer=0;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        trees = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            trees[i] = Long.parseLong(st.nextToken());
            right = Math.max(right, trees[i]);
        }

        while(left <= right){
            mid = (left+right)/2;
//            System.out.println(mid);

            long get=0;
            for(int i = 0; i < N; i++){
                get += Math.max(trees[i]-mid,0);
            }
            if(get < M){
                right = mid-1;
            }else {
                answer = Math.max(answer, mid);
                left = mid+1;
            }
//            System.out.println(left);
        }
        bw.write(answer+"\n");
        bw.close();
    }
}
