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

    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Calculate your next period date and other related info");
        System.out.println("2. Calculate your menstrual cycle");

        int response = scanner.nextInt();
        while(response > 2 || response < 1){
            System.out.println("Select an option between 1 and 2");
            response = scanner.nextInt();
        }

        switch (response){
            case 1:
                displayOption1();
                break;

            case 2:

        }
    }

    public void displayOption1(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name: ");
        String name = scanner.next();

        System.out.println("Hello "+name+" When was the first day of your last period");
        int lastPeriod = scanner.nextInt();
        while (lastPeriod < 1 || lastPeriod > 31){
            System.out.println("Invalid input! enter correct date");
            lastPeriod = scanner.nextInt();
        }
        setLastPeriodDate(lastPeriod);

        System.out.println("Which month? (1 - 12)");

        int month = scanner.nextInt();


        while (month < 1 || month > 12){
            System.out.println("Which month? (1 - 12)");
            month = scanner.nextInt();
        }
        setMonth(month);


        System.out.println("Which year? ");
        int year = scanner.nextInt();
        setYear(year);

        System.out.println("What is your average cycle? ");
        int averageCycle = scanner.nextInt();
        if (averageCycle < 21 || averageCycle > 41){
            System.out.println("You're advised to visit doctor ");
            System.exit(0);
        }
        setAveragePeriodCycle(averageCycle);

        System.out.printf("Most probable ovulation period starts on %s %s till %s %s %s %n",getOvulationStart().getDayOfWeek().toString(),getOvulationStart().getDayOfMonth(),getOvulationEnd().getDayOfWeek().toString(),getOvulationEnd().getDayOfMonth(),getOvulationStart().getMonth().toString());
        System.out.printf("Safe period starts on %s %s till %s %s %s%n",getSafePeriodStart().getDayOfWeek().toString(),getSafePeriodStart().getDayOfMonth(),getSafePeriodEnd().getDayOfWeek().toString(),getSafePeriodEnd().getDayOfMonth(),getSafePeriodEnd().getMonth().toString());
        System.out.println("Expect your next period on "+getNextPeriodDate().getDayOfWeek()+" "+getNextPeriodDate().getDayOfMonth()+" "+getNextPeriodDate().getMonth());

    }

    public void mainApp(){

        displayMenu();



    }
    public static void main(String[] args) {
        MenstrualCycleCalculator mcc = new MenstrualCycleCalculator();
        mcc.mainApp();



    }
}