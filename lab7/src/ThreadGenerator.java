import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadGenerator {
    private static int a;
    private static int thrNum;
    static List<Double> sums = new ArrayList<>();
    static String value;

    public static void main(String[] args) throws Exception {
        System.out.println("Enter number of threads");
        try (Scanner sc = new Scanner(System.in)) {
            thrNum = Integer.parseInt(sc.nextLine());
            System.out.println("Enter number");
            a = Integer.parseInt(sc.nextLine());
            System.out.println("Enter what to do with result");
            value = sc.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("input number has wrong format.");
        }
        execute();
        getResult();
    }

    public static void execute() {
        List<CalculatorThread> calculatorThreads = new ArrayList<>();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 500, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(8), threadFactory);
        for (int i = 0; i < thrNum; i++) {
            CalculatorThread cT = new CalculatorThread(a);
            calculatorThreads.add(cT);
            poolExecutor.execute(cT);
        }
        poolExecutor.shutdown();  //без этого программа не завершится самостоятельно
        for (var s : calculatorThreads) {
            try{
                while(poolExecutor.getActiveCount() != 0){
                    Thread.sleep(400);
                }
            }
            catch (InterruptedException e){
                System.out.println("Interrupted exception.");
                Thread.currentThread().interrupt();
            }
            sums.add(s.getSum());
        }
    }

    public static void getResult() throws Exception{
        String s = value;
        try(Scanner sc = new Scanner(System.in)){
            s = sc.nextLine();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        double tmp = 0;
        switch (s) {
            case "+": {
                tmp = 0;
                for (double d : sums) {
                    tmp += d;
                }
                break;
            }
            case "-": {
                tmp = 0;
                for (double d : sums) {
                    tmp -= d;
                }
                break;
            }
            case "*": {
                tmp = 1;
                for (double d : sums) {
                    tmp *= d;
                }
                break;
            }
            default:
                System.out.println("Def");
        }
        System.out.println("Result = " + tmp);
    }
}
