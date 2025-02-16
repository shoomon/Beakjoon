//25.01.26
import java.io.*;
import java.util.*;

class Code13225{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            int cnt = 0;
            double sqrt = Math.sqrt(num);
            for(int j = 1; j < sqrt; j++){
                if(num%j == 0) cnt++;
            }
            cnt *= 2;
            if(Math.ceil(sqrt)*Math.ceil(sqrt) == num) cnt++;
            sb.append(num+" "+cnt+"\n");
        }
        System.out.print(sb.toString());
    }
}