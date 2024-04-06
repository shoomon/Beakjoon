import java.util.HashMap;
import java.util.Scanner;

public class Code3009 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b;
        HashMap<Integer, Integer> x = new HashMap<>(), y = new HashMap<>();

        for(int i = 0; i < 3; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            if(x.isEmpty() || !x.containsKey(a)){
                x.put(a, 1);
            }else{
                x.put(a, x.get(a)+1);
            }

            if(y.isEmpty() || !y.containsKey(b)){
                y.put(b, 1);
            }else{
                y.put(b, y.get(b)+1);
            }
        }

        for(int i : x.keySet()){
            if(x.get(i)%2 == 1){
                System.out.print(i+" ");
            }
        }

        for(int i : y.keySet()){
            if(y.get(i)%2 == 1){
                System.out.print(i);
            }
        }
    }
}
