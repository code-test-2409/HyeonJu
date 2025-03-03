/*
  Date: 2024-12-01
  [BOJ-9012] 괄호
  - 스택 없이 count 변수만 사용
 */
package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            char[] input = br.readLine().toCharArray();
            answer.append(isVPS(input)).append("\n");
        }
        System.out.println(answer);
    }

    private static String isVPS(char[] input) {
        int count = 0;

        for(char c: input) {
            if (c == '(') {
                count ++;
            } else if (count == 0) {
                return "NO";
            } else {
                count --;
            }
        }

        if (count == 0) return "YES";
        else return "NO";
    }
}
