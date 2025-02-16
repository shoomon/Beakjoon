import java.util.Scanner;

public class Code17135 {
    static int N, M, D, answer=0;
    static int[][] map, copy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();
        map = new int[N][M];
        copy = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        //set archer at i, j, k column
        for(int i = 0; i < M-2; i++) {
            for(int j = i+1; j < M-1; j++) {
                for(int k = j+1; k < M; k++) {
//					System.out.println(i+" "+j+" "+k);
                    copyArr();
                    simulation(i,j,k);
                }
            }
        }
        System.out.println(answer);
    }

    static void copyArr() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
    }

    static void simulation(int a1, int a2, int a3) {
        int castleRow = N, score = 0;  //closest with castle + 1
//        flag=0;
        while(castleRow > 0) {
            score += attack(a1, a2, a3, castleRow);
            castleRow--; //move enemy
            for(int j = 0; j < M; j++) { //check is enemy in castle
                if(copy[castleRow][j] == 1) {
//                    answer = Math.max(a, answer);
//					return;
//                    flag = 1; 성 안으로 적이 들어오면 게임이 끝나는 게 아니었다.
//                    break;
                    copy[castleRow][j] = 0;
                }
            }
//            if(flag == 1) break;
        }
        answer = Math.max(score, answer);
//		System.out.println("카운트 "+score+" "+answer);
//		return;
    }

    static int attack(int a1, int a2, int a3, int castleRow) {
        int count=0;
        int[][] e = {{-1,-1},{-1,-1},{-1,-1}};
        int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE, min3=Integer.MAX_VALUE;

        for(int i = castleRow-1; i > -1; i--) {
            for(int j = 0; j < M; j++) {
                if(copy[i][j] == 1) {
                    int dist1 = Math.abs(castleRow-i) + Math.abs(a1 - j);
                    int dist2 = Math.abs(castleRow-i) + Math.abs(a2 - j);
                    int dist3 = Math.abs(castleRow-i) + Math.abs(a3 - j);
//                    System.out.println("거리: "+dist1+" "+dist2+" "+dist3);
                    if(D >= dist1) {
                        if(min1 > dist1){
                            e[0][0] = i;
                            e[0][1] = j;
                            min1 = dist1;
                        }else if(min1 == dist1 && e[0][1] > j){
                            e[0][0] = i;
                            e[0][1] = j;
                        }
                    }
                    if(D >= dist2) {
                        if(min2 > dist2){
                            e[1][0] = i;
                            e[1][1] = j;
                            min2 = dist2;
                        }else if(min2 == dist2 && e[1][1] > j){
                            e[1][0] = i;
                            e[1][1] = j;
                        }
                    }
                    if(D >= dist3) {
                        if(min3 > dist3){
                            e[2][0] = i;
                            e[2][1] = j;
                            min3 = dist3;
                        }else if(min3 == dist3 && e[2][1] > j){
                            e[2][0] = i;
                            e[2][1] = j;
                        }
                    }
                }
            }
        }

        if(e[0][0] != -1 && e[0][1] != -1 && copy[e[0][0]][e[0][1]] == 1) {
//			System.out.println(e[0][0]+" "+e[0][1]);
            copy[e[0][0]][e[0][1]] = 0;
            count++;
        }
        if(e[1][0] != -1 && e[1][1] != -1 && copy[e[1][0]][e[1][1]] == 1) {
//			System.out.println(e[1][0]+" "+e[1][1]);
            copy[e[1][0]][e[1][1]] = 0;
            count++;
        }
        if(e[2][0] != -1 && e[2][1] != -1 && copy[e[2][0]][e[2][1]] == 1) {
//			System.out.println(e[2][0]+" "+e[2][1]);
            copy[e[2][0]][e[2][1]] = 0;
            count++;
        }
//		System.out.println("카운트2 "+count);
        return count;
    }

}