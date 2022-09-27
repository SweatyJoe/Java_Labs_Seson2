package by.gsu.pms;

public class Schedule{
    private String name;
    private String tName;
    private int curse;
    private int lecture;
    private int practice;
    private String dayOfW;
    private String classTime;

    public Schedule(String[] str) {
        this.name = str[0];
        this.tName = str[1];
        this.curse = Integer.parseInt(str[2]);
        this.lecture = Integer.parseInt(str[3]);
        this.practice = Integer.parseInt(str[4]);
        this.dayOfW = str[5];
        this.classTime = str[6];
    }

    public Schedule(String name, String tName, int curse, int lecture, int practice, String dayOfW, String classTime) {
        this.name = name;
        this.tName = tName;
        this.curse = curse;
        this.lecture = lecture;
        this.practice = practice;
        this.dayOfW = dayOfW;
        this.classTime = classTime;
    }


    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", tName='" + tName + '\'' +
                ", curse=" + curse +
                ", lecture=" + lecture +
                ", practice=" + practice +
                ", dayOfW='" + dayOfW + '\'' +
                ", classTime='" + classTime + '\'' +
                '}';
    }
}
