package week_7_io_enums_assigment;

public class Athlete implements Comparable<Athlete> {
    private String name;

    private String time;
    private String timeAndPenalty;

    public Athlete(String name, String time, String timeAndPenalty) {
        this.name = name;
        this.time = time;
        this.timeAndPenalty = timeAndPenalty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeAndPenalty() {
        return timeAndPenalty;
    }

    public void setTimeAndPenalty(String timeAndPenalty) {
        this.timeAndPenalty = timeAndPenalty;
    }


    @Override
    public int compareTo(Athlete o) {
        String[] firstAthleteTime = this.time.split(":");
        int firstAthleteMinutes = Integer.parseInt(firstAthleteTime[0]);
        int firstAthleteSeconds = Integer.parseInt(firstAthleteTime[1]);
        String[] secondAthleteTime = o.time.split(":");
        int secondAthleteMinutes = Integer.parseInt(secondAthleteTime[0]);
        int secondAthleteSeconds = Integer.parseInt(secondAthleteTime[1]);
        if (firstAthleteMinutes == secondAthleteMinutes) {
            return firstAthleteSeconds - secondAthleteSeconds;
        }
        return firstAthleteMinutes - secondAthleteMinutes;
    }

    @Override
    public String toString() {
        return "Athlet{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", timeAndPenalty='" + timeAndPenalty + '\'' +
                '}';
    }
}
