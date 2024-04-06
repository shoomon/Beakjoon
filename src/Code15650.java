import java.util.ArrayList;
import java.util.Scanner;

public class Code15650 {
    static int N, M;
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        makeSeq(arr);
    }

    static void makeSeq(ArrayList<Integer> arr){
        int i;
        if(arr.size() == M){
            for(int j : arr){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        if(arr.isEmpty()) {
            i = 1;
        }else{
            i = arr.get(arr.size()-1)+1;
        }
        for(; i < N+1; i++){
            if(arr.contains(i)) continue;
            arr.add(i);
            makeSeq(arr);
            arr.remove(arr.size()-1);
        }
    }
}
