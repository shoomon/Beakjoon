import java.io.*;
import java.util.ArrayList;

public class Code17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] s = br.readLine().toCharArray();
        ArrayList<Character> answer = new ArrayList<>();

        for(int i = 0; i < s.length; i++){
            if(s[i] == '<'){
                while(s[i] != '>'){
                    answer.add(s[i++]);
                }
                answer.add(s[i]);
            }else{
                if(s[i] == ' ') {
                    answer.add(' ');
                    continue;
                }
                int count = 1;
                while(i < s.length && s[i] != ' ' && s[i] != '<'){
                    i++;
                    count++;
                }
                i--;
                count--;
                for(int j = 0; j < count; j++){
                    answer.add(s[i-j]);
                }
            }
        }

        for(char i : answer){
            bw.write(i+"");
        }

        br.close();
        bw.close();
    }
}
