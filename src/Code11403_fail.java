import java.io.*;

public class Code11403_fail {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        int[] visited;
        int[][] adj, answer;
        String[] s;
        try{
            n = Integer.parseInt(br.readLine());
            adj = new int[n][n];
            answer = new int[n][n];
            visited = new int[n];



            for(int i = 0; i < n; i++){
                s = br.readLine().split(" ");
                for(int j = 0; j < n; j++){
                    adj[i][j] = Integer.parseInt(s[j]);
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    initList(visited);
                    answer[i][j] = DFS(adj, visited, i, j);
                    System.out.print(answer[i][j] + " ");
                }
                System.out.println("");
            }


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    static void initList(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    static int DFS(int[][] list, int[] visited, int start, int end){
        visited[start] = 1;

        if(start == end){
            return 1;
        }
        for(int i = 0; i < list.length; i++){
            if(list[start][i] != 0 && visited[i] == 0){
                if(DFS(list, visited, i, end) == 1){
                    return 1;
                }
            }
        }
        return 0;
    }
}
