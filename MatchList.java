import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchList {
    public static List<Matches> matchesdata = new ArrayList<Matches>();
    public void readData(){
        String csvfile = "/home/pranay/Downloads/matches.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int skip = 0;

        try{
            br =new BufferedReader(new FileReader(csvfile));
            while ((line = br.readLine()) != null) {

                if(skip == 0){
                    skip++;
                    continue;
                }

                String[] match = line.split(cvsSplitBy);
                this.storeData(match);

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br !=null){
                try{
                    br.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



public void storeData(String[] data) {

    Matches match =new Matches();

    match.setId((Integer.parseInt(data[0])));
    match.setSeason(data[1]);
    match.setCity(data[2]);
    match.setDate(data[3]);
    match.setTeam1(data[4]);
    match.setTeam2(data[5]);
    match.setToss_winner(data[6]);
    match.setToss_decision(data[7]);
    match.setResult(data[8]);
    match.setDl_applied(Integer.parseInt(data[9]));
    match.setWinner(data[10]);

    match.setWin_by_runs(Integer.parseInt(data[11]));

    match.setWin_by_wickets(Integer.parseInt(data[12]));

    match.setPlayer_of_match(data[13]);

    match.setVenue(data[14]);

    matchesdata.add(match);
}

    public static void main(String[] args) {
        MatchList m=new MatchList();
        m.readData();
        System.out.println(matchesdata);
    }
}