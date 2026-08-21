package service;

import java.util.Scanner;

public class ScenarioHandler {
    public void getIplAnalysis(){
        ScenarioRunner manage=new ScenarioRunner();
        Scanner sc=new Scanner(System.in);
        System.out.println("===========================================================================================");
        System.out.println("                             IPL DATA ANALYSIS");
        System.out.println("===========================================================================================");
        System.out.println("1. Number of matches played per year");
        System.out.println("2. Number of matches won by each team");
        System.out.println("3. Extra runs conceded by each team in 2016");
        System.out.println("4. Top 10 economical bowlers in 2015");
        System.out.println("5. Each team win which has highest Runs and more wickets");
        System.out.println("All. to see all the outputs ");
        System.out.println("0. Exit");
        System.out.println("===========================================================================================");
        System.out.print("Enter your choice: ");
        String input=sc.next();
        switch(input){
            case "1": System.out.println("===========================================================================================");
                manage.getMatchesPlayedPerYear();
                System.out.println("===========================================================================================");
                break;
            case "2":System.out.println("===========================================================================================");
                manage.getMatchesWonByTeam();
                System.out.println("===========================================================================================");
                break;
            case "3":System.out.println("===========================================================================================");
                System.out.print("Enter the year : ");
                manage.getExtraRunsConcededByTeam(sc.nextInt());
                System.out.println("===========================================================================================");
                break;
            case "4":System.out.println("===========================================================================================");
                System.out.print("Enter the year : ");
                manage.getTopEconomicalBowlers(sc.nextInt());
                System.out.println("===========================================================================================");
                break;
            case "All":System.out.println("===========================================================================================");
                System.out.print("Enter the year to get extra runs conceded by each team : ");
                int teamYear=sc.nextInt();
                System.out.println("Enter the year to get top economical bowlers : ");
                int economicYear=sc.nextInt();
                System.out.println("===========================================================================================");
                manage.getMatchesPlayedPerYear();
                System.out.println("===========================================================================================");
                manage.getMatchesWonByTeam();
                System.out.println("===========================================================================================");
                manage.getExtraRunsConcededByTeam(teamYear);
                System.out.println("===========================================================================================");
                manage.getTopEconomicalBowlers(economicYear);
                System.out.println("===========================================================================================");
                break;
            case "0":System.exit(0);
                break;
            default: System.out.println("enter an valid choice");
                break;
        }
        sc.close();
        System.out.println("----------------------------------THANK YOU--------------------------------------------------");
    }
}
