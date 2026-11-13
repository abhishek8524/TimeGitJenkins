
package time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeTest {

    @Test
    void testGetTotalSecondsGood() {
        assertEquals(44045, Time.getTotalSeconds("12:14:05"));
    }

    @Test
    void testGetTotalSecondsBoundary() {
        assertEquals(1, Time.getTotalSeconds("00:00:01"));
        assertEquals(3600, Time.getTotalSeconds("01:00:00"));
    }

    @Test
    void testGetTotalSecondsBad() {
        assertThrows(StringIndexOutOfBoundsException.class,
                () -> Time.getTotalSeconds("12:14"));
    }

    @Test
    void testGetSecondsGood() {
        assertEquals(48, Time.getSeconds("19:03:48"));
    }

    @Test
    void testGetSecondsBoundary() {
        assertEquals(1, Time.getSeconds("00:00:01"));
        assertEquals(59, Time.getSeconds("06:11:59"));
    }

    @Test
    void testGetSecondsBad() {
        assertThrows(StringIndexOutOfBoundsException.class,
                () -> Time.getSeconds("19:03:4"));
    }

    @Test
    void testGetTotalMinutesGood() {
        assertEquals(52, Time.getTotalMinutes("11:52:09"));
    }

    @Test
    void testGetTotalMinutesBoundary() {
        assertEquals(0, Time.getTotalMinutes("07:00:00"));
        assertEquals(59, Time.getTotalMinutes("07:59:59"));
    }

    @Test
    void testGetTotalMinutesBad() {
        assertThrows(NumberFormatException.class,
                () -> Time.getTotalMinutes("11:52:09.30"));
    }

    @Test
    void testGetTotalHoursGood() {
        assertEquals(21, Time.getTotalHours("21:40:55"));
    }

    @Test
    void testGetTotalHoursBoundary() {
        assertEquals(0, Time.getTotalHours("00:15:30"));
        assertEquals(23, Time.getTotalHours("23:45:10"));
    }

    @Test
    void testGetTotalHoursBad() {
        assertThrows(NumberFormatException.class,
                () -> Time.getTotalHours("qr:40:55"));
    }

    @Test
    void testGetMillisecondsGood() {
        assertEquals(60, Time.getMilliseconds("17:05:22.60"));
    }

    @Test
    void testGetMillisecondsBoundary() {
        assertEquals(1, Time.getMilliseconds("00:00:00.01"));
        assertEquals(99, Time.getMilliseconds("23:59:59.99"));
    }

    @Test
    void testGetMillisecondsBad() {
        assertThrows(NumberFormatException.class,
                () -> Time.getMilliseconds("17:05:22.mn"));
    }

    @Test
    void testGetAllMilliseconds() {
        assertEquals(32718040, Time.getAllMilliseconds("09:05:18:40"));
    }
}
