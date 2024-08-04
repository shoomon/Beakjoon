import java.util.*;
public class Code2798 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), sum=0;
        int[] num = new int[N];


        for(int i = 0; i < N; i++){
            num[i] = sc.nextInt();
        }

        for(int i = N-1; i > -1; i--){
            for(int j = i-1; j > -1; j--){
                for(int k = j-1; k > -1; k--){
                    int cur = num[i]+num[j]+num[k];
                    if(cur <= M){
                        if(M- cur < M - sum){
                            sum = cur;
                        }
                    }
                }
            }
        }

        System.out.println(sum);
    }


}
