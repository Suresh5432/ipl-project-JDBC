package model;

public record Delivery
        (Integer matchId,
         Integer inning,
         String battingTeam,
         String bowlingTeam,
         Integer over,
         Integer ball,
         String batsman,
         String nonStriker,
         String bowler,
         Integer isSuperOver,
         Integer wideRuns,
         Integer byesRuns,
         Integer legByesRuns,
         Integer noBallRuns,
         Integer penaltyRuns,
         Integer batsmenRuns,
         Integer extraRuns,
         Integer totalRuns,
         String playerDismissed,
         String dismissalKind,
         String fielder) {
}
