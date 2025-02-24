//25.02.24
//설계: 답지참조
//구현: 분
//12:09 1:30
//(2^N일 때 1의 개수)DP[N] = (이전까지 누적값)DP[N-1]+(현재 값)(DP[N-1]+2^N)
//규칙 찾기 어려웠음. + 비트마스킹 생소함 + 1경 = 2^55?
import java.util.*;

public class Code9527 {
    static long[] DP;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long A, B;
        DP = new long[55];

        A = sc.nextLong();
        B = sc.nextLong();
        DP[0] = 1;

        for(int i = 1; i < 55; i++) DP[i] = (DP[i-1]<<1) + (1L<<i);

        System.out.println(calOne(B)-calOne(A-1));

    }

    static long calOne(long N){
        long cnt = N&1;

        int size = (int) (Math.log(N)/Math.log(2));

        for(int i = size; i > 0; i--){
            if((N & (1L <<i)) != 0L){
                cnt += DP[i-1]+N-(1L<<i)+1;
                N -= 1L<<i;
            }
        }
        return cnt;
    }
}
