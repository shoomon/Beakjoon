//25.01.30
import java.util.*;

public class Code13226{
    public static void main(String[] args){
//        long start = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        int[] cnt = new int[10000001];

        for(int i = 1; i < 10000001; i++){
            int j = 1;
            while(i*j < 10000001){
                cnt[i*j]++;
                j++;
            }
        }

        for(int t= 0; t < T; t++){
            int L = sc.nextInt();
            int U = sc.nextInt();
            int max = 0;

            for(int i = L; i < U+1; i++){
                max = Math.max(max, cnt[i]);
            }

            sb.append(max+"\n");
        }
        System.out.println(sb.toString());
//        System.out.println(System.currentTimeMillis() - start);
    }
}
