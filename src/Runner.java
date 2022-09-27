import by.gsu.pms.ReadDataFromFile;
import by.gsu.pms.Schedule;
import by.gsu.pms.ShowInfo;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Schedule> schedules = new ArrayList<>();
        schedules =  ReadDataFromFile.readData();
        //sort
        ShowInfo.showInfo(schedules);
    }
}
