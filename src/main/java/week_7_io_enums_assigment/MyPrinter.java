package week_7_io_enums_assigment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyPrinter {

    public static void printTheTop3(Set<Athlete> sortedAthletesByTime) {
        try {
            if (sortedAthletesByTime.isEmpty()) {
                throw new IllegalArgumentException("There is nothing to print because you have a problem with the input");
            }
            List<Athlete> sortedAthletes = new ArrayList<>(sortedAthletesByTime);
            System.out.println(Places.Winner.getName() + "-" +
                    sortedAthletes.get(0).getName() + " " +
                    sortedAthletes.get(0).getTime() + " " +
                    sortedAthletes.get(0).getTimeAndPenalty());
            System.out.println(Places.Runner_up.getName() + "-" +
                    sortedAthletes.get(1).getName() + " " +
                    sortedAthletes.get(1).getTime() + " " +
                    sortedAthletes.get(1).getTimeAndPenalty());
            System.out.println(Places.Third_Place.getName() + "-" +
                    sortedAthletes.get(2).getName() + " " +
                    sortedAthletes.get(2).getTime() + " " +
                    sortedAthletes.get(2).getTimeAndPenalty());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public static void printAllTheResult(Set<Athlete> sortedAthletesByTime) {
        List<Athlete> sortedAthletes = new ArrayList<>(sortedAthletesByTime);
        for (int i = 0; i < sortedAthletesByTime.size(); i++) {
            System.out.println(i + 1 + " " + sortedAthletes.get(i));
        }
    }
}
