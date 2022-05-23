package com.model;

public class Deliveries {

    private int matchId;
    private int inning;
    private String battingTeam;
    private String bowlingTeam;
    private int over;
    private int ball;
    private String batsman;
    private String nonStriker;
    private String bowler;
    private int isSuperOver;
    private int wideRuns;
    private int byeRuns;
    private int legbyeRuns;
    private int noballRuns;
    private int penaltyRuns;
    private int batsmanRuns;
    private int extraRuns;
    private int totalRuns;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getInning() {
        return inning;
    }

    public void setInning(int inning) {
        this.inning = inning;
    }

    public String getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(String battingTeam) {
        this.battingTeam = battingTeam;
    }

    public String getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(String bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

    public int getOver() {
        return over;
    }

    public void setOver(int over) {
        this.over = over;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public String getBatsman() {
        return batsman;
    }

    public void setBatsman(String batsman) {
        this.batsman = batsman;
    }

    public String getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(String nonStriker) {
        this.nonStriker = nonStriker;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public int getIsSuperOver() {
        return isSuperOver;
    }

    public void setIsSuperOver(int isSuperOver) {
        this.isSuperOver = isSuperOver;
    }

    public int getWideRuns() {
        return wideRuns;
    }

    public void setWideRuns(int wideRuns) {
        this.wideRuns = wideRuns;
    }

    public int getByeRuns() {
        return byeRuns;
    }

    public void setByeRuns(int byeRuns) {
        this.byeRuns = byeRuns;
    }

    public int getLegbyeRuns() {
        return legbyeRuns;
    }

    public void setLegbyeRuns(int legbyeRuns) {
        this.legbyeRuns = legbyeRuns;
    }

    public int getNoballRuns() {
        return noballRuns;
    }

    public void setNoballRuns(int noballRuns) {
        this.noballRuns = noballRuns;
    }

    public int getPenaltyRuns() {
        return penaltyRuns;
    }

    public void setPenaltyRuns(int penaltyRuns) {
        this.penaltyRuns = penaltyRuns;
    }

    public int getBatsmanRuns() {
        return batsmanRuns;
    }

    public void setBatsmanRuns(int batsmanRuns) {
        this.batsmanRuns = batsmanRuns;
    }

    public int getExtraRuns() {
        return extraRuns;
    }

    public void setExtraRuns(int extraRuns) {
        this.extraRuns = extraRuns;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    @Override
    public String toString() {
        return "com.model.Deliveries{" +
                "matchId=" + matchId +
                ", inning=" + inning +
                ", battingTeam='" + battingTeam + '\'' +
                ", bowlingTeam='" + bowlingTeam + '\'' +
                ", over=" + over +
                ", ball=" + ball +
                ", batsman='" + batsman + '\'' +
                ", nonStriker='" + nonStriker + '\'' +
                ", bowler='" + bowler + '\'' +
                ", isSuperOver=" + isSuperOver +
                ", wideRuns=" + wideRuns +
                ", byeRuns=" + byeRuns +
                ", legbyeRuns=" + legbyeRuns +
                ", noballRuns=" + noballRuns +
                ", penaltyRuns=" + penaltyRuns +
                ", batsmanRuns=" + batsmanRuns +
                ", extraRuns=" + extraRuns +
                ", totalRuns=" + totalRuns +
                '}';
    }
}
