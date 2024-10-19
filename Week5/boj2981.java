package Maths;

// 241018 [BOJ2981] 검문 https://www.acmicpc.net/problem/2981

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class boj2981 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int differGcdVal = Math.abs(arr[1] - arr[0]);

        for (int i = 2; i < N; i++) {
            differGcdVal = gcd(differGcdVal, Math.abs(arr[i] - arr[i-1]));
        }

        Set<Integer> result = new TreeSet<>();
        result.add(differGcdVal);
        for (int i = 2; i * i <= differGcdVal; i++) {
            if (differGcdVal% i != 0) continue;
            result.add(i);
            result.add(differGcdVal/i);
        }
        StringBuilder sb = new StringBuilder();
        for(Integer num: result) sb.append(num).append(' ');
        System.out.println(sb);
    }

    private static int gcd(int first, int second) {
        if (second == 0) {
            return first;
        }
        return gcd(second, first % second);
    }
}
