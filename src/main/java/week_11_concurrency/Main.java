package week_11_concurrency;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        FestivalGate gate = new FestivalGate();
        MyFestivalAttendeeStarter festivalAttendeeStarter = new MyFestivalAttendeeStarter(random, gate, random.nextLong(1000, 2001));
        festivalAttendeeStarter.start();


        FestivalStatisticsThread festivalStatisticsThread = new FestivalStatisticsThread(gate);
        festivalStatisticsThread.start();
    }

}
