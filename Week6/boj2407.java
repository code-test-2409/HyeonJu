package Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// 241026 [2407] 조합

public class boj2407 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        System.out.println(calc(N, M));
    }

    private static BigInteger calc(int n, int m) {

        if (m == 0 || m == n) {
            return BigInteger.ONE;
        }

        if (m > n - m) {
            m = n - m;
        }

        BigInteger res = BigInteger.ONE; // 1

        for (int i = 1; i <= m; i++) {
            res = res.multiply(BigInteger.valueOf(n - i + 1));
            res = res.divide(BigInteger.valueOf(i));
        }

        return res;
    }
}
