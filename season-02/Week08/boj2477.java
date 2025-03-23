/*
    DATE: 2025-03-23
    [BOJ-2477-SILVER-2] 참외밭
    - 🚀메모리 14264 KB / ⌛️시간 104 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2477 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int koreaMelonYield = Integer.parseInt(br.readLine()); // 참외 수확량
        int[] dirCnt = new int[5]; // {0, 2, 1, 2, 1};
        int[] dir = new int[7]; // {4, 2, 3, 1, 3, 1}
        int[] length = new int[7]; // {50, 160, 30, 60, 20, 100}

        for (int i = 1; i <= 6; i++) {
            String[] input = br.readLine().split(" ");
            dir[i] = Integer.parseInt(input[0]);
            length[i] = Integer.parseInt(input[1]);
            dirCnt[dir[i]] += 1;
        }

        int originalArea = 1;
        int exceptArea = 1;
        for (int i = 1; i <= 6; i++) {
            if (dirCnt[dir[i]] != 1) continue; // dir의 원소값이 dirCnt의 인덱스
            originalArea *= length[i];
            exceptArea *= length[i + 3 > 6 ? i - 3 : i +3];
        }

        System.out.println(koreaMelonYield * (originalArea - exceptArea));
    }
}
