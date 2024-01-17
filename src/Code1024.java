import java.util.Scanner;

public class Code1024 {
    public static void main(String[] args){
        int n,l, a = -1, i;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();

        for(i = l-1; i < 100; i++){
            if((n-sumI(i))%(i+1) == 0){
                a = (n-sumI(i))/(i+1); //n = a + a+1 + a+2 + ... = (i+1)*a + i까지 합
                break;
            }
        }
        if(a == -1 || a < 0){
            System.out.println(-1);
        }else{
            for(int j = 0; j <= i; j++){
                System.out.print((a + j) + " ");
            }
        }

    }

    static int sumI(int i){
        int sum = 0;
        for(int a = 0; a < i+1; a++){
            sum += a;
        }
        return sum;
    }
}
