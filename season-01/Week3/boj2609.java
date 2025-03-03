package Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
*  [BOJ2609] 최대공약수, 최소공배수
*  유클리드 호제법
* */

public class boj2609 {

    public static void main(String[] args) throws IOException {
        int gcd = 0; // 최대공약수 greatest common divisor
        int lcm = 0; // 최소공배수 least common multiple

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num_a = Integer.parseInt(st.nextToken());
        int num_b = Integer.parseInt(st.nextToken());

        gcd = GCD(num_a, num_b);
        lcm = num_a * num_b / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int GCD(int a, int b) {
        while (a % b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return b;
    }
}
