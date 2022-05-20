import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class IplProject {
    static List<Deliveries> deliveriesdat;
    static List<Matches> matchesdat;

    //Number of matches played per year of all the years in IPL
    public static void matchesofallyears(){
        TreeMap<String,Integer> yearandmatches=new TreeMap();
        for(int i=0;i<matchesdat.size();i++){
        String year=matchesdat.get(i).getSeason();
        if(yearandmatches.containsKey(year)){
            int value=yearandmatches.get(year);
            yearandmatches.put(year,value+1);
        }
        else{
            yearandmatches.put(year,1);
        }
        }
        System.out.println(yearandmatches);
    }
//    Number of matches won of all teams over all the years of IPL
    public static void matcheswonofallteams(){
        TreeMap<String,Integer> matcheswonbyteam= new TreeMap<>();
        for(int i=0;i<matchesdat.size();i++){
            String team1=matchesdat.get(i).getTeam1();
            if(!(matcheswonbyteam.containsKey(team1))){
                matcheswonbyteam.put(team1,0);
            }
        }
        for(int i=0;i<matchesdat.size();i++){
            String winner=matchesdat.get(i).getWinner();
            if((matcheswonbyteam.containsKey(winner))){
                int value=matcheswonbyteam.get(winner);
                matcheswonbyteam.put(winner,value+1);
            }
        }
        System.out.println(matcheswonbyteam);

    }

    //For the year 2016 get the extra runs conceded per team.

    public static void extrarunsperteam(){
        HashMap<String,Integer> extraruns= new HashMap<>();

    }



    public static void main(String [] args){
        deliveriesdat=DeliveriesList.getDeliveriesList();
        matchesdat=MatchList.getMatchesList();
        matchesofallyears();
        matcheswonofallteams();


    }
}
