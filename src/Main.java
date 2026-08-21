import database.DataInserter;
import database.CreateTables;
import service.ScenarioHandler;

void main() {
//    CreateTables createTables = new CreateTables();
//    createTables.createMatchesTable();
//    createTables.createDeliveriesTable();
//    DataInserter dataInserter = new DataInserter();
//    dataInserter.insertData();
    ScenarioHandler scenarioHandler = new ScenarioHandler();
    scenarioHandler.getIplAnalysis();
}
