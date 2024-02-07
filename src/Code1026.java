import java.util.Arrays;
import java.util.Scanner;

public class Code1026 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, answer=0;
        int[] A, B;

        N = sc.nextInt();
        A = new int[N];
        B = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++){
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < N; i++){
            answer += A[i]*B[N-1-i];
        }
        System.out.println(answer+"");
    }
}
