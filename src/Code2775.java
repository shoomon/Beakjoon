import java.util.Scanner;

public class Code2775 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T, K, N;
        int[][] apt;

        T = sc.nextInt();

        for(int t = 0; t < T; t++){
            K = sc.nextInt();
            N = sc.nextInt();
            int max = Math.max(K,N);
            apt = new int[max+1][max+1];

            for(int i = 0; i < max+1; i++){
                apt[0][i] = i;
            }

            for(int i = 1; i < max+1; i++){
                for(int j = 0; j < max+1; j++){
                    for(int k = 0; k < j+1; k++){
                        apt[i][j] += apt[i-1][k];
                    }
                }
            }

            System.out.println(apt[K][N]);
        }
    }
}
