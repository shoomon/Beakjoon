import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Code15651 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = sc.nextInt();
        M = sc.nextInt();

        makeSeq(arr, bw);
        sc.close();
        bw.close();
    }

    static void makeSeq(ArrayList<Integer> arr, BufferedWriter bw) throws IOException{
        if(arr.size() == M){
            for(int i : arr){
                bw.write(i+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 1; i < N+1; i++){
            arr.add(i);
            makeSeq(arr, bw);
            arr.remove(arr.size()-1);
        }
    }

}
