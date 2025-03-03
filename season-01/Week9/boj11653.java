/**
 * 24. 11. 17.
 * 제곱근 이하의 수로 소인수분해, 약수인 소수는 문자열로 누적하여 해결했다.
 */
package Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11653 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= Math.sqrt(input); i++) {
            while (input % i == 0) {
                input /= i;
                sb.append(i + "\n");
            }
        }

        if (input != 1) {
            sb.append(input);
        }
        System.out.println(sb);
    }
}