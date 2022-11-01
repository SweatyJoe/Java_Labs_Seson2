import by.gsu.pms.ReadDataFromFile;
import by.gsu.pms.Schedule;
import by.gsu.pms.ShowInfo;
import by.gsu.pms.WriteDataToFile;
import by.gsu.pms.comparator.ComparatorByName;

import java.util.Collections;

public class Runner {
    public static void main(String[] args) {
        var schedules = ReadDataFromFile.readData();
        ShowInfo.showInfo(schedules);

        Collections.sort(schedules, new ComparatorByName());

        ShowInfo.showInfo(schedules);
        WriteDataToFile.writeDataToFile(schedules);
    }
}
