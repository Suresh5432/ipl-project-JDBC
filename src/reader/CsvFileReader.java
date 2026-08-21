package reader;

import model.Delivery;
import model.Match;
import utils.SplitLine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {
    public List<Match>  readMatchesData(){
        List<Match> matches=new ArrayList<>();
        String file="src/data/matches.csv";
        try(BufferedReader reader=new BufferedReader(new FileReader(file))){
            String line=reader.readLine();
            while((line=reader.readLine())!=null){
                String[] split= SplitLine.splitLine(line);
                Match match=new Match(
                        Integer.parseInt(split[0]),
                        Integer.parseInt(split[1]),
                        split[2],
                        split[3],
                        split[4],
                        split[5],
                        split[6],
                        split[7],
                        split[8],
                        Integer.parseInt(split[9]),
                        split[10],
                        Integer.parseInt(split[11]),
                        Integer.parseInt(split[12]),
                        split[13],
                        split[14],
                        split[15],
                        split[16],
                        split[17]);
                matches.add(match);
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return matches;
    }
    public List<Delivery> readDeliveriesData(){
        List<Delivery> data = new ArrayList<>();
        String file="src/data/deliveries.csv";
        try(BufferedReader reader=new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",", -1);
                Delivery delivery = new Delivery(
                        Integer.parseInt(split[0]),
                        Integer.parseInt(split[1]),
                        split[2],
                        split[3],
                        Integer.parseInt(split[4]),
                        Integer.parseInt(split[5]),
                        split[6],
                        split[7],
                        split[8],
                        Integer.parseInt(split[9]),
                        Integer.parseInt(split[10]),
                        Integer.parseInt(split[11]),
                        Integer.parseInt(split[12]),
                        Integer.parseInt(split[13]),
                        Integer.parseInt(split[14]),
                        Integer.parseInt(split[15]),
                        Integer.parseInt(split[16]),
                        Integer.parseInt(split[17]),
                        split[18],
                        split[19],
                        split[20]
                );
                data.add(delivery);
            }
        }
        catch(Exception e){
            System.out.println("Error reading deliveries.csv");
        }
        return data;
    }
}
