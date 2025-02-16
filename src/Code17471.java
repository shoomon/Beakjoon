import java.util.*;
/* 24.08.17
 * 설계 시간: 5분
 * 구현 시간: 90분
 */

public class Code17471 {
    static int N, answer;
    static int[] population;
    static int[][] adj;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        answer = Integer.MAX_VALUE;
        population = new int[N];
        boolean[] isSelected = new boolean[N];
        adj = new int[N][N];

        for(int i = 0; i < N; i++){
            population[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++){
            int num = sc.nextInt();
            for(int j = 0; j < num; j++){
                int in = sc.nextInt()-1;
                adj[i][in] = 1;
            }
        }
        //선거구들의 모든 조합 생성
        combination(0, isSelected);
        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }

    static void combination(int depth, boolean[] isSelected){
        //하나의 조합이 완성되면
        if(depth == N){
            int flag=0;
            //구역들이 각각 어떤 선거구에 배치되었는지 확인
            for(int i = 0; i < N; i++){
                //선택된 선거구에 속한 지역일 경우
                if(isSelected[i]){
                    //같은 선거구의 다른 지역에
                    for(int j = i+1; j < N; j++){
                        if(isSelected[j]){
                            //연결되어있지 않으면 플래그
                            if(!isConnected(i,j, true, isSelected)) {
                                flag = 1;
                                break;
                            }
                        }
                    }
                    if(flag == 1) break;
                }
                //선택되지 않은 선거구에 속한 지역일 경우
                if(!isSelected[i]){
                    //같은 선거구의 다른 지역에
                    for(int j = i+1; j < N; j++){
                        if(!isSelected[j]){
                            //연결되어 있지 않으면 플래그
                            if(!isConnected(i,j, false, isSelected)) {
                                flag = 1;
                                break;
                            }
                        }
                    }
                    if(flag == 1) break;
                }
            }
            //연결되지 않은 구역 없이 선거구가 나누어졌으면 인구 차이 계산
            if(flag == 0) calculatePop(isSelected);
            return;
        }

        //아래처럼 하면 오답이 나온다
        /*combination(depth+1, isSelected);
         *isSelected[depth] = true;
         *combination(depth+1, isSelected);
        */
            isSelected[depth] = true;
            combination(depth+1, isSelected);
            isSelected[depth] = false;
            combination(depth+1, isSelected);
    }

    //BFS로 i와 같은 선거구에 속해있고 (selected == isSelected) 방문 가능한 지역인지 확인하며
    // 목표점 (j)에 도착하면 true 리턴
    static boolean isConnected(int i, int j, boolean selected, boolean[] isSelected){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        int cur=-1;

        for(int k = 0; k < adj[i].length; k++){
            if(isSelected[k] == selected && adj[i][k] == 1){
                if(k == j) return true;
                visited[k] = true;
                q.offer(k);
            }
        }

        while(!q.isEmpty()){
            cur = q.poll();

            for(int k = 0; k < adj[cur].length; k++){
                if(isSelected[k] == selected && !visited[k] && adj[cur][k] == 1){
                    if(k == j) return true;
                    visited[k] = true;
                    q.offer(k);
                }
            }
        }
        return false;
    }

    static void calculatePop(boolean[] isSelected){
        int a=0, b=0;

        for(int i = 0; i < N; i++){
            if(isSelected[i]){
                a += population[i];
            }else{
                b += population[i];
            }
        }
//        System.out.println(answer+" "+Math.abs(a-b));
        answer = Math.min(Math.abs(a-b), answer);
    }
}
