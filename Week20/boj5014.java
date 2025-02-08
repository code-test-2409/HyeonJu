/*
    [BOJ-5014-SILVER-1] 스타트링크
    --- ⏱️30 min / 🚀35140KB / ⌛260 ms
    --- BFS, ArrayDeque
*/

package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj5014 {

    static int F, S, G, U, D;
    static int[] dir = new int[2];
    static final String fail_msg = "use the stairs";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int answer = 0;
        F = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        G = Integer.parseInt(input[2]);

        U = Integer.parseInt(input[3]);
        D = -Integer.parseInt(input[4]);

        dir[0] = U;
        dir[1] = D;

        move(S);
    }

    private static void move(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] clickCount = new int[F + 1];
        boolean[] isVisited = new boolean[F + 1];

        queue.add(start);
        isVisited[start] = true;
        clickCount[start] = 0;

        while (!queue.isEmpty()) {
            int curFloor = queue.remove();

            if (curFloor == G) {
                System.out.println(clickCount[curFloor]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int nextFloor = curFloor + dir[i];

                if (nextFloor >= 1 && nextFloor <= F && !isVisited[nextFloor]) {
                    queue.add(nextFloor);
                    isVisited[nextFloor] = true;
                    clickCount[nextFloor] = clickCount[curFloor] + 1;
                }
            }
        }
        System.out.println(fail_msg);
    }
}