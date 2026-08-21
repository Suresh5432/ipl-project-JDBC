package database;

import model.Deliveries;
import model.IplRepository;
import model.Matches;
import reader.CsvDataLoader;

import java.util.List;

public class DataInserter {
    public void insertData(){
        CsvDataLoader csvDataLoader = new CsvDataLoader();
        List<Matches> matchesData=csvDataLoader.getMatchesData();
        List<Deliveries> deliveriesData=csvDataLoader.getDeliveriesData();
        IplRepository insert=new IplRepository();
        insert.insertMatchesData(matchesData);
        insert.insertDeliveriesData(deliveriesData);
    }
}
