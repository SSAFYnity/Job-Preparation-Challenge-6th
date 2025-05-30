import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int i;
        int j;
        int weight;

        Edge(int i, int j, int weight) {
            this.i = i;
            this.j = j;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return false;
        }
        parent[pb] = pa;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        // 기초 인접행렬
        int[][] adjMat = new int[N][N];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = i + 1; j < N; j++) {
                // 각 정점끼리 거리 인접행렬에 표시
                int len = Integer.parseInt(st.nextToken());
                adjMat[i][j] = len;
                adjMat[j][i] = len;
            }
        }
        // 초기화
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        // 정점 가중치대로 정렬
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                edgeList.add(new Edge(i, j, adjMat[i][j]));
            }
        }
        Collections.sort(edgeList);

        // 인접리스트 선언
        List<Integer>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        int edgeCount = 0;

        for (Edge e : edgeList) {
            if (union(e.i, e.j)) {
                // 양방향 연결
                adjList[e.i].add(e.j);
                adjList[e.j].add(e.i);
                edgeCount++;
                if (edgeCount == N - 1) {
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(adjList[i]);
            System.out.print(adjList[i].size());
            for (int node : adjList[i]) {
                System.out.print(" " + (node + 1));
            }
            System.out.println();
        }



    }
}
