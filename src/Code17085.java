import java.util.Scanner;

public class Code17085 {
    static char[][] map, copy;
    static int N, M, max = Integer.MIN_VALUE;
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {-1, 0, 1, 0};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int val1=0, val2=0;
        String s;
        char[] c;

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        map = new char[N][M];
        copy = new char[N][M];

        for(int i = 0; i < N; i++){
            s = sc.nextLine();
            c = s.toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = c[j];
            }
        }

        sc.close();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                copyMap(map, copy);
                if(copy[i][j] == '#'){
                    val1 = countMax(j,i);
                    for(int k = 0; k <= val1; k++){
                        putPlus(j,i,k);
                        for(int l = 0; l < N; l++){
                            for(int m = 0; m < M; m++){
                                if(copy[l][m] == '#'){
                                    val2 = countMax(m,l);
                                    max = Math.max((4*k+1)*(4*val2+1), max);
//                                    System.out.println(k+" "+val2+" "+max);
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max);

    }

    static int countMax(int x, int y){
        int nX, nY, count=0, len=Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            nX = x;
            nY = y;
            count = -1;

            while (nY >= 0 && nY < N && nX >= 0 && nX < M && copy[nY][nX] == '#') {
                nX += dX[i];
                nY += dY[i];
                count++;

            }
            len = Math.min(count, len);
        }


        return len;
    }

    static void putPlus(int x, int y, int len){
        copy[y][x] = '*';

        for (int i = 1; i <= len; i++) {
            if (y - i >= 0)
                copy[y - i][x] = '*';
            if (x + i < M)
                copy[y][x + i] = '*';
            if (y + i < N)
                copy[y + i][x] = '*';
            if (x - i >= 0)
                copy[y][x - i] = '*';
        }
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(copy[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("===============");
    }


    static void copyMap(char[][] map, char[][] copy){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                copy[i][j] = map[i][j];
            }
        }
    }
}
