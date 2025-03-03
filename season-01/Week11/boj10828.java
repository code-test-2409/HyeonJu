/*
  Date: 2024-12-01
  [BOJ-10828] 스택
  - 명령 갯수만큼 고정 크기 스택 선언
 */

package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10828 {
    static int[] stack;
    static int size = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        StringTokenizer st;
        int commands = Integer.parseInt(br.readLine());

        stack = new int[commands];
        while (commands-- > 0) { // 14
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push": push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop": answer.append(pop()).append("\n");
                    break;
                case "size": answer.append(size()).append("\n");
                    break;
                case "empty": answer.append(empty()).append("\n");
                    break;
                case "top": answer.append(top()).append("\n");
                    break;
            }
        }
        System.out.println(answer);
    }

    private static void push(int num) {
        stack[size] = num;
        size++;
    }

    private static int pop() {
        if (size == 0) return -1;
        else {
            int res = stack[size - 1];
            stack[size - 1] = 0;
            size --;
            return res;
        }
    }

    private static int size() {
        return size;
    }

    private static int empty() {
        if (size == 0) return 1;
        else return 0;
    }
    private static int top() {
        if (size == 0) return -1;
        else return stack[size - 1];
    }

}
