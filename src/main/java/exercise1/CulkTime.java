package exercise1;

public class CulkTime {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread everySecond = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println((System.currentTimeMillis()-startTime)/1000);
            }
        });
        
        Thread everyFiveSecond = new Thread(()->{
            while (true){
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }

                System.out.print("Минуло 5 секунд : ");
            }
        });

        everyFiveSecond.start();
        everySecond.start();
    }
}
