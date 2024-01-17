import java.util.Scanner;

public class Code1009 {
    public static void main(String[] args){
        int t, a, b;
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        for(int i = 0; i < t; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            System.out.println(powLast(a, b));
        }
    }

    static int powLast(int a, int b){
        int answer = 1;
        for(int i = 0; i < b; i++){
            answer *= a;
            answer %= 10;
        }
        return answer == 0 ? 10 : answer;
    }
}
