import java.util.ArrayList;

public class Team {
    private ArrayList<String> lineup;
    private ArrayList<String> startingLineup;

    public ArrayList<String> getLineup() { return lineup; }
    public ArrayList<String> getStartingLineup() { return startingLineup; }
    public void resetLineup() { lineup = startingLineup; }

    private String teamName;
    public String getTeamName() { return teamName; }

    public Team() {
        lineup = new ArrayList<String>();
        startingLineup = new ArrayList<String>();
    }

    public void addToLineup(String s) {
        lineup.add(s);
        startingLineup.add(s);
    }

    public void rotate() {
        String temp = lineup.get(0);
        for (int i = 0; i < 5; i++) {
            lineup.set(i, lineup.get(i + 1));
        }
        lineup.set(5, temp);
    }
}