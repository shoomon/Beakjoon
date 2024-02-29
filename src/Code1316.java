import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Code1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, count=0;
        String[] s;

        N = Integer.parseInt(br.readLine());
        s = new String[N];

        for(int i = 0; i < N; i++){
            s[i] = br.readLine();
            if(check(s[i])) count++;
        }

        System.out.println(count+"");
    }

    static boolean check(String s){
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(list.contains(c)) return false;
            list.add(c);
            while(i+1 < s.length() && s.charAt(i+1) == c){
                i++;
            }
        }
        return true;
    }
}
