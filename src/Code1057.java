import java.util.ArrayList;
import java.util.Scanner;

public class Code1057 {
    static ArrayList<Integer> cur = new ArrayList<>(), next = new ArrayList<>();
    static int N, K, L, round=0, c1 = Integer.MIN_VALUE, c2 = Integer.MIN_VALUE;;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int flag = 0;


        N = sc.nextInt();
        K = sc.nextInt();
        L = sc.nextInt();

        for(int i = 1; i <= N; i++){
            cur.add(i);
        }

        while(flag == 0){
            round++;
            for(int i = 0; i < cur.size(); i += 2){
                c1 = cur.get(i);
                if(i+1 < cur.size()) {
                    c2 = cur.get(i+1);
                }else{
                    next.add(c1);
                    continue;
                }

                if((c1 == K && c2 == L) || (c1 == L && c2 == K)) {
                    flag = 1;
                    break;
                }

                if(c1 == K || c1 == L){
                    next.add(c1);
                }else if(c2 == K || c2 == L){
                    next.add(c2);
                }else{
                    next.add(c1);
                }
            }

            initArr();
        }

        System.out.println(round+"");
    }

    static void initArr(){
        cur.clear();
        for(int i = 0 ; i < next.size(); i++){
            cur.add(next.get(i));
        }
        next.clear();
    }
}
