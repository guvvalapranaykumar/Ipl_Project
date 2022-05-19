public class Matches {
    private int id;
    private String season;
    private String city;
    private String date;
    private String team1;
    private String team2;
    private String toss_winner;
    private String toss_decision;
    private String result;
    private int dl_applied;
    private String winner;
    private int win_by_runs;
    private int win_by_wickets;
    private String player_of_match;
    private String venue;

    public int getId() {
        return id;
    }

    public String getSeason() {
        return season;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getToss_winner() {
        return toss_winner;
    }

    public String getToss_decision() {
        return toss_decision;
    }
    public String getResult() {
        return result;
    }

    public int getDl_applied() {
        return dl_applied;
    }

    public String getWinner() {
        return winner;
    }

    public int getWin_by_runs() {
        return win_by_runs;
    }

    public int getWin_by_wickets() {
        return win_by_wickets;
    }

    public String getPlayer_of_match() {
        return player_of_match;
    }

    public String getVenue() {
        return venue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public void setToss_winner(String toss_winner) {
        this.toss_winner = toss_winner;
    }

    public void setToss_decision(String toss_decision) {
        this.toss_decision = toss_decision;
    }

    @Override
    public String toString() {
        return "Matches{" +
                "id=" + id +
                ", season='" + season + '\'' +
                ", city='" + city + '\'' +
                ", date='" + date + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", toss_winner='" + toss_winner + '\'' +
                ", toss_decision='" + toss_decision + '\'' +
                ", result='" + result + '\'' +
                ", dl_applied=" + dl_applied +
                ", winner='" + winner + '\'' +
                ", win_by_runs=" + win_by_runs +
                ", win_by_wickets=" + win_by_wickets +
                ", player_of_match='" + player_of_match + '\'' +
                ", venue='" + venue + '\'' +
                '}';
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setDl_applied(int dl_applied) {
        this.dl_applied = dl_applied;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setWin_by_runs(int win_by_runs) {
        this.win_by_runs = win_by_runs;
    }

    public void setWin_by_wickets(int win_by_wickets) {
        this.win_by_wickets = win_by_wickets;
    }

    public void setPlayer_of_match(String player_of_match) {
        this.player_of_match = player_of_match;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
