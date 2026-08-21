package service;

import database.DatabaseConnection;

import java.sql.*;

public class ScenarioRunner{

    // first one
    public void getMatchesPlayedPerYear() {
        String query="SELECT season, COUNT (match_id) "+
                    "FROM matches "+
                    "GROUP BY season "+
                    "ORDER BY season";
        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet result=statement.executeQuery(query);
            while(result.next()) {
                System.out.println("In "+result.getString(1)+" year the number matches played is "
                        +result.getLong(2));
            }
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    //second one
    public void getMatchesWonByTeam() {
        String query="SELECT winner, COUNT(*) FROM matches " +
                    "WHERE winner is not null " +
                    "GROUP BY winner " +
                    "ORDER BY COUNT(*) DESC";
        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet result=statement.executeQuery(query);
            while(result.next()) {
                System.out.println(result.getString(1)+" Has Won total "+
                        result.getLong(2)+" Matches");
            }
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public void getExtraRunsConcededByTeam(int year) {
        String query="SELECT d.bowlingTeam, SUM(extraRuns) AS extraRuns FROM matches m " +
                    "JOIN deliveries d ON m.match_id=d.match_id " +
                    "WHERE m.season=? " +
                    "GROUP BY d.bowlingTeam " +
                    "ORDER BY SUM(extraRuns) DESC ";
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, year);
            ResultSet result=statement.executeQuery();
            System.out.println("Extra runs conceded by each team in 2016: : ");
            while(result.next()) {
                System.out.println("The Team "+result.getString(1)+" has conceded total of "+
                        result.getLong(2)+" runs");
            }
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
    public void getTopEconomicalBowlers(int year) {
        String query="SELECT bowler,ROUND((runs/overs),2) AS economy " +
                    "FROM (SELECT d.bowler, count(*) filter " +
                    "(where d.wideRuns=0 AND d.noballRuns=0)/6.0 AS overs, " +
                    "SUM( " +
                    "d.totalRuns- " +
                    "d.penaltyRuns- " +
                    "d.byesRuns- " +
                    "d.legByesRuns) AS runs " +
                    "FROM  matches m " +
                    "JOIN deliveries d ON d.match_id=m.match_id " +
                    "WHERE m.season=? " +
                    "GROUP BY d.bowler) AS economydata " +
                    "ORDER BY economy " +
                    "LIMIT 10;";
        try(Connection connection=DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, year);
            ResultSet result=statement.executeQuery();
            System.out.println("Top 10 most economical bowlers in the year "+year+" are : ");
            while(result.next()) {
                System.out.println("The player "+result.getString(1)+" has the economy of "+
                        result.getDouble(2));
            }
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
