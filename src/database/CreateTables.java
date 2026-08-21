package database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateTables {
    public void createMatchesTable(){
        String query="CREATE TABLE IF NOT EXISTS matches( " +
                "match_id INTEGER PRIMARY KEY," +
                "season INTEGER,"+
                "city VARCHAR(40)," +
                "date DATE," +
                "team1  VARCHAR(100)," +
                "team2 VARCHAR(100)," +
                "tossWinner VARCHAR(100)," +
                "tossDecision VARCHAR(100)," +
                "result VARCHAR(100)," +
                "diApplied INTEGER," +
                "winner VARCHAR(100)," +
                "winByRuns INTEGER," +
                "winByWickets INTEGER," +
                "playerOfMatch VARCHAR(100)," +
                "venue VARCHAR(300)," +
                "umpire1 VARCHAR(50)," +
                "umpire2 VARCHAR(50)," +
                "umpire3 VARCHAR(50))";
        try(Connection connection=DatabaseConnection.getConnection();
            Statement statement=connection.createStatement()){
            statement.executeUpdate(query);
        }
        catch (SQLException e){
            System.err.println("Matches Table Creation Failed");
        }
    }
    public void createDeliveriesTable(){
        String query="CREATE TABLE IF NOT EXISTS deliveries("+
                    "match_id INTEGER NOT NULL," +
                    "inning INTEGER NOT NULL," +
                    "battingTeam VARCHAR(50)," +
                    "bowlingTeam VARCHAR(50),"+
                    "over INTEGER," +
                    "ball INTEGER," +
                    "batsman VARCHAR(50)," +
                    "nonStriker VARCHAR(50)," +
                    "bowler VARCHAR(50)," +
                    "isSuperOver INTEGER," +
                    "wideRuns INTEGER," +
                    "byesRuns INTEGER," +
                    "legByesRuns INTEGER," +
                    "noBallRuns INTEGER," +
                    "penaltyRuns INTEGER," +
                    "batsmenRuns INTEGER," +
                    "extraRuns INTEGER," +
                    "totalRuns INTEGER," +
                    "playerDismissed VARCHAR(50)," +
                    "dismissalKind VARCHAR(50)," +
                    "fielder VARCHAR(50)," +
                    "UNIQUE (match_id,over,ball,inning)," +
                    "FOREIGN KEY (match_id) REFERENCES matches(match_id))";
        try(Connection connection=DatabaseConnection.getConnection();
            Statement statement=connection.createStatement()){
            statement.executeUpdate(query);
        }
        catch (SQLException e){
            System.err.println("Deliveries Table Creation Failed");
            System.out.println(e.getMessage());
        }

    }
}
