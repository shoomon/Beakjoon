import java.util.Scanner;
public class Code2869 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A,B,V, oneDay;

        A = sc.nextInt();
        B = sc.nextInt();
        V = sc.nextInt();
        oneDay = A-B;

        if((V-A)%oneDay == 0){
            System.out.println((V-A)/oneDay+1+"");
        }else{
            System.out.println((V-A)/oneDay+2+"");
        }
    }
}
