/**
 * 24. 11. 17.
 * 에라토스테네스의 체
 */
package Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj4948 {
    // 0 ~ 2n(= 236912) 크기의 배열 생성
    // 인덱스 넘버가 입력값을 의미
    // true이면 합성수, false이면 소수
    public static boolean[] primeNumber = new boolean[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 소수 메서드 실행
        getPrime();

        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int totalPrimeCount = 0;

            for (int i = n+1; i <= 2 * n; i++) {
                if (!primeNumber[i]) totalPrimeCount ++;
            }
            sb.append(totalPrimeCount).append('\n');
        }

        System.out.println(sb); // 모든 답 일괄 출력
    }

    private static void getPrime() {
        primeNumber[0] = primeNumber[1] = true;

        for (int i = 2; i <= Math.sqrt(primeNumber.length); i++) {
            if (primeNumber[i]) continue; // 합성수이므로 skip
            for (int j = i * i; j < primeNumber.length; j += i) {
                primeNumber[j] = true;
            }
        }
    }
}
