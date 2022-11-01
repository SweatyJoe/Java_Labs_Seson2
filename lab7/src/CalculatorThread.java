public class CalculatorThread implements Runnable{
    private int a;
    private double sum;
    private boolean isActive;

    void disable(){
        isActive = false;
    }
    public CalculatorThread(int a) {
        this.a = a;
        this.sum = 0;
        isActive = true;
    }

    public double getSum() {
        return this.sum;
    }

    @Override
    public void run() {
        System.out.println("Start thread: " + Thread.currentThread().getName());
        int i = 1;
        while(isActive){
            while(i<=a){
                try{
                    if((i%2)==1){
                        this.sum+=Math.pow(i,2);
                    }
                }
                catch (Exception e){
                    System.out.println("Thread interrupted.");
                }
                i++;
            }
            disable();
        }
        System.out.println("Thread finished: " + Thread.currentThread().getName());
    }
}
