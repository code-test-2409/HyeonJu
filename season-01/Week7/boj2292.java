// [BOJ2292] 벌집
// Memory: 14280KB
package Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int answer = 1;
        int roomNo = 2;

        if (N == 1) {
            System.out.println(answer);
        } else {
            while (roomNo <= N) {
                roomNo += 6 * answer;
                answer++;
            }
            System.out.println(answer);
        }
    }
}