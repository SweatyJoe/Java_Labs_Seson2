package by.gsu.pms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadDataFromFile {
    public static List<Schedule> readData(){
        final String FILE_NAME = "src/File.txt";
        List<String> lines = new ArrayList<>();
        List<Schedule> schedules = new ArrayList<>();
        try (Scanner sc = new Scanner(new FileReader(FILE_NAME))){
            while (sc.hasNextLine()){
                lines.add(sc.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        for(String oneData : lines){
            String[] oneDataSplit = oneData.split(" ");
            if(oneDataSplit.length != 7){
                System.out.print("Find some errors. line skip");
                break;
            }
            Schedule schedule = new Schedule(oneDataSplit);
            schedules.add(schedule);
        }

        return schedules;
    }


}
