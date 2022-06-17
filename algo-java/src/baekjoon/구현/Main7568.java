package baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main7568 {
    static int N;
    static List<Person> persons = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Person p = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            persons.add(p);
        }

        updateNumber();

        for (Person person : persons) {
            System.out.print(person.number + " ");
        }
    }
    private static void updateNumber() {
        for(int i = 0; i < N; i++){
            Person standardPerson = persons.get(i);
            int moreBigPeopleCount = 0;
            for(int j = 0; j < N; j++){
                if(j == i) continue;
                Person comparePerson = persons.get(j);
                if(standardPerson.weight < comparePerson.weight && standardPerson.height < comparePerson.height){
                    moreBigPeopleCount++;
                }
            }
            if(moreBigPeopleCount > 0){
                standardPerson.number = moreBigPeopleCount + 1; // 등수 업데이트
            }
        }
    }
}

class Person{
    int number = 1;
    int weight;
    int height;

    public Person(int weight, int height){
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "number=" + number +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}

/**
 * N 최대 50, N^2 -> 2500 -> 브루트포스 ok
 *
 * 자신보다 덩치큰 사람의 수 + 1이 자신의 등수이다.
 */