import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenstrualCycleCalculatorTest {


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
        MenstrualCycleCalculator menstrualCycleCalculator = new MenstrualCycleCalculator();
        int ovulationDay = menstrualCycleCalculator.getOvulationDay();
        assertTrue(ovulationDay > 0);
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
        MenstrualCycleCalculator menstrualCycleCalculator = new MenstrualCycleCalculator();
        menstrualCycleCalculator.setYear(2023);
        menstrualCycleCalculator.setMonth(12);
        menstrualCycleCalculator.setLastPeriodDate(9);
        assertNotNull(menstrualCycleCalculator.getNextPeriodDate());
    }

    @Test
    void getOvulationStart() {
        MenstrualCycleCalculator menstrualCycleCalculator = new MenstrualCycleCalculator();
        menstrualCycleCalculator.setYear(2023);
        menstrualCycleCalculator.setMonth(12);
        menstrualCycleCalculator.setLastPeriodDate(9);
        assertNotNull(menstrualCycleCalculator.getOvulationStart());
    }

    @Test
    void getOvulationEnd() {
    }

    @Test
    void getSafePeriodStart() {
    }

    @Test
    void getSafePeriodEnd() {
    }

    @Test
    void displayMenu() {
    }

    @Test
    void displayOption1() {
    }

    @Test
    void mainApp() {
    }


}