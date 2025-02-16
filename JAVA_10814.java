import java.util.*;

public class JAVA_10814 {
    // Person 클래스: 나이와 이름을 저장
    static class Person {
        int age;
        String name;
        
        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] persons = new Person[n];
        
        // 입력 받기
        for (int i = 0; i < n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            persons[i] = new Person(age, name);
        }
        
        // 나이를 기준으로 정렬 (같은 나이일 경우 입력 순서 유지 - 안정 정렬)
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.age - b.age; // 오름차순 정렬
            }
        });
        
        // 빠른 출력을 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for (Person p : persons) {
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }
        System.out.print(sb);
    }
}
