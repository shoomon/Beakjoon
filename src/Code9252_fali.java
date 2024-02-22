import java.io.*;
import java.util.LinkedList;

public class Code9252_fali {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] s1, s2;
        LinkedList<Character> s = new LinkedList<>();
        int[][] lcs;

        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();
        lcs = new int[s1.length+1][s2.length+1];

        for(int i = 0; i < s1.length; i++){
            for(int j = 0; j < s2.length; j++){
                if(s1[i] == s2[j]){
                    lcs[i+1][j+1] = lcs[i][j]+1;
                }else{
                    lcs[i+1][j+1] = Math.max(lcs[i][j+1], lcs[i+1][j]);
                }
            }
        }

        int i = s1.length, j = s2.length;

        while(i > 0 && j > 0){
            if(s1[i-1] == s2[j-1]){
                s.addFirst(s1[i-1]);
            }
            if(lcs[i][j] == lcs[i][j-1]){
                j--;
            }else if(lcs[i][j] == lcs[i-1][j]){
                i--;
            }else{
                i--;
                j--;
            }
        }

        bw.write(lcs[s1.length][s2.length]+"\n");
        for(char k : s){
            bw.write(k);
        }

        br.close();
        bw.close();

    }
}
