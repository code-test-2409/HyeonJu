/*
2024-12-29
[BOJ10870] 피보나치 수 5
https://www.acmicpc.net/problem/10870
 */
package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int answer = fibonacci(num);
        System.out.println(answer);
    }

    private static int fibonacci(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
