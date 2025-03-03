package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class boj10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            members.add(new Member(age, name, i)); // i는 가입 순서
        }

        // 정렬: 나이 순으로, 나이가 같으면 가입 순서 순으로
        Collections.sort(members, (m1, m2) -> {
            if (m1.age != m2.age) {
                return Integer.compare(m1.age, m2.age); // 나이 오름차순
            }
            return Integer.compare(m1.joinOrder, m2.joinOrder); // 가입 순서 유지
        });

        // 출력
        for (Member member : members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }

        System.out.print(sb);
    }

    static class Member {
        int age;
        String name;
        int joinOrder;

        Member(int age, String name, int joinOrder) {
            this.age = age;
            this.name = name;
            this.joinOrder = joinOrder;
        }
    }
}