import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Code1389 {
    static int N, M, n1, n2;
    static int[] visited, bacon;
    static ArrayList<LinkedList<Integer>> adj = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int answer=1;

        N = sc.nextInt();
        M = sc.nextInt();
        visited = new int[N+1];
        bacon = new int[N+1];

        for(int i = 0; i < N+1; i++){
            adj.add(new LinkedList<>());
        }

        for(int i = 0; i < M; i++){
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            if(adj.get(n1).contains(n2) || adj.get(n2).contains(n1)) continue;
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }
        countBacon();

        for(int i = 1; i < N+1; i++){
            answer = bacon[answer] > bacon[i] ? i : answer;
        }
        System.out.println(answer+"");
    }

    static void countBacon(){
        for(int i = 1; i < N+1; i++){
            visited = new int[N+1];
            bacon[i] = BFS(i);
        }
    }

    static int BFS(int start){
        Queue<int[]> q = new LinkedList<>();
        int[] nC = {start, 0}, temp;
        int answer = 0;

        q.offer(nC);
        visited[start] = 1;

        while(!q.isEmpty()){
            temp = q.poll();
            answer += temp[1];

            for(int i : adj.get(temp[0])){
                if(visited[i] == 0){
                    q.offer(new int[] {i, temp[1]+1});
                    visited[i] = 1;
                }
            }
        }
        return answer;
    }
}
