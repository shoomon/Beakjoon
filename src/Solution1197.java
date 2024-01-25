import java.io.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1197 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            ArrayList<Edge> edges = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                edges.add(new Edge(A, B, C));
            }

            // Kruskal 알고리즘 수행
            int result = kruskal(V, edges);

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

        static int kruskal(int V, ArrayList<Edge> edges) {

            Collections.sort(edges); // 가중치 기준으로 간선 정렬
            int[] parent = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                parent[i] = i; // 초기화: 자기 자신을 부모로 설정
            }

            int totalWeight = 0;
            int edgeCnt = 0;

            for (Edge edge : edges) {
                int rootA = find(parent, edge.from);
                int rootB = find(parent, edge.to);

                if (rootA != rootB) {
                    // 사이클이 발생하지 않으면 해당 간선을 선택하고 두 정점을 연결
                    union(parent, rootA, rootB);
                    totalWeight += edge.weight;
                    edgeCnt++;

                    if (edgeCnt == V - 1) {
                        // 최소 스패닝 트리가 완성되면 종료
                        break;
                    }
                }
            }

            return totalWeight;
        }

        private static int find(int[] parent, int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent, parent[x]);
        }

        private static void union(int[] parent, int a, int b) {
            int rootA = find(parent, a);
            int rootB = find(parent, b);

            if (rootA != rootB) {
                parent[rootA] = rootB;
            }
        }
}

