/**
 * 24. 11. 17.
 * 수열의 합 공식 활용
 */
package Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj8393 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println((N * (N + 1)) / 2);
    }

}