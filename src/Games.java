package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Games {

    public Games() {
    }

    public int playGroupGames() {
        int ret = 0, pow10 = 1;
        Group g = new Group();
        g.playAllGamesAtOnce();
        g.processResults();
        int res[] = g.groupOutcome();
        Arrays.sort(res);
        for (int r : res) 
        {
            ret += r * pow10;
            pow10 *= 10;
        }
        return ret;
    }

    public void searchPossibilities() {
        Set<Integer> possibilities = new HashSet<>();
        int c = 0;

        while (c++ < 4000) // may c++ survive till 4000?
            possibilities.add(playGroupGames());

        List<Integer> list = new ArrayList<>(possibilities);
        Collections.sort(list);  c = 0;
        for (Integer k : list) {
            c++;
            System.out.println(c + " : " + k);
        }
    }

    public static void main(String[] args) {
        new Games().searchPossibilities();
    }
}
