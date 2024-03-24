package week_7_io_enums_assigment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AthleteTest {
    @Test
    void compareTwoAthletes_differentTimeInMinutes_resultSuccessfully() {
        Athlete athlete1 = new Athlete("Florin Prunea", "30:30", "(30:00+30)");
        Athlete athlete2 = new Athlete("Giga Hagi", "31:00", "(31:00+00)");
        int result = athlete1.compareTo(athlete2);
        assertEquals(-1, result);
    }

    @Test
    void compareTwoAthletes_SameMinuteTimeDifferentSecondTime_resultSuccessfully() {
        Athlete athlete1 = new Athlete("Florin Prunea", "31:30", "(30:00+30)");
        Athlete athlete2 = new Athlete("Giga Hagi", "31:20", "(31:00+20)");
        int result = athlete1.compareTo(athlete2);
        assertEquals(10, result);
    }


}