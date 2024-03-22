package week_7_io_enums_assigment;

import java.util.*;

public class MyCalculator {
    private List<String> dataFromMyReader;
    private Map<String, List<String>> athletesNameAndTime=new HashMap<>();

    private Set<Athlete> sortedAthletesByTime=new TreeSet<>();

    public void createAthletesAndAddThemToTheSet(){
        for(Map.Entry<String, List<String>>entry:athletesNameAndTime.entrySet()){
            String name= entry.getKey();
            String time=entry.getValue().get(0);
            String timeAndPenalty=entry.getValue().get(1);
            Athlete athlete=new Athlete(name,time,timeAndPenalty);
            sortedAthletesByTime.add(athlete);
        }
    }
    public void processTime(List<String>data){
        this.dataFromMyReader=data;
        for(int i=1;i<data.size();i++){
            String[] arrayOfData=dataFromMyReader.get(i).split(",");
            int penaltyForFirstShootingRange=calculatePenalty(arrayOfData[4]);
            int penaltyForSecondShootingRange=calculatePenalty(arrayOfData[5]);
            int penaltyForThirdShootingRange=calculatePenalty(arrayOfData[6]);
            int totalPenaltyTime=penaltyForFirstShootingRange+penaltyForSecondShootingRange+penaltyForThirdShootingRange;
            String timeWithPenalty=String.format("(%s+%s)",arrayOfData[3],totalPenaltyTime);
            String totalTime=calculateTotalTime(arrayOfData[3],totalPenaltyTime);
            List<String>times=new ArrayList<>();
            times.add(totalTime);
            times.add(timeWithPenalty);
            athletesNameAndTime.put(arrayOfData[1],times );

        }
    }

    private String calculateTotalTime(String time, int penaltyTime){
        String[] array=time.split(":");
        int skyTimeMinutes=Integer.parseInt(array[0]);
        int skyTimeSeconds=Integer.parseInt(array[1]);
        skyTimeMinutes+=penaltyTime/60;
        skyTimeSeconds+=penaltyTime%60;
        if(skyTimeSeconds>=60){
            skyTimeMinutes+=1;
            skyTimeSeconds-=60;
        }
        if(String.valueOf(skyTimeSeconds).length()==1){
            return new StringBuilder().append(skyTimeMinutes).append(":").append(skyTimeSeconds).append(0).toString();
        }
        return new StringBuilder().append(skyTimeMinutes).append(":").append(skyTimeSeconds).toString();

    }

    private int calculatePenalty(String string){
        int result=0;
        char[] array=string.toCharArray();
        for(char c:array){
            if(c=='o'){
                result+=10;
            }
        }
        return result;
    }

    public Map<String, List<String>> getAthletesNameAndTime() {
        return athletesNameAndTime;
    }

    public Set<Athlete> getSortedAthletesByTime() {
        return sortedAthletesByTime;
    }
}
