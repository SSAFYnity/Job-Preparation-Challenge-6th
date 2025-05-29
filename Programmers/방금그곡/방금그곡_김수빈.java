import java.util.*;

public class Solution {
    static class MusicInfo {
        int duration;
        String title;

        MusicInfo(int duration, String title) {
            this.duration = duration;
            this.title = title;
        }
    }

    private static int getDuration (String start, String end) {
        String[] st = start.split(":");
        String[] en = end.split(":");
        int sh = Integer.parseInt(st[0]);
        int sm = Integer.parseInt(st[1]);
        int eh = Integer.parseInt(en[0]);
        int em = Integer.parseInt(en[1]);
        return (eh - sh) * 60 + (em - sm);
    }

    private static String convert(String melody) {
        melody = melody.replace("C#", "c");
        melody = melody.replace("D#", "d");
        melody = melody.replace("F#", "f");
        melody = melody.replace("G#", "g");
        melody = melody.replace("A#", "a");
        melody = melody.replace("B#", "b");
        return melody;
    }

    private static String makeMelody(String melody, int duration) {
        StringBuilder sb = new StringBuilder();
        int n = melody.length();
        for (int i = 0; i < duration; i++) {
            sb.append(melody.charAt(i % n));
        }
        return sb.toString();
    }


    public static String solution(String m, String[] musicinfos) {
        String[][] songs = new String[musicinfos.length][4];
        for (int i = 0; i < musicinfos.length; i++) {
            String[] song = musicinfos[i].split(",");
            songs[i] = song;
        }

        ArrayList<MusicInfo> result = new ArrayList<>();
        m = convert(m);

        int[] duration = new int[musicinfos.length];  // 재생시간
        for (int i = 0; i < musicinfos.length; i++) {
            duration[i] = getDuration(songs[i][0], songs[i][1]);
            String melody = convert(songs[i][3]);
            songs[i][3] = makeMelody(melody, duration[i]);
            if (songs[i][3].contains(m)) {
                result.add(new MusicInfo(duration[i], songs[i][2]));
            }
        }

        Collections.sort(result, (a, b) -> b.duration - a.duration);

        String answer;

        if (!result.isEmpty()) {
            answer = result.remove(0).title;
        } else {
            answer = "(None)";
        }





        return answer;
    }
    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String result = solution(m, musicinfos);
        System.out.println(result);
    }
}
