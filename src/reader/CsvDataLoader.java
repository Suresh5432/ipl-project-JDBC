package reader;

import model.Delivery;
import model.Match;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CsvDataLoader {
    private List<Match> matchesData;
    private List<Delivery> deliveriesData;
    public CsvDataLoader() {
       CsvFileReader reader=new CsvFileReader();
        CompletableFuture<List<Match>> matchesFuture=CompletableFuture.
                supplyAsync(()->reader.readMatchesData());
        CompletableFuture<List<Delivery>> deliveriesFuture=CompletableFuture.
                supplyAsync(()->reader.readDeliveriesData());
        matchesData =matchesFuture.join();
        deliveriesData=deliveriesFuture.join();
    }
    public List<Match> getMatchesData() {
        return matchesData;
    }
    public List<Delivery> getDeliveriesData() {
        return deliveriesData;
    }
}
