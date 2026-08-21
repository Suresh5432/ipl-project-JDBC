# IPL Data Analysis Using Java and JDBC

A console-based Java application that imports Indian Premier League (IPL) match and delivery data from CSV files into PostgreSQL and performs SQL-based cricket analysis.

## Features

- Import match data from `matches.csv`
- Import ball-by-ball data from `deliveries.csv`
- Store IPL data in PostgreSQL using JDBC
- Show matches played per season
- Show matches won by each team
- Calculate extra runs conceded by each team for a selected season
- Show the top 10 economical bowlers for a selected season
- Use prepared statements and batch insertion
- Prevent duplicate records during repeated imports

## Technology Stack

- Java 17 or later
- PostgreSQL
- JDBC
- Apache Commons CSV
- 
## Project Structure

```text
ipl-project-jdbc/
├── pom.xml
├── README.md
├── .gitignore
├── data/
│   ├── matches.csv
│   └── deliveries.csv
└── src/
    ├── main/java/com/mountblue/ipl/
    │   ├── Main.java
    │   ├── config/
    │   ├── console/
    │   ├── csv/
    │   ├── exception/
    │   ├── model/
    │   ├── repository/
    │   └── service/
    └── test/java/
```

## Database Setup

Create the PostgreSQL database:

```sql
CREATE DATABASE ipl_data_jdbc;
```

## CSV Data

```text
data/matches.csv
data/deliveries.csv
```

## Menu Options

```text
1. Number of matches played per year
2. Number of matches won by each team
3. Extra runs conceded by each team for a selected year
4. Top 10 economical bowlers for a selected year
All. Display all analyses
0. Exit
```
