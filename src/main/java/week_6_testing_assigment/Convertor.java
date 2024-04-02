package week_6_testing_assigment;

//This is the convertor class, it is responsible for the conversion of the values from km to m to dm to cm to mm
//It converts only from large to small, because the task said that the output should be
//in the smallest unit measurement.
public class Convertor {

    protected int convertToMeters(String metricValue, int number) {
        if (!metricValue.equals("km") && !metricValue.equals("m")) {
            throw new IllegalArgumentException("Invalid format!");
        }
        if (metricValue.equals("m")) {
            return number;
        }
        return number * 1000;
    }

    protected int convertToDecimeters(String metricValue, int number) {
        int result = 0;
        if (!metricValue.equals("dm") && !metricValue.equals("m") && !metricValue.equals("km")) {
            throw new IllegalArgumentException("Invalid format!");
        }
        if (metricValue.equals("dm")) {
            return number;
        }
        if (metricValue.equals("m")) {
            result = number * 10;
        }
        if (metricValue.equals("km")) {
            result = number * 10000;
        }
        return result;
    }

    protected int convertToCentimeters(String metricValue, int number) {
        int result = 0;
        if (!metricValue.equals("cm") && !metricValue.equals("dm") && !metricValue.equals("m") && !metricValue.equals("km")) {
            throw new IllegalArgumentException("Invalid format!");
        }
        if (metricValue.equals("cm")) {
            return number;
        }
        if (metricValue.equals("dm")) {
            result = number * 10;
        }
        if (metricValue.equals("m")) {
            result = number * 100;
        }
        if (metricValue.equals("km")) {
            result = number * 100000;
        }
        return result;
    }

    protected int convertToMilimeters(String metricValue, int number) {
        int result = 0;
        if (!metricValue.equals("mm") && !metricValue.equals("cm") && !metricValue.equals("dm") && !metricValue.equals("m") && !metricValue.equals("km")) {
            throw new IllegalArgumentException("Invalid format!");
        }
        if (metricValue.equals("mm")) {
            return number;
        }
        if (metricValue.equals("cm")) {
            result = number * 10;
        }
        if (metricValue.equals("dm")) {
            result = number * 100;
        }
        if (metricValue.equals("m")) {
            result = number * 1000;
        }
        if (metricValue.equals("km")) {
            result = number * 1000000;
        }
        return result;
    }

}
