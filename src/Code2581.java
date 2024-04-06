import java.util.Scanner;

public class Code2581 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M, N, sum=0, min=-1;
        int[] arr;

        M = sc.nextInt();
        N = sc.nextInt();
        arr = new int[N+1];

        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i < N+1; i++){
            if(arr[i] == 0){
                int j = 2;
                while(i*j <=  N){
                    arr[i*j] = 1;
                    j++;
                }
            }
        }

        for(int i = M; i <= N; i++){
            if(arr[i] == 0){
                if(min == -1) min = i;
                sum += i;
            }
        }

        if(min == -1){
            System.out.println(-1);
        }else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
