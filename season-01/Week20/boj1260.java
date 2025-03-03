/*
    [BOJ-1260-SILVER-2] DFS와 BFS
    - ArrayDeque으로 큐, 스택 구현
    - 🚀메모리 25132KB / ⌛️시간 260 ms
 */
package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj1260 {
    static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] graph_info = br.readLine().split(" ");

        N = Integer.parseInt(graph_info[0]); // a number of Nodes
        M = Integer.parseInt(graph_info[1]); // a number of Vertices
        V = Integer.parseInt(graph_info[2]); // Starting node

        int[][] graph = new int[N+1][N+1]; // 0, 1, 2, 3, 4

        for(int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        // print(graph);
        System.out.println(depth_search(graph, V));
        System.out.println(breadth_search(graph, V));
    }
    public static void print(int[][] graph) {
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[0].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    // DFS
    public static String depth_search(int[][] graph, int start) {
        StringBuilder answer = new StringBuilder();
        boolean[] isVisited = new boolean[graph.length];
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(start);

        while(!stack.isEmpty()) {
            int node_num = stack.pop();

            if (isVisited[node_num]) continue;
            isVisited[node_num] = true;

            answer.append(node_num + " ");

            // 정점 번호가 작은 것부터 탐색하도록 역순 탐색
            for (int i = graph.length - 1; i >= 1; i--) {
                if (graph[node_num][i] != 1 || isVisited[i]) continue;
                stack.push(i);
            }
        }
        return answer.toString();
    }

    // BFS
    public static String breadth_search(int[][] graph, int start) {
        StringBuilder answer = new StringBuilder();
        boolean[] isVisited = new boolean[graph.length];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.remove();

            if (isVisited[node]) continue;
            isVisited[node] = true;

            answer.append(node+ " ");

            for (int i = 1; i < graph.length; i++) {
                if (graph[node][i] != 1 || isVisited[i]) continue;
                queue.add(i);
            }
        }

        return answer.toString();
    }
}