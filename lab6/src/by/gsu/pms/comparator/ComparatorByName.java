package by.gsu.pms.comparator;

import by.gsu.pms.Schedule;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Schedule> {
    @Override
    public int compare(Schedule o1, Schedule o2) {
        return o1.gettName().toUpperCase().compareTo(o2.gettName().toUpperCase());
    }
}
