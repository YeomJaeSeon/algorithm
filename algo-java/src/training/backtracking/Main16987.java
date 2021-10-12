package training.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16987 {
    static int N;
    static Egg[] eggs;
    static int max = 0;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        eggs = new Egg[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        play(0);

        System.out.println(max);
    }
    static void play(int grabPosition){
        if(grabPosition == N){
            // 오른쪽 끝 계란을 잡고 치면 끝
            max = Math.max(max, countBrokenEggs());
            return;
        }

        if(eggs[grabPosition].s <= 0 || (eggs[grabPosition ].s > 0 && countBrokenEggs() == N - 1))
            // 손에든 달걀이 깨져있거나, 손에든 달걀은 꺠지지않았는데, 나머지 달걀이 모두 깨져있으면 계란치지말고 다음 계란 포이터로 넘어감
            play(grabPosition + 1);
        else {
            // 계란 치기
            for (int i = 0; i < N; i++) {
                if (grabPosition == i) continue; // 자기 자신은 못친다
                if (eggs[i].s <= 0) continue; // 칠 계란이 이미 깨져있음

                //계란2개 모두 무게줄이기
                eggs[grabPosition].s -= eggs[i].w;
                eggs[i].s -= eggs[grabPosition].w;

                play(grabPosition + 1); // recursive

                //계란 2개 무게 원복
                eggs[grabPosition].s += eggs[i].w;
                eggs[i].s += eggs[grabPosition].w;
            }
        }
    }
    static int countBrokenEggs(){
        int count = 0;
        for (Egg egg : eggs) {
            if(egg.s <= 0) count++;
        }
        return count;
    }
}

class Egg{
    int s; // 내구도
    int w; // 무게

    Egg(int s, int w) {
        this.s = s;
        this.w = w;
    }
}
