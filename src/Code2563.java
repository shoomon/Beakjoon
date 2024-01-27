import java.io.*;
import java.util.StringTokenizer;

public class Code2563 {
    public static void main(String[] args){
        int[][] paper = new int[100][100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N, count = 0;

        try{
            N = Integer.parseInt(br.readLine());
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                stickPaper(paper, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            for(int i = 0; i < 100; i++){
                for(int j = 0; j < 100; j++){
                    if(paper[i][j] != 0){
                        count++;
                    }
                }
            }
            bw.write(count+"");
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                br.close();
                bw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    static void stickPaper(int[][] paper, int startR, int startC){
        for(int i = startR; i < startR + 10; i++){
            for(int j = startC; j < startC + 10; j++){
                paper[i][j]++;
            }
        }
    }
}
