import java.util.ArrayList;
import java.util.Scanner;

public class Code15649 {
    static int N,M;
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        makeSeq(arr);
    }

    static void makeSeq(ArrayList<Integer> arr){
        if(arr.size() == M){
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }

        for(int i = 1; i < N+1; i++){
            if(arr.contains(i)) continue;
            arr.add(i);
            makeSeq(arr);
            arr.remove(arr.size()-1);
        }
    }
}
