import java.util.Scanner;

public class Code4485_notDone {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, count = 0;
        int[][] map, dp;

        while(true){
            n = sc.nextInt();
            if(n == 0) break;
            count++;
            dp = new int[n][n];
            map = new int[n][n];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    dp[i][j] = Integer.MAX_VALUE;
                    map[i][j] = sc.nextInt();
                }
            }
            System.out.println("Problem " + count + ": ");
        }
    }


}
