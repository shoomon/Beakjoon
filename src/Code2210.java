import java.util.HashSet;
import java.util.Scanner;

public class Code2210 {
    static int[] dR = {-1, 0, 1, 0};
    static int[] dC = {0, 1, 0, -1};
    static int[][] board = new int[5][5];
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                board[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                move(i, j, 1, "");
            }
        }

        System.out.println(set.size());
    }

    static void move(int startR, int startC, int count, String s){
        int curR=startR, curC=startC, nextR, nextC;

        s += board[startR][startC]+"";

        if(count == 6){
            set.add(s);
            return;
        }

        for(int j =0 ;j < 4; j++){
            nextR = curR+dR[j];
            nextC = curC+dC[j];
            if(-1 < nextR && nextR < 5 && -1 < nextC && nextC < 5) move(nextR, nextC, count+1, s);
        }
    }
}
