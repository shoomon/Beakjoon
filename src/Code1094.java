import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Code1094 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> sticks = new ArrayList<>();
        int X, len = 64, halfMin=0, i;

        X = sc.nextInt();
        sticks.add(len);

        while(len != X){
            Collections.sort(sticks);

            for(i = 0; i < sticks.size() && sticks.get(i) == 1;){
                i++;
            }

            halfMin = sticks.get(i)/2;

            if(len - (halfMin) >= X){
                len -= (halfMin);
                sticks.add(halfMin);
                sticks.remove(i);
            }else{
                sticks.add(halfMin);
                sticks.add(halfMin);
                sticks.remove(i);
            }
            if(len == X) break;
        }

        System.out.println(sticks.size());
    }
}
