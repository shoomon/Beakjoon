import java.util.Scanner;

public class Code1085 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x, y, w, h;

        x = sc.nextInt();
        y = sc.nextInt();
        w = sc.nextInt();
        h = sc.nextInt();
        System.out.println(Math.min(w-x, Math.min(h-y, Math.min(x, y))));
    }
}
