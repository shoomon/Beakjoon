//25.02.09
import java.util.*;

public class Code15813 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        char[] name = sc.nextLine().toCharArray();
        int answer = 0;

        for(int i = 0; i < name.length; i++) answer += name[i]-'A'+1;

        System.out.println(answer);
    }
}
