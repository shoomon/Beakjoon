import java.io.*;
import java.util.LinkedList;

public class Code9252 {
    static char[] s1, s2;
    static LinkedList<Character> s = new LinkedList<>();
    static int[][] lcs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();
        lcs = new int[s1.length+1][s2.length+1];


        for(int i = 1; i < s1.length+1; i++){
            for(int j = 1; j < s2.length+1; j++){
                if(s1[i-1] == s2[j-1]){
                    lcs[i][j] = lcs[i-1][j-1]+1;
                }else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

//        for(int i = 0; i < s1.length+1; i++){
//            for(int j = 0; j < s2.length+1; j++){
//                System.out.print(lcs[i][j]+ " ");
//            }
//            System.out.println();
//        }

        bw.write(lcs[s1.length][s2.length]+"\n");
        if(lcs[s1.length][s2.length] != 0){
            getLcs();
            for(char k : s){
                bw.write(k);
            }
        }


        br.close();
        bw.close();
    }




    static void getLcs(){
        int i = s1.length, j = s2.length;

        while(i > 0 && j > 0){

            if(lcs[i][j] == lcs[i][j-1]){
                j--;
            }
            if(lcs[i][j] == lcs[i-1][j]){
                i--;
            }
            if((i <= 0) || (j <= 0)) break;
            if(lcs[i][j] != lcs[i][j-1] && lcs[i][j] != lcs[i-1][j]){
                if(s1[i-1] == s2[j-1]){
                    s.addFirst(s1[i-1]);
                }
                i--;
                j--;
            }
        }
    }
}
