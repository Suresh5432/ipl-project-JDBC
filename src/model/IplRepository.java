package model;

import database.DatabaseConnection;
import reader.CsvDataLoader;
import reader.CsvFileReader;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
public class IplRepository {
    public void insertRecords(){
        CsvFileReader reader = new CsvFileReader();
        insertMatchesData(reader.readMatchesData());
        insertDeliveriesData(reader.readDeliveriesData());
    }
    private void insertMatchesData(List<Match> matches) {
        String query = """
        INSERT INTO matches (
            match_id, season, city, date, team1, team2,
            tossWinner, tossDecision, result, diApplied,
            winner, winByRuns, winByWickets, playerOfMatch,
            venue, umpire1, umpire2, umpire3
        )
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
        ON CONFLICT(match_id) DO NOTHING
        """;
        try(Connection connection= DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(query)){
            for(Match data:matches){
                statement.setInt(1,data.matchId());
                statement.setInt(2, data.season());
                statement.setString(3, data.city());
                statement.setDate(4, Date.valueOf(data.date()));
                statement.setString(5, data.team1());
                statement.setString(6, data.team2());
                statement.setString(7, data.tossWinner());
                statement.setString(8, data.tossDecision());
                statement.setString(9, data.result());
                statement.setInt(10, data.diApplied());
                statement.setString(11, data.winner());
                statement.setInt(12, data.winByRuns());
                statement.setInt(13, data.winByWickets());
                statement.setString(14,data.playerOfMatch());
                statement.setString(15, data.venue());
                statement.setString(16, data.umpire1());
                statement.setString(17, data.umpire2());
                statement.setString(18, data.umpire3());
                statement.addBatch();
            }
            int[] value=statement.executeBatch();
            if(value.length==0) {
                System.out.println("failed to insert matches data");
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void insertDeliveriesData(List<Delivery> deliveries) {
        String query = """
        INSERT INTO deliveries (
            match_id,
            inning,
            battingTeam,
            bowlingTeam,
            over,
            ball,
            batsman,
            nonStriker,
            bowler,
            isSuperOver,
            wideRuns,
            byesRuns,
            legByesRuns,
            noBallRuns,
            penaltyRuns,
            batsmenRuns,
            extraRuns,
            totalRuns,
            playerDismissed,
            dismissalKind,
            fielder
        )
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) 
        ON CONFLICT(match_id,over,ball,inning) DO NOTHING
        """;
        try(Connection connection =DatabaseConnection.getConnection();
            PreparedStatement statement=connection.prepareStatement(query)) {
            for(Delivery delivery: deliveries) {
                statement.setInt(1, delivery.matchId());
                statement.setInt(2, delivery.inning());
                statement.setString(3, delivery.battingTeam());
                statement.setString(4, delivery.bowlingTeam());
                statement.setInt(5, delivery.over());
                statement.setInt(6, delivery.ball());
                statement.setString(7, delivery.batsman());
                statement.setString(8, delivery.nonStriker());
                statement.setString(9, delivery.bowler());
                statement.setInt(10, delivery.isSuperOver());
                statement.setInt(11, delivery.wideRuns());
                statement.setInt(12, delivery.byesRuns());
                statement.setInt(13, delivery.legByesRuns());
                statement.setInt(14, delivery.noBallRuns());
                statement.setInt(15, delivery.penaltyRuns());
                statement.setInt(16, delivery.batsmenRuns());
                statement.setInt(17, delivery.extraRuns());
                statement.setInt(18, delivery.totalRuns());
                statement.setString(19, delivery.playerDismissed());
                statement.setString(20, delivery.dismissalKind());
                statement.setString(21, delivery.fielder());
                statement.addBatch();
            }
            int[] value=statement.executeBatch();
            if(value.length==0) {
                System.out.println("Failed to insert deliveries data");
            }
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
