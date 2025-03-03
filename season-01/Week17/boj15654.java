/**
 *  [250116] N과 M(5) https://www.acmicpc.net/problem/15654
 *  [Resource] 92112 KB / 2048 ms
 */
package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj15654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] visited = new boolean[N];
        Arrays.sort(arr);
        List<Integer> answer = new ArrayList<>();

        getComposition(arr, visited, 0, answer, M);
    }

    static void getComposition(int[] arr, boolean[] visited, int start, List<Integer> composition, int num) {
        
        if (composition.size() == num) {
            for (int i = 0; i < composition.size(); i++) {
                System.out.print(composition.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            else {
                composition.add(arr[i]);
                visited[i] = true;
            }

            getComposition(arr, visited, start + 1, composition, num);

            if (!composition.isEmpty()) {
                composition.remove(composition.size() - 1);
                visited[i] = false;
            }
        }
    }
}