package Maths;

// 241018 [BOJ1684] 같은 나머지 https://www.acmicpc.net/problem/1684

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1684 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열의 크기
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int gcdVal = Math.abs(arr[1]-arr[0]);

        for (int i = 2; i < n; i++) {
            gcdVal = gcd(gcdVal, Math.abs(arr[i] - arr[i-1]));
        }

        System.out.println(gcdVal);
    }

    private static int gcd(int first, int second) {
        if (second == 0) {
            return first;
        }
        return gcd(second, first % second);
    }
}
