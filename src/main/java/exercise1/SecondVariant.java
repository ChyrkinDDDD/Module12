package exercise1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SecondVariant {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(2);

        long timeStart = System.currentTimeMillis();
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println((System.currentTimeMillis()-timeStart)/1000);
        },1,1, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println("Минуло 5 секунд");
        },5,5, TimeUnit.SECONDS);
    }
}
