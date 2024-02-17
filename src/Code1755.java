import java.util.Scanner;
import java.util.TreeMap;

public class Code1755 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, M, count=0;
        String num, s;
        TreeMap<String, Integer> t = new TreeMap<>();

        M = sc.nextInt();
        N = sc.nextInt();

        for(int i = M; i < N+1; i++){
            num = i + "";
            s = "";
            for(int j = 0; j < num.length(); j++){
                s += numToS(num.charAt(j));
            }
            t.put(s, i);
        }

        for(String key : t.keySet()){
            System.out.print(t.get(key) + " ");
            count++;
            if(count%10 == 0){
                System.out.println();
            }
        }

    }

    static String numToS(char c){
        switch (c){
            case '0': return "zero";
            case '1': return "one";
            case '2': return "two";
            case '3': return "three";
            case '4': return "four";
            case '5': return "five";
            case '6': return "six";
            case '7': return "seven";
            case '8': return "eight";
            case '9': return "nine";
        }
        return "-1";
    }
}
