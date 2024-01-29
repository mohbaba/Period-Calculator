import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class DriverCLass{
    public static void displayMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Calculate your next period date and other related info");
        //System.out.println("2. Calculate your menstrual cycle");

        int response = scanner.nextInt();
        while(response > 2 || response < 1){
            System.out.println("Select an option between 1 and 2");
            response = scanner.nextInt();
        }

        switch (response){
            case 1:
                displayOption1();
                break;
            default:
                System.out.println("Thank you");
        }
    }

    public static void displayOption1(){
        Scanner scanner = new Scanner(System.in);
        MenstrualCycleCalculator menstrualCycleCalculator = new MenstrualCycleCalculator();


        System.out.println("Please enter your name: ");
        String name = scanner.next();

        System.out.println("Hello "+name+" When was the first day of your last period");
        int lastPeriod = scanner.nextInt();
        while (lastPeriod < 1 || lastPeriod > 31){
            System.out.println("Invalid input! enter correct date");
            lastPeriod = scanner.nextInt();
        }

        menstrualCycleCalculator.setLastPeriodDate(lastPeriod);

        System.out.println("Which month? (1 - 12)");
        int month = scanner.nextInt();


        while (month < 1 || month > 12){
            System.out.println("Which month? (1 - 12)");
            month = scanner.nextInt();
        }
        menstrualCycleCalculator.setMonth(month);


        System.out.println("Which year? ");
        int year = scanner.nextInt();

        menstrualCycleCalculator.setYear(year);

        System.out.println("What is your average cycle? ");
        int averageCycle = scanner.nextInt();
        if (averageCycle < 21 || averageCycle > 41){
            System.out.println("You're advised to visit doctor ");
            System.exit(0);
        }
        menstrualCycleCalculator.setAveragePeriodCycle(averageCycle);

        System.out.println(menstrualCycleCalculator.getNextPeriodDate());
for (int counter = 0 ; counter < 3; counter++) {
    LocalDate ovulationStart = menstrualCycleCalculator.getOvulationStart();
    LocalDate ovulationEnd = menstrualCycleCalculator.getOvulationEnd();
    DayOfWeek ovulationDayOfWeek = ovulationEnd.getDayOfWeek();
    int ovulationDayOfMonth = ovulationStart.getDayOfMonth();

    System.out.println();
    System.out.println();

    System.out.println("-----------------------------------------------------------------------");
    System.out.println("-----------------------------------------------------------------------");
    System.out.printf("Most probable ovulation period starts on %s %sth till %s %sth of %s %n", ovulationStart.getDayOfWeek().toString(), ovulationDayOfMonth, ovulationDayOfWeek.toString(), ovulationEnd.getDayOfMonth(), ovulationStart.getMonth().toString());

    LocalDate safePeriodStart = menstrualCycleCalculator.getSafePeriodStart();
    LocalDate safePeriodEnd = menstrualCycleCalculator.getSafePeriodEnd();
    int safeDayOfMonth = safePeriodEnd.getDayOfMonth();
    DayOfWeek safeDayOfWeek = safePeriodEnd.getDayOfWeek();

    System.out.printf("Safe period starts on %s %sth till %s %sth of %s%n", safePeriodStart.getDayOfWeek().toString(), safePeriodStart.getDayOfMonth(), safeDayOfWeek.toString(), safeDayOfMonth, safePeriodEnd.getMonth().toString());

    LocalDate nextPeriod = menstrualCycleCalculator.getNextPeriodDate();
    Month periodMonth = nextPeriod.getMonth();
    int periodDay = nextPeriod.getDayOfMonth();
    DayOfWeek periodDayOfWeek = nextPeriod.getDayOfWeek();

    System.out.println("Expect your next period on " + periodDayOfWeek + " " + periodDay + " " + periodMonth);
    System.out.println("-----------------------------------------------------------------------");
    System.out.println("-----------------------------------------------------------------------");

    menstrualCycleCalculator.setLastPeriodDate(periodDay);
    menstrualCycleCalculator.setMonth(nextPeriod.getMonthValue());
    menstrualCycleCalculator.setYear(nextPeriod.getYear());
    menstrualCycleCalculator.setDate();
}
    }

    public static void mainApp(){

        displayMenu();

    }

    public static void main(String[] args) {
        mainApp();
    }
}
