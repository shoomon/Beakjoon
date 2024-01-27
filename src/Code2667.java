import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Code2667 {
    static int[] dR = {1, 0, -1, 0};
    static int[] dC = {0, 1, 0, -1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, count = 0;
        int[][] map, visited;
        ArrayList<Integer> countAPT = new ArrayList<>();
        String s;

        N = sc.nextInt();
        sc.nextLine();
        map = new int[N][N];
        visited = new int[N][N];

        for(int i = 0; i < N; i++){
            s = sc.nextLine();
            for(int j = 0; j < N; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j] == 0 && map[i][j] == 1){
                    count++;
                    countAPT.add(DFS(map, visited, i, j, 0));
                }
            }
        }
        Collections.sort(countAPT);

        System.out.println(count);
        for(int i = 0; i < countAPT.size(); i++){
            System.out.println(countAPT.get(i));
        }
    }

    static int DFS(int[][] map, int[][] visited, int curR, int curC, int count){
        int nR, nC;

        visited[curR][curC] = 1;
        count++;

        for(int i = 0; i < 4; i++){
            nR = curR + dR[i];
            nC = curC + dC[i];

            if(nR > -1 && nR < visited.length && nC > -1 && nC < visited.length){
                if(visited[nR][nC] == 0 && map[nR][nC] == 1){
                    count = DFS(map, visited, nR, nC, count);
                }
            }
        }
        return count;
    }
}
