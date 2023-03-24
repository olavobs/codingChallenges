package algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// We're asked to imagine there is an algorithms tournament in which multiple teams compete against each other. In each competition there will be two teams that compete. There will be one winner and one
// loser out of all of these competitions and there are no ties. Each team will compete against all other teams exactly once. A team gets 3 points for each competition it wins and 0 points for each competition
// it loses. It's guaranteed that the tournament always has at least two teams and there will be only one tournament winner.
//
// We are given two inputs, the competitions array and the results array. We need to write a function that returns the winner of the tournament, or more specifically, the name of the team that has the
// most number of points. The competitions array is an array of pairs, representing all of the competitions in the tournament. Inside of these pairs, we have two strings: the first one is the name of the
// home team and the second one is the name of the away team. The results array represents the winner of each of these competitions. Inside the results array, a 1 means that the home team won and a 0 means
// the away team won. The results array is the same length as the competitions array, and the indices in the results array correspond with the indices in the competitions array.

public class TournamentWinner {
    public static void main(String[] args) {
        ArrayList<String> one = new ArrayList();
        one.add("HTML");
        one.add("C#");

        ArrayList<String> two = new ArrayList();
        two.add("C#");
        two.add("Python");

        ArrayList<String> three = new ArrayList();
        three.add("Python");
        three.add("HTML");

        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        competitions.add(one);
        competitions.add(two);
        competitions.add(three);

        ArrayList<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(0);
        results.add(1);

        System.out.println(tournamentWinner(competitions, results));

    }

    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> scores = new HashMap<>();

        String team, winner = "";

        for (int i = 0; i < competitions.size(); i++) {
            team = competitions.get(i).get(results.get(i) == 0 ? 1 : 0);
            scores.put(team, scores.getOrDefault(team, 0) + 3);
            winner = scores.get(team) > scores.getOrDefault(winner, 0) ? team : winner;
        }
        
        return winner;
    }

}
