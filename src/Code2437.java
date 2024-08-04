import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Code2437 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        int N, possMin=0, possMax=0;
        int[] m;

        st = new StringTokenizer(sc.nextLine());
        N = Integer.parseInt(st.nextToken());
        m = new int[N];

        st = new StringTokenizer(sc.nextLine());
        for(int i = 0; st.hasMoreTokens(); i++){
            m[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(m);

        int flag = 0;
        for(int i : m){
            if(possMin+i - possMax <= 1){
                possMax = possMax+i;
            }else{
                System.out.println(possMax+1);
                flag = 1;
                break;
            }
        }

        if(flag == 0){
            System.out.println(possMax+1);
        }
    }
}
