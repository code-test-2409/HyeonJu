package Maths;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 *  [BOJ1929] 소수 구하기
 *  에라토스테네스의 체
 * */

public class boj1929 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] primes = new int[n-m+1];
        boolean[] memo = new boolean[n-m+1];

        fillNumbers(primes, m, n);

        Arrays.fill(memo, true); // true로 채운다
        if (m == 1) {
            memo[0] = false;
        }

        findPrimes(primes, memo, n);

        printPrimes(primes, memo);
    }

    private static void printPrimes(int[] primes, boolean[] memo) {
        for (int i = 0; i < memo.length; i++) {
            if (memo[i]) {
                System.out.println(primes[i]);
            }
        }
    }

    private static void findPrimes(int[] primes, boolean[] memo, int maxNum) {
        for (int i = 2; i * i <= maxNum; i++) {
            // i가 소수인 경우에만 찾기
            if (isPrime(i)) {
                for (int j = 0; j < primes.length; j++) {
                    if ((primes[j] % i == 0) && (primes[j] != i)) {
                        memo[j] = false;
                    }
                }
            }
        }
    }

    private static boolean isPrime(int num) {
        // num이 소수일 때 true를 반환
        if (num < 2) return false; // num == 1 -> 소수
        for (int i = 2; i * i <= num; i++) {
            // 2, 3, 4로 나눠진다면 소수가 아니다
            if (num % i == 0) return false;
        }
        return true;
    }

    private static void fillNumbers(int[] primes, int m, int n) {
        for (int i = 0; i < primes.length; i++) {
            primes[i] = m;
            m += 1;
        }
    }
}
