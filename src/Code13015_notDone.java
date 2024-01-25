import java.util.Scanner;

public class Code13015_notDone {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N;
        int[] midBlank;

        N = sc.nextInt();
        midBlank = new int[N];

        midBlank[0] = 0;
        midBlank[1] = 1;
        for(int i = 2; i < N; i++){
            midBlank[i] = midBlank[i-1]+2;
        }

        for(int i = 0; i < N; i++){
            if(i == 0){
                for(int j = 0; j < N; j++){
                    System.out.print("*");
                }
                for(int j = 0; j < midBlank[N-1]; j++){
                    System.out.print(" ");
                }
                for(int j = 0; j < N; j++){
                    System.out.print("*");
                }
                System.out.println("");
            }
            for(int j = 0; j < (midBlank[N-1]-midBlank[N-1-i])/2; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int j = 0; j < N-2; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int j = 0; j < midBlank[i]; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int j = 0; j < N-2; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int j = 0; j < (midBlank[N-1]-midBlank[N-1-i])/2; j++){
                System.out.print(" ");
            }
            System.out.println("");
        }

    }
}
