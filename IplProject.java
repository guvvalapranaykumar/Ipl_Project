import java.util.*;

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
        System.out.println("Number of matches played per year of all the years in IPL");
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
        System.out.println("Number of matches won of all teams over all the years of IPL");
        System.out.println(matcheswonbyteam);

    }

    //For the year 2016 get the extra runs conceded per team.

    public static void extrarunsperteam(){
        HashMap<String,Integer> extraruns= new HashMap<>();
        List<Integer> matchids=new ArrayList();
        for(int i=0;i<matchesdat.size();i++){
            if(matchesdat.get(i).getSeason().equals("2016")){
                matchids.add(matchesdat.get(i).getId());
                if(!(extraruns.containsKey(matchesdat.get(i).getTeam1()))){
                    extraruns.put(matchesdat.get(i).getTeam1(),0);
                }
            }
        }
        for(Integer id:matchids){
            for(Deliveries dd:deliveriesdat){
                if(dd.getMatch_id()==id){
                    String battingteam=dd.getBatting_team();
                    int totalruns=dd.getExtra_runs();
                    int securedruns=extraruns.get(battingteam);
                    extraruns.put(battingteam,totalruns+securedruns);
                }
            }
        }
        System.out.println("extra runs conceded per team for year 2016\n"+extraruns);
    }
//    For the year 2015 get the top economical bowlers.
    public static void topeconomical3bowlers(){
        List<Integer> matchids=new ArrayList();
        for(int i=0;i<matchesdat.size();i++){
            if(matchesdat.get(i).getSeason().equals("2015")){
                matchids.add(matchesdat.get(i).getId());}}
            HashMap<String,Integer> bowlerandnumofballs=new HashMap<>();
        HashMap<String,Integer> bowlerandgivenruns=new HashMap<>();
        for(Integer id:matchids) {
            for (Deliveries d : deliveriesdat) {
                if (d.getMatch_id() ==id) {
                    String bowler = d.getBowler();
                    int nooftotalruns = d.getTotal_runs();
                    if (bowlerandnumofballs.containsKey(bowler)) {
                        int noofballs = bowlerandnumofballs.get(bowler);
                        int alreadygivenruns = bowlerandgivenruns.get(bowler);
                        bowlerandnumofballs.put(bowler, noofballs + 1);
                        bowlerandgivenruns.put(bowler, nooftotalruns + alreadygivenruns);

                    } else {
                        bowlerandnumofballs.put(bowler, 1);
                        bowlerandgivenruns.put(bowler, d.getTotal_runs());
                    }
                }
            }
        }
        //logic for most economical bowlers
        Set<String> bowlernames=bowlerandnumofballs.keySet();
        TreeMap<Double,String> ec=new TreeMap<>();
        for(String name:bowlernames){
            double runs=bowlerandgivenruns.get(name);
            double balls=bowlerandnumofballs.get(name);
            int noofovers=(int)balls/6;
            double remainedballs=balls%6;
            double remainedovers=remainedballs/6;
            double wholeovers=remainedovers+noofovers;
            double economy=runs/wholeovers;
            ec.put(economy,name);
        }
        TreeMap<Double,String> ec3=new TreeMap<>();
        Set<Double> key=ec.keySet();
        int count=0;
        for(Double o:key){
            count++;
            ec3.put(o,ec.get(o));
            if(count==3){
                break;
            }
        }
        System.out.println("Top 3 economical bowlers in 2015\n"+ec3);
    }

    //David Warners total runs over all the matches in all years
    public static void runsByWarner(){
        int totalrunsbywarner=0;
        for(Deliveries d:deliveriesdat){
            if(d.getBatsman().equals("DA Warner")){
                totalrunsbywarner=totalrunsbywarner+d.getBatsman_runs();
            }
        }
        System.out.println("Total runs scored by warner over all the matches in all years");
        System.out.println(totalrunsbywarner);
    }


    public static void main(String [] args){
        deliveriesdat=DeliveriesList.getDeliveriesList();
        matchesdat=MatchList.getMatchesList();
        matchesofallyears();
        matcheswonofallteams();
        extrarunsperteam();
        topeconomical3bowlers();
        runsByWarner();


    }
}
