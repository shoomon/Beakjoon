import java.util.LinkedList;
import java.util.Scanner;

public class Code1138 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N;
        int[] numTaller;
        LinkedList<Integer> line = new LinkedList<>();

        N = sc.nextInt();
        numTaller = new int[N];

        line.addFirst(N);

        for(int i = 0; i < N; i++){
            numTaller[i] = sc.nextInt();
        }
        for(int i = N-2; i > -1; i--){
            line.add(numTaller[i], i+1);
        }

        for(int people : line){
            System.out.print(people + " ");
        }

    }
}
