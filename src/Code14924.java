import java.util.Scanner;

public class Code14924 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int S, T, D, answer;

        S = sc.nextInt();
        T = sc.nextInt();
        D = sc.nextInt();

        answer = (D/(S*2))*T;
        System.out.println(answer);
    }
}
