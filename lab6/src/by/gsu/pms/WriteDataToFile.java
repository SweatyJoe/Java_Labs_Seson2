package by.gsu.pms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteDataToFile {
    public static void writeDataToFile(List<Schedule> schedules) {
        File file = new File("src/out.txt");
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        for (var a : schedules) {
            try (FileWriter writer = new FileWriter("src/out.txt", true)) {
                String mas = a.toString().replaceAll("[\\'|\\{|\\}|\\,]", "");
                String[] splitedMas = mas.split(" ");
                mas = "";
                for (int i = 0; i < splitedMas.length; i++) {
                    mas += splitedMas[i].replaceAll("^\\w*=", "") + " ";
                }
                //System.out.println(mas);
                writer.write(mas);
                writer.append("\n");
                writer.flush();
            } catch (IOException e) {
                System.out.println("error while writing to file");
            }
        }
    }
}
