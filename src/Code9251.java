import java.io.*;

public class Code9251 {
    static int[][] lcs;
    static char[] st1, st2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        st1 = br.readLine().toCharArray();
        st2 = br.readLine().toCharArray();
        lcs = new int[st1.length+1][st2.length+1];

        for(int i = 1; i <= st1.length; i++){
            for(int j = 1; j <= st2.length; j++){
                if(st1[i-1] == st2[j-1]){
                    lcs[i][j] = lcs[i-1][j-1]+1;
                }else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        bw.write(lcs[st1.length][st2.length]+"");
        br.close();
        bw.close();
    }
}
