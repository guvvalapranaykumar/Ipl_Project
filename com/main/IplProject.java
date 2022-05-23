package com.main;

import com.model.Deliveries;
import com.model.Matches;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class IplProject {

    public static final int MATCH_ID = 0;
    public static final int SEASON = 1;
    public static final int CITY = 2;
    public static final int DATE = 3;
    public static final int TEAM1 = 4;
    public static final int TEAM2 = 5;
    public static final int TOSS_WINNER = 6;
    public static final int TOSS_DECISION = 7;
    public static final int RESULT = 8;
    public static final int DL_APPLIED = 9;
    public static final int WINNER = 10;
    public static final int WIN_BY_RUNS = 11;
    public static final int WIN_BY_WICKETS = 12;
    public static final int PLAYER_OF_MATCH = 13;
    public static final int VENUE = 14;

    public static final int INNING = 1;
    public static final int BATTING_TEAM = 2;
    public static final int BOWLING_TEAM = 3;
    public static final int OVER = 4;
    public static final int BALL = 5;
    public static final int BATSMAN = 6;
    public static final int NON_STRIKER = 7;
    public static final int BOWLER = 8;
    public static final int IS_SUPER_OVER = 9;
    public static final int WIDE_RUNS = 10;
    public static final int BYE_RUNS = 11;
    public static final int LEG_BYE_RUNS = 12;
    public static final int NO_BALL_RUNS = 13;
    public static final int PENALTY_RUNS = 14;
    public static final int BATSMAN_RUNS = 15;
    public static final int EXTRA_RUNS = 16;
    public static final int TOTAL_RUNS = 17;


    public static void findAllMatchesHappenedOfAllYears(List<Matches> matchesDataList) {
        Map<String, Integer> yearAndCorrespondingMatches = new TreeMap();

        for (int i = 0; i < matchesDataList.size(); i++) {
            String year = matchesDataList.get(i).getSeason();
            if (yearAndCorrespondingMatches.containsKey(year)) {
                int value = yearAndCorrespondingMatches.get(year);
                yearAndCorrespondingMatches.put(year, value + 1);
            } else {
                yearAndCorrespondingMatches.put(year, 1);
            }
        }

        System.out.println("Number of matches played per year of all the years in IPL");
        System.out.println(yearAndCorrespondingMatches);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void findMatchesWonByAllTeamsOfAllYears(List<Matches> matchesDataList) {
        Map<String, Integer> matchesWonByTeam = new TreeMap<>();
        for (int i = 0; i < matchesDataList.size(); i++) {
            String team1 = matchesDataList.get(i).getTeam1();
            if (!(matchesWonByTeam.containsKey(team1))) {
                matchesWonByTeam.put(team1, 0);
            }
        }
        for (int i = 0; i < matchesDataList.size(); i++) {
            String winner = matchesDataList.get(i).getWinner();
            if ((matchesWonByTeam.containsKey(winner))) {
                int value = matchesWonByTeam.get(winner);
                matchesWonByTeam.put(winner, value + 1);
            }
        }
        System.out.println("Number of matches won of all teams over all the years of IPL");
        System.out.println(matchesWonByTeam);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    public static void findExtraRunsConciededPerTeamIn2016(List<Matches> matchesDataList, List<Deliveries> deliveriesDataList) {
        Map<String, Integer> extraRunsPerBattingTeam = new HashMap<>();
        List<Integer> matchIds = new ArrayList();

        for (int i = 0; i < matchesDataList.size(); i++) {
            if (matchesDataList.get(i).getSeason().equals("2016")) {
                matchIds.add(matchesDataList.get(i).getId());
                if (!(extraRunsPerBattingTeam.containsKey(matchesDataList.get(i).getTeam1()))) {
                    extraRunsPerBattingTeam.put(matchesDataList.get(i).getTeam1(), 0);
                }
            }
        }
        for (Integer id : matchIds) {
            for (Deliveries details : deliveriesDataList) {
                if (details.getMatchId() == id) {
                    String battingTeamName = details.getBattingTeam();
                    int totalRuns = details.getExtraRuns();
                    int securedRuns = extraRunsPerBattingTeam.get(battingTeamName);
                    extraRunsPerBattingTeam.put(battingTeamName, totalRuns + securedRuns);
                }
            }
        }
        System.out.println("extra runs conceded per team for year 2016\n" + extraRunsPerBattingTeam);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void findTopEconomical3Bowlers(List<Matches> matchesDataList, List<Deliveries> deliveriesDataList) {
        List<Integer> matchIds = new ArrayList();

        for (int i = 0; i < matchesDataList.size(); i++) {
            if (matchesDataList.get(i).getSeason().equals("2015")) {
                matchIds.add(matchesDataList.get(i).getId());
            }
        }

        Map<String, Integer> bowlerAndNumberOfBalls = new HashMap<>();
        Map<String, Integer> bowlerAndGivenRuns = new HashMap<>();
        for (Integer id : matchIds) {
            for (Deliveries details : deliveriesDataList) {
                if (details.getMatchId() == id) {
                    String bowler = details.getBowler();
                    int numberOfTotalRuns = details.getTotalRuns();
                    if (bowlerAndNumberOfBalls.containsKey(bowler)) {
                        int numberOfBalls = bowlerAndNumberOfBalls.get(bowler);
                        int alreadyGivenRuns = bowlerAndGivenRuns.get(bowler);
                        bowlerAndNumberOfBalls.put(bowler, numberOfBalls + 1);
                        bowlerAndGivenRuns.put(bowler, numberOfTotalRuns + alreadyGivenRuns);

                    } else {
                        bowlerAndNumberOfBalls.put(bowler, 1);
                        bowlerAndGivenRuns.put(bowler, details.getTotalRuns());
                    }
                }
            }
        }

        Set<String> bowlerNames = bowlerAndNumberOfBalls.keySet();
        Map<Double, String> ec = new TreeMap<>();
        for (String name : bowlerNames) {
            double runs = bowlerAndGivenRuns.get(name);
            double balls = bowlerAndNumberOfBalls.get(name);
            int noOfOvers = (int) balls / 6;
            double remainedBalls = balls % 6;
            double remainedOvers = remainedBalls / 6;
            double wholeOvers = remainedOvers + noOfOvers;
            double economy = runs / wholeOvers;
            ec.put(economy, name);
        }
        TreeMap<Double, String> economyOf3Bowlers = new TreeMap<>();
        Set<Double> economyOfBowlers = ec.keySet();
        int count = 0;
        for (Double economy : economyOfBowlers) {
            count++;
            economyOf3Bowlers.put(economy, ec.get(economy));
            if (count == 3) {
                break;
            }
        }
        System.out.println("Top 3 economical bowlers in 2015\n" + economyOf3Bowlers);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void findRunsMadeByWarnerInAllYears(List<Deliveries> deliveriesDataList) {
        int totalRunsScoredByWarner = 0;
        for (Deliveries details : deliveriesDataList) {
            if (details.getBatsman().equals("DA Warner")) {
                totalRunsScoredByWarner = totalRunsScoredByWarner + details.getBatsmanRuns();
            }
        }

        System.out.println("Total runs scored by warner over all the matches in all years");
        System.out.println(totalRunsScoredByWarner);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }


    public static void main(String[] args) {
        List<Deliveries> deliveriesDataList = getDeliveriesList();
        List<Matches> matchesDataList = getMatchesList();
        findAllMatchesHappenedOfAllYears(matchesDataList);
        findMatchesWonByAllTeamsOfAllYears(matchesDataList);
        findExtraRunsConciededPerTeamIn2016(matchesDataList, deliveriesDataList);
        findTopEconomical3Bowlers(matchesDataList, deliveriesDataList);
        findRunsMadeByWarnerInAllYears(deliveriesDataList);


    }

    public static List<Matches> getMatchesList() {
        List<Matches> matchesData = new ArrayList<Matches>();
        return readDataOfMatchesFile();
    }

    private static List<Matches> readDataOfMatchesFile() {
        String csvFile = "/home/pranay/Downloads/matches.csv";
        List<Matches> matchesData = new ArrayList<Matches>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int skip = 0;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                if (skip == 0) {
                    skip++;
                    continue;
                }

                String[] match = line.split(cvsSplitBy);
                matchesData.add(storeDataIntoMatchesList(match));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return matchesData;
    }

    private static Matches storeDataIntoMatchesList(String[] data) {

        Matches matchDetails = new Matches();

        matchDetails.setId((Integer.parseInt(data[MATCH_ID])));
        matchDetails.setSeason(data[SEASON]);
        matchDetails.setCity(data[CITY]);
        matchDetails.setDate(data[DATE]);
        matchDetails.setTeam1(data[TEAM1]);
        matchDetails.setTeam2(data[TEAM2]);
        matchDetails.setTossWinner(data[TOSS_WINNER]);
        matchDetails.setTossDecision(data[TOSS_DECISION]);
        matchDetails.setResult(data[RESULT]);
        matchDetails.setDlApplied(Integer.parseInt(data[DL_APPLIED]));
        matchDetails.setWinner(data[WINNER]);
        matchDetails.setWinByRuns(Integer.parseInt(data[WIN_BY_RUNS]));
        matchDetails.setWinByWickets(Integer.parseInt(data[WIN_BY_WICKETS]));
        matchDetails.setPlayerOfMatch(data[PLAYER_OF_MATCH]);
        matchDetails.setVenue(data[VENUE]);

        return matchDetails;
    }

    public static List<Deliveries> getDeliveriesList() {

        List<Deliveries> deliveriesData = new ArrayList<>();

        return readDataOfDeliveriesFile();
    }

    private static List<Deliveries> readDataOfDeliveriesFile() {

        String csvFile = "/home/pranay/Downloads/deliveries.csv";
        List<Deliveries> deliveriesDataList = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";
        int skip = 0;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                if (skip == 0) {
                    skip++;
                    continue;

                }
                String[] deliveries = line.split(csvSplitBy);
                deliveriesDataList.add(storeDataIntoDeliveriesList(deliveries));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return deliveriesDataList;
    }

    private static Deliveries storeDataIntoDeliveriesList(String[] data) {

        Deliveries deliveriesDetails = new Deliveries();

        deliveriesDetails.setMatchId(Integer.parseInt(data[MATCH_ID]));
        deliveriesDetails.setInning(Integer.parseInt(data[INNING]));
        deliveriesDetails.setBattingTeam(data[BATTING_TEAM]);
        deliveriesDetails.setBowlingTeam(data[BOWLING_TEAM]);
        deliveriesDetails.setOver(Integer.parseInt(data[OVER]));
        deliveriesDetails.setBall(Integer.parseInt(data[BALL]));
        deliveriesDetails.setBatsman(data[BATSMAN]);
        deliveriesDetails.setNonStriker(data[NON_STRIKER]);
        deliveriesDetails.setBowler(data[BOWLER]);
        deliveriesDetails.setIsSuperOver(Integer.parseInt(data[IS_SUPER_OVER]));
        deliveriesDetails.setWideRuns(Integer.parseInt(data[WIDE_RUNS]));
        deliveriesDetails.setByeRuns(Integer.parseInt(data[BYE_RUNS]));
        deliveriesDetails.setLegbyeRuns(Integer.parseInt(data[LEG_BYE_RUNS]));
        deliveriesDetails.setNoballRuns(Integer.parseInt(data[NO_BALL_RUNS]));
        deliveriesDetails.setPenaltyRuns(Integer.parseInt(data[PENALTY_RUNS]));
        deliveriesDetails.setBatsmanRuns(Integer.parseInt(data[BATSMAN_RUNS]));
        deliveriesDetails.setExtraRuns(Integer.parseInt(data[EXTRA_RUNS]));
        deliveriesDetails.setTotalRuns(Integer.parseInt(data[TOTAL_RUNS]));

        return deliveriesDetails;
    }

}
