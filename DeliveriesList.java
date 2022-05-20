import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeliveriesList {

public static List<Deliveries> deliveriesdata = new ArrayList<>();

public void readData(){
    String csvFile = "/home/pranay/Downloads/deliveries.csv";
    BufferedReader br = null;
    String line = "";
    String csvSplitBy = ",";
    int skip =0;

    try{
        br =new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            if(skip ==0){
                skip++;
                continue;

            }
            String[] deliveries = line.split(csvSplitBy);
            this.storeData(deliveries);

        }
    }

    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    finally {
        if (br != null) {
            try {
                br.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
public void storeData(String[] data) {

    Deliveries deliveries = new Deliveries();

    deliveries.setMatch_id(Integer.parseInt(data[0]));
    deliveries.setInning(Integer.parseInt(data[1]));
    deliveries.setBatting_team(data[2]);
    deliveries.setBowling_team(data[3]);
    deliveries.setOver(Integer.parseInt(data[4]));
    deliveries.setBall(Integer.parseInt(data[5]));
    deliveries.setBatsman(data[6]);
    deliveries.setNon_striker(data[7]);
    deliveries.setBowler(data[8]);
    deliveries.setIs_super_over(Integer.parseInt(data[9]));
    deliveries.setWide_runs(Integer.parseInt(data[10]));
    deliveries.setBye_runs(Integer.parseInt(data[11]));
    deliveries.setLegbye_runs(Integer.parseInt(data[12]));
    deliveries.setNoball_runs(Integer.parseInt(data[13]));
    deliveries.setPenalty_runs(Integer.parseInt(data[14]));
    deliveries.setBatsman_runs(Integer.parseInt(data[15]));
    deliveries.setExtra_runs(Integer.parseInt(data[16]));
    deliveries.setTotal_runs(Integer.parseInt(data[17]));


    deliveriesdata.add(deliveries);

}
public static List<Deliveries> getDeliveriesList(){
    DeliveriesList d= new DeliveriesList();
    d.readData();
    return deliveriesdata;
}


}
