import java.util.List;

public class IplProject {
    static List<Deliveries> deliveriesdat;
    static List<Matches> matchesdat;

    //Number of matches played per year of all the years in IPL

    public static void main(String [] args){
        deliveriesdat=DeliveriesList.getDeliveriesList();
        matchesdat=MatchList.getMatchesList();

        System.out.println( deliveriesdat.get(0).getBatting_team());
        System.out.println(matchesdat.get(2).getCity());
    }
}
