package Maths;

// 241020 [BOJ2824] 최대공약수 https://www.acmicpc.net/problem/2824

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class boj2824 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BigInteger aNum = BigInteger.ONE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            BigInteger num = new BigInteger(st.nextToken());
            aNum = aNum.multiply(num);
        }

        int m = Integer.parseInt(br.readLine());
        BigInteger bNum = BigInteger.ONE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            BigInteger num = new BigInteger(st.nextToken());
            bNum = bNum.multiply(num);
        }

        BigInteger gcdVal = aNum.gcd(bNum);

        String gcdStr = gcdVal.toString();
        int gcdLen = gcdStr.length();

        if (gcdLen > 9) {
            System.out.println(gcdStr.substring(gcdLen - 9));
        } else {
            System.out.println(gcdStr);
        }
    }
}
