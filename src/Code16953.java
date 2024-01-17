import java.util.Scanner;

public class Code16953 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b, cur, count = 0;

        a = sc.nextInt();
        b = sc.nextInt();
        cur = b;

        while(cur > a){
            if(cur % 2 == 0){
                cur /= 2;
                count++;
            }else if(cur % 10 == 1){
                cur /= 10;
                count++;
            }else{
                cur = -1;
                break;
            }
        }
        if(cur == a){
            System.out.println(count+1);
        }else{
            System.out.println(-1);
        }
    }
}
