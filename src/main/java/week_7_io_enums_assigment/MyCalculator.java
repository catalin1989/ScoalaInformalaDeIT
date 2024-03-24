package week_7_io_enums_assigment;

import java.util.*;

//This class is responsible for the processing of the data that has been read
public class MyCalculator {
    private List<String> dataFromMyReader;
    private Map<String, List<String>> athletesNameAndTime = new HashMap<>();

    private Set<Athlete> sortedAthletesByTime = new TreeSet<>();

    public void createAthletesAndAddThemToTheSet() {

        for (Map.Entry<String, List<String>> entry : athletesNameAndTime.entrySet()) {
            String name = entry.getKey();
            String time = entry.getValue().get(0);
            String timeAndPenalty = entry.getValue().get(1);
            Athlete athlete = new Athlete(name, time, timeAndPenalty);
            sortedAthletesByTime.add(athlete);
        }

    }

    public void processTime(List<String> data) throws IllegalArgumentException {

        this.dataFromMyReader = data;
        if (dataFromMyReader.isEmpty()) {
            throw new IllegalArgumentException("There is no data to process. You have an error with your input.");
        }
        for (int i = 1; i < data.size(); i++) {
            String[] arrayOfData = dataFromMyReader.get(i).split(",");
            int penaltyForFirstShootingRange = calculatePenalty(arrayOfData[4]);
            int penaltyForSecondShootingRange = calculatePenalty(arrayOfData[5]);
            int penaltyForThirdShootingRange = calculatePenalty(arrayOfData[6]);
            int totalPenaltyTime = penaltyForFirstShootingRange + penaltyForSecondShootingRange + penaltyForThirdShootingRange;
            String timeWithPenalty = String.format("(%s+%s)", arrayOfData[3], totalPenaltyTime);
            String totalTime = calculateTotalTime(arrayOfData[3], totalPenaltyTime);
            List<String> times = new ArrayList<>();
            times.add(totalTime);
            times.add(timeWithPenalty);
            athletesNameAndTime.put(arrayOfData[1], times);

        }
    }


    private String calculateTotalTime(String time, int penaltyTime) {
        checkIfTheFileContainsAValidTime(time);
        String[] array = time.split(":");
        int skyTimeMinutes = Integer.parseInt(array[0]);
        int skyTimeSeconds = Integer.parseInt(array[1]);
        if (penaltyTime >= 60) {
            skyTimeMinutes += penaltyTime / 60;
            int remainderOfSeconds = penaltyTime - penaltyTime / 60 * 60;
            skyTimeSeconds += remainderOfSeconds;
        } else {
            skyTimeSeconds += penaltyTime;
        }
        if (skyTimeSeconds >= 60) {
            int minutesToAdd = skyTimeSeconds / 60;
            skyTimeMinutes += minutesToAdd;
            skyTimeSeconds = skyTimeSeconds - minutesToAdd * 60;
        }
        if (String.valueOf(skyTimeSeconds).length() == 1) {
            return new StringBuilder().append(skyTimeMinutes).append(":").append(0).append(skyTimeSeconds).toString();
        }
        return new StringBuilder().append(skyTimeMinutes).append(":").append(skyTimeSeconds).toString();

    }

    //This method calculates the penalty based on a string. It accept only strings formed from a combination on "x" and "o"
    //If there is a wrong input, the method will throw an exception
    private int calculatePenalty(String string) throws IllegalArgumentException {
        int result = 0;
        char[] array = string.toCharArray();
        for (char c : array) {
            if (c != 'x' && c != 'o') {
                throw new IllegalArgumentException("There is a problem with input from the shooting range. " +
                        "Please verify the mentioned field in your CSV file");
            }
        }
        for (char c : array) {
            if (c == 'o') {
                result += 10;
            }
        }
        return result;
    }

    //This method checks if there are errors in the time column. It checks for negative numbers, huge numbers, or a typo
    //There are cases when you accidentally type an extra letter(32w:20, instead of 32:30) or number(321:20, instead of 32:20)
    private void checkIfTheFileContainsAValidTime(String time) {
        String[] array = time.split(":");
        if (array.length != 2) {
            throw new IllegalArgumentException("There is a problem with the time input: " + time +
                    ". You forgot a delimitator. Please correct the error");
        }
        try {
            int skyTimeMinutes = Integer.parseInt(array[0]);
            int skyTimeSeconds = Integer.parseInt(array[1]);
            if (skyTimeMinutes < 0 || skyTimeSeconds < 0) {
                throw new IllegalArgumentException("There is a problem with the time input:+" + time +
                        ". You can't have negative time. Please correct the error");
            }
            if (skyTimeMinutes > 200 || skyTimeSeconds > 200) {
                throw new IllegalArgumentException("There is an abnormal high amount of time as an input: " + time +
                        ". Please correct.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("You have a typo: " + time + ". Please correct the error");
        }

    }

    public Map<String, List<String>> getAthletesNameAndTime() {
        return athletesNameAndTime;
    }

    public Set<Athlete> getSortedAthletesByTime() {
        return sortedAthletesByTime;
    }
}
