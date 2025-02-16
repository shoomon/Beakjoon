//25.02.10
//설계: 4분
//구현: 6분
//11:32 11:36 11:42
import java.util.Scanner;

public class Code1075 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int F = sc.nextInt();

        N -= N%100;

        for(int i = 0; i < 100; i++){
            if(N%F == 0) break;
            N++;
        }
        String answer = (N%100-N%10)/10+""+N%10;
        System.out.println(answer);

    }
}
