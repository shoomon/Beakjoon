//25.02.07
//12:02 12:10
import java.io.*;
import java.util.*;

public class Code1032 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()), len;
//        String[][] str = new String[N];
        String[] str = new String[N];
        boolean flag;

        for(int i = 0; i < N; i++){
//            str[i] = br.readLine().split(".");
            str[i] = br.readLine();
        }

        len = str[0].length();
        for(int j = 0; j < len; j++){
            flag = true;
            for(int i = 1; i < N; i++){
                if(str[i-1].charAt(j) != str[i].charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                sb.append(str[0].charAt(j));
            }else{
                sb.append("?");
            }
        }

        System.out.println(sb.toString());
    }
}
