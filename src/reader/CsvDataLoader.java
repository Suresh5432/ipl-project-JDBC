package reader;

import model.Deliveries;
import model.Matches;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CsvDataLoader {
    private List<Matches> matchesData;
    private List<Deliveries> deliveriesData;
    public CsvDataLoader() {
       CsvFileReader reader=new CsvFileReader();
        CompletableFuture<List<Matches>> matchesFuture=CompletableFuture.
                supplyAsync(()->reader.readMatchesData());
        CompletableFuture<List<Deliveries>> deliveriesFuture=CompletableFuture.
                supplyAsync(()->reader.readDeliveriesData());
        matchesData =matchesFuture.join();
        deliveriesData=deliveriesFuture.join();
    }
    public List<Matches> getMatchesData() {
        return matchesData;
    }
    public List<Deliveries> getDeliveriesData() {
        return deliveriesData;
    }
}
