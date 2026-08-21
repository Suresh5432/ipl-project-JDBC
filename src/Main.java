import database.CreateTables;
import model.IplRepository;
import service.ScenarioHandler;

public class Main {
    public static void main(String[] args) {

        CreateTables create = new CreateTables();

        create.createTables();

        IplRepository repository = new IplRepository();
        repository.insertRecords();

        ScenarioHandler scenarioHandler = new ScenarioHandler();

        scenarioHandler.getIplAnalysis();

    }
}
