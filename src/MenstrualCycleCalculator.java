import java.time.LocalDate;
import java.util.Scanner;

public class MenstrualCycleCalculator {
    private int averagePeriodCycle;
    private  int lastPeriodDate;
    private LocalDate nextPeriodDate;
    private int month;
    private int year;


    public int getMonth() {

        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12){
            throw new IllegalArgumentException();
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 0){
            throw new IllegalArgumentException("Must be in the 20th Century");
        }
        this.year = year;
    }

    public LocalDate setDate(){

        return LocalDate.of(getYear(),getMonth(),getLastPeriodDate());
    }

    public void setAveragePeriodCycle(int averagePeriodCycle){
        if (averagePeriodCycle < 21 || averagePeriodCycle > 41){
            throw new IllegalArgumentException("This user has issues");
        }
        this.averagePeriodCycle = averagePeriodCycle;
    }

    public int getAveragePeriodCycle(){
        return averagePeriodCycle;
    }



    public int getOvulationDay(){
        int ovulationDay = averagePeriodCycle - 14;
        return ovulationDay;
    }

    public void setLastPeriodDate(int lastPeriodDate) {
        if (lastPeriodDate < 1 || lastPeriodDate > 31){
            throw  new IllegalArgumentException("Date has exceded limit");
        }
        this.lastPeriodDate = lastPeriodDate;
    }

    public  int getLastPeriodDate(){
        return lastPeriodDate;
    }
    public  LocalDate getNextPeriodDate(){
        nextPeriodDate = setDate().plusDays(getAveragePeriodCycle());
        return nextPeriodDate;
    }

    public LocalDate getOvulationStart(){
        LocalDate ovulationStart = setDate().plusDays(getOvulationDay()-2);
        return  ovulationStart;
    }

    public LocalDate getOvulationEnd(){
        LocalDate ovulationEnd = setDate().plusDays(getOvulationDay()+2);
        return  ovulationEnd;
    }

    public LocalDate getSafePeriodStart(){
        LocalDate safePeriodStart = getOvulationEnd().plusDays(1);
        return safePeriodStart;
    }

    public LocalDate getSafePeriodEnd(){
        LocalDate safePeriodEnd = getOvulationEnd().plusDays(11);
        return safePeriodEnd;
    }


}