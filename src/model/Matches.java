package model;
public record Matches
        (Integer matchId,
         Integer season,
         String city,
         String date,
         String team1,
         String team2,
         String tossWinner,
         String tossDecision,
         String result,
         Integer diApplied,
         String winner,
         Integer winByRuns,
         Integer winByWickets,
         String playerOfMatch,
         String venue,
         String umpire1,
         String umpire2,
         String umpire3){
}
