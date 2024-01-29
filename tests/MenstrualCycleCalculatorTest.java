import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenstrualCycleCalculatorTest {
    private MenstrualCycleCalculator menstrualCycleCalculator;
    @BeforeEach
    public void testAll(){
        menstrualCycleCalculator = new MenstrualCycleCalculator();
        menstrualCycleCalculator.setYear(2023);
        menstrualCycleCalculator.setMonth(12);
        menstrualCycleCalculator.setLastPeriodDate(1);
        menstrualCycleCalculator.setAveragePeriodCycle(28);
    }
    @Test
    void getMonth() {
        MenstrualCycleCalculator menstrualCycleCalculator = new MenstrualCycleCalculator();
        menstrualCycleCalculator.setMonth(12);
        assertEquals(12,menstrualCycleCalculator.getMonth());
    }

    @Test
    public void testSetMonth() {
        MenstrualCycleCalculator menstrualCycleCalculator = new MenstrualCycleCalculator();
        menstrualCycleCalculator.setMonth(12);
        assertEquals(12,menstrualCycleCalculator.getMonth());
        assertThrows(IllegalArgumentException.class,() ->menstrualCycleCalculator.setMonth(13));
        assertThrows(IllegalArgumentException.class,() ->menstrualCycleCalculator.setMonth(-1));

    }

    @Test
    public void getYear() {
        MenstrualCycleCalculator menstrualCycleCalculator = new MenstrualCycleCalculator();
        menstrualCycleCalculator.setYear(2000);
        assertEquals(2000,menstrualCycleCalculator.getYear());
    }

    @Test
    public void setYear() {
        MenstrualCycleCalculator menstrualCycleCalculator = new MenstrualCycleCalculator();
        menstrualCycleCalculator.setYear(2000);
        assertEquals(2000,menstrualCycleCalculator.getYear());
        assertThrows(IllegalArgumentException.class, () ->menstrualCycleCalculator.setYear(-2000));

    }

    @Test
    public void testsetDate() {
        MenstrualCycleCalculator menstrualCycleCalculator = new MenstrualCycleCalculator();
        menstrualCycleCalculator.setLastPeriodDate(2);
        menstrualCycleCalculator.setMonth(2);
        menstrualCycleCalculator.setYear(2019);
        assertNotNull(menstrualCycleCalculator.setDate());

    }

    @Test
    public void testSetAveragePeriodCycle() {
        MenstrualCycleCalculator menstrualCycleCalculator = new MenstrualCycleCalculator();
        menstrualCycleCalculator.setAveragePeriodCycle(25);
        assertEquals(25,menstrualCycleCalculator.getAveragePeriodCycle());
        assertThrows(IllegalArgumentException.class, ()-> menstrualCycleCalculator.setAveragePeriodCycle(3));
    }

    @Test
    void getAveragePeriodCycle() {

    }

    @Test
    void testGetOvulationDay() {
        int expected = 15;
        assertEquals(expected,menstrualCycleCalculator.getOvulationDay());
    }

    @Test
    void testSetLastPeriodDate() {
        MenstrualCycleCalculator menstrualCycleCalculator = new MenstrualCycleCalculator();
        assertThrows(IllegalArgumentException.class, ()-> menstrualCycleCalculator.setLastPeriodDate(36));
        assertThrows(IllegalArgumentException.class, ()-> menstrualCycleCalculator.setLastPeriodDate(0));

    }

    @Test
    void testGetLastPeriodDate() {
        MenstrualCycleCalculator menstrualCycleCalculator = new MenstrualCycleCalculator();
        menstrualCycleCalculator.setLastPeriodDate(2);
        assertEquals(2,menstrualCycleCalculator.getLastPeriodDate());
    }

    @Test
    void testGetNextPeriodDate() {
        assertEquals("2023-12-29",menstrualCycleCalculator.getNextPeriodDate().toString());
        assertNotNull(menstrualCycleCalculator.getNextPeriodDate());
    }

    @Test
    public void getOvulationStart() {
        assertNotNull(menstrualCycleCalculator.getOvulationStart());
        assertEquals("2023-12-13",menstrualCycleCalculator.getOvulationStart().toString());
    }

    @Test
    public void getOvulationEnd() {
        assertNotNull(menstrualCycleCalculator.getOvulationEnd());
        assertEquals("2023-12-17",menstrualCycleCalculator.getOvulationEnd().toString());
    }



    @Test
    void getSafePeriodStart() {
        assertNotNull(menstrualCycleCalculator.getSafePeriodStart());
        assertEquals("2023-12-18",menstrualCycleCalculator.getSafePeriodStart().toString());
    }

    @Test
    void getSafePeriodEnd() {
        assertNotNull(menstrualCycleCalculator.getOvulationEnd());
        assertEquals("2023-12-23",menstrualCycleCalculator.getOvulationEnd().toString());
    }



}