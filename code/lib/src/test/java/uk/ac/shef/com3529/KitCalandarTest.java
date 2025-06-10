package uk.ac.shef.com3529;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KitCalandarTest{

    @Test
    public void shouldSwapDates() {
        int result = Calendar.daysBetweenTwoDates(2002, 1, 1, 2001, 1, 1);
        assertEquals(365, result);
    }

    @Test
    public void shouldClaculateBetweenDays() {
        int result = Calendar.daysBetweenTwoDates(2002, 1, 10, 2002, 1, 15);
        assertEquals(5, result);
    }

    @Test
    public void shouldAccountForLeapYear() {
        int result = Calendar.daysBetweenTwoDates(2004, 1, 1, 2005, 1, 1);
        assertEquals(366, result);
    }

    @Test
    public void februaryShouldBeLongerOnLeapYear() {
        int result = Calendar.daysBetweenTwoDates(2004, 2, 1, 2004, 3, 1);
        assertEquals(29, result);
    }

    @Test
    public void shouldDealWithNegativeDates() {
        int result = Calendar.daysBetweenTwoDates(1, -1, -1, 1, 1, 2);
        assertEquals(1, result);
    }
}



