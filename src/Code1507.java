import java.util.Scanner;
import java.util.StringTokenizer;

public class Code1507 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        int N, answer=0;
        int[][] dist, tmp;
//        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(sc.nextLine());
        N = Integer.parseInt(st.nextToken());
        dist = new int[N][N];
        tmp = new int[N][N];

        for(int i = 0; i < N; i ++){
            st = new StringTokenizer(sc.nextLine());
            for(int j = 0; j< N; j++){
                dist[i][j] = Integer.parseInt(st.nextToken());
                tmp[i][j] = dist[i][j];
//                set.add(dist[i][j]);
            }
        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i ++){
                for(int j = 0; j < N; j++){
                    if(dist[i][k] == 0 || dist[k][j] == 0) continue;
                    if(dist[i][k]+dist[k][j] == dist[i][j]){
                        tmp[i][j] = 0;
//                        set.remove(dist[i][j]);
                    }else if(dist[i][k]+dist[k][j] < dist[i][j]){
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
//                if(set.contains(dist[i][j])){
//                    answer += dist[i][j];
//                    System.out.print(dist[i][j]+" ");
//                }
                answer += tmp[i][j];
            }
        }

        if(answer == 0){
            System.out.println(-1);
        }else{
            System.out.println(answer+"");
        }

    }
}
