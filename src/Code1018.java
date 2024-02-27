import java.util.Scanner;

public class Code1018 {
    static int min = Integer.MAX_VALUE, N, M;
    static char[][] board;
    static char[] s;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new char[N][M];
        sc.nextLine();

        for(int i = 0; i < N; i++){
            s = sc.nextLine().toCharArray();
            for(int j = 0; j < M; j++){
                board[i][j] = s[j];
            }
        }

        for(int i = 0; i < N-7; i++){
            for(int j = 0; j < M-7; j++){
                min = Math.min(check(i, j), min);
            }
        }
        System.out.println(min+"");
    }

    static int check(int startR, int startC){
        int wCnt=0, bCnt=0;

        for(int i = startR; i < startR+8; i++){
            for(int j = startC; j < startC+8; j++){
                if((i+j-startR-startC)%2 == 0){
                    if(board[i][j] != 'W') wCnt++;
                    else bCnt++;
                }else if((i+j-startR-startC)%2 == 1){
                    if(board[i][j] != 'B') wCnt++;
                    else bCnt++;
                }
            }
        }
        return Math.min(wCnt, bCnt);
    }
}
