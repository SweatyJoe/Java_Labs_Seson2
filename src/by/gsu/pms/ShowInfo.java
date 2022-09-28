package by.gsu.pms;

import java.util.List;

public class ShowInfo {
    public static void showInfo(List<Schedule> list) {
        for (var s : list) {
            System.out.println(s.toString());
        }
        System.out.println("\n");
    }
}
