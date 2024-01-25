import java.io.*;

public class Code11403 {
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
//            #answer1
//            for(int i = 0; i < n; i++){
//                for(int j = 0; j < n; j++){
//                    initList(visited);
//                    //System.out.println("DFS START" + Integer.toString(i) + ", " + Integer.toString(j));
//                    answer[i][j] = DFS(adj, visited, i, j);
//                    System.out.print(answer[i][j] + " ");
//                }
//                System.out.println("");
//            }

//            #answer2 floyd
            for(int k = 0; k < n; k++){
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        if(adj[i][k] == 1 && adj[k][j] == 1){
                            adj[i][j] = 1;
                        }
                    }
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(adj[i][j] + " ");
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

//    static int DFS(int[][] list, int[] visited, int start, int end){
//        visited[start] = 1;
//
//        if(list[start][end] == 1){
//            return 1;
//        }
//        for(int i = 0; i < list.length; i++){
//            if(list[start][i] != 0 && visited[i] == 0){
//                //System.out.println(Integer.toString(start)+", "+Integer.toString(i)+ Integer.toString(DFS(list, visited, i, end)));
//                if(DFS(list, visited, i, end) == 1){
//                    return 1;
//                }
//            }
//        }
//        return 0;
//    }
}
