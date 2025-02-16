//25.02.06
//설계: 정답참조
//구현: 분
//20만 * 20만 = 40 000 000 000 = 400억
//11:14 11:20 11:
//mex({a,b})의 값은 0 또는 1 또는 2
//1. 0, 1인 경우 2
//2. a 또는 b 하나 이상 0인 경우 1
//3. 그 외 0
//경우의 수 * 점수로 계산 -> 각 숫자들 중 하나씩을 뽑으면 순서는 정해져있다.
import java.util.*;
import java.io.*;

public class Code28250 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()), zeroCnt=0, oneCnt=0, otherCnt=0;
        int[] sequence = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
            if(sequence[i] == 0) {
                zeroCnt++;
            }else if(sequence[i] == 1){
                oneCnt++;
            }else{
                otherCnt++;
            }
        }

        long answer = ((long)zeroCnt*(long)(zeroCnt-1))/2 + (long)zeroCnt*(long)oneCnt*2 + (long)zeroCnt*(long)otherCnt;
        System.out.println(answer);
    }
}