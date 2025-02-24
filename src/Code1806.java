//25.02.23
//설계: 분
//구현: 17+19+43분
//12:37 12:54 01:13 01:56
import java.util.*;
import java.io.*;

public class Code1806 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, S, front=0, rear=1, answer=Integer.MAX_VALUE;
        long[] seqSum;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        seqSum = new long[N+1];

        st = new StringTokenizer(br.readLine());
        seqSum[1] = Integer.parseInt(st.nextToken());
        for(int i = 2; i < N+1; i++) {
            seqSum[i] = seqSum[i-1]+Integer.parseInt(st.nextToken());
        }

        while(front <= rear && rear < N+1){
            if(seqSum[rear] - seqSum[front] < S) {
                rear++;
            }else{
                answer = Math.min(answer, rear-front);
                front++;
            }
        }

        answer = answer == Integer.MAX_VALUE ? 0 : answer;
        System.out.println(answer);
    }
}
