/*
  Date: 2024-12-01
  [BOJ-10845] 큐
  - 큐 구현, 인덱스 주의
 */
package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10845 {

    static int[] queue = new int[10001];
    static int first = 0;
    static int last = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int cmd = Integer.parseInt(br.readLine());

        while (cmd-- > 0) {
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            switch (operation) {
                case "push": push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop": answer.append(pop()).append("\n");
                    break;
                case "size": answer.append(size()).append("\n");
                    break;
                case "empty": answer.append(empty()).append("\n");
                    break;
                case "front": answer.append(front()).append("\n");
                    break;
                case "back": answer.append(back()).append("\n");
                    break;
            }
        }

        System.out.println(answer);

    }

    private static void push(int num) {
        queue[last] = num;
        last ++;
    }

    private static int pop() {
        if (last - first == 0) return -1;
        else {
            int item = queue[first];
            first ++;
            return item;
        }
    }

    private static int size() {
        return last - first;
    }

    private static int empty() {
        if (last - first == 0) return 1;
        else return 0;
    }

    private static int front() {
        if (last - first == 0) return -1;
        return queue[first];
    }

    private static int back() {
        if (last - first == 0) return -1;
        return queue[last];
    }
}
