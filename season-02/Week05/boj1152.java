/*
    25. 3. 9.
    [BOJ-1152] 단어의 개수
    -- 입력이 문자 하나이거나, 공백으로만 주어지는 경우를 유의해 처리하기
 */
package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1152 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        String input = br.readLine();

        if (input.isBlank()) {
            System.out.println(0);
        } else {
            if (input.startsWith(" ") || input.endsWith(" ")) {
                input = input.strip();
            }
            String[] inputArr = input.split(" ");
            for(String str: inputArr) {
                count ++;
            }
            System.out.println(count);
        }
    }

}
