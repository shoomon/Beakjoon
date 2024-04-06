import java.util.Scanner;

public class Code9663 {
    static int N, answer=0;
    static int[][] map;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];

        putQ(-1,1);

        System.out.println(answer+"");
        sc.close();
    }

    static void putQ(int r, int depth){
        if(depth == N){
            answer++;
            return;
        }
//        System.out.println(depth+"------------"+answer);
//        for(int k = 0; k < N; k++){
//            for(int l= 0; l < N; l++){
//                System.out.print(map[k][l]+" ");
//            }
//            System.out.println();
//        }

        for(int i = r+1; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 0){
                    if(check(i,j)){
                        map[i][j] = 1;
                        putQ(i+1, depth+1);
                        map[i][j] = 0;
                    }
                }

            }
        }
    }

    static boolean check(int r, int c){
        boolean ret = true;
        int idx1 = r, idx2 = c;

        for(int i = 0; i < N; i++){
            if (map[r][i] != 0 || map[i][c] != 0) return false;
        }

        while(-1 < idx1 && idx1 < N && -1 < idx2 && idx2 < N){
            if(map[idx1++][idx2++] != 0) return false;
        }

        idx1 = r;
        idx2 = c;
        while(-1 < idx1 && idx1 < N && -1 < idx2 && idx2 < N){
            if(map[idx1--][idx2--] != 0) return false;
        }

        idx1 = r;
        idx2 = c;
        while(-1 < idx1 && idx1 < N && -1 < idx2 && idx2 < N){
            if(map[idx1--][idx2++] != 0) return false;
        }

        idx1 = r;
        idx2 = c;
        while(-1 < idx1 && idx1 < N && -1 < idx2 && idx2 < N){
            if(map[idx1++][idx2--] != 0) return false;
        }

        return ret;
    }
}
