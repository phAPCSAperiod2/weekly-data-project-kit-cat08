import java.util.Scanner;

/**
 * Instructions:
 * - Complete the WeeklyData.java class first.
 * - Use this App class to collect user input and test your WeeklyData methods.
 * - Follow all TODOs carefully.
 * - Do NOT hard-code values — use loops and method calls.
 */
public class App {

    public static void main(String[] args) {

        // -------------------------------------------------------------
        // TODO 1: Create a Scanner for user input
        // -------------------------------------------------------------
        Scanner scan = new Scanner(System.in);

        // -------------------------------------------------------------
        // TODO 2: Give information about your program
        //         Ask the user about their goals (if applicable)
        // -------------------------------------------------------------
        System.out.println("Welcome to Budget Basics!");
        System.out.println("You will be prompted to enter your spending goal for each day of the week, balance, and daily spending.");
       
        double goal = setGoal(scan);
        double balance = setBalance(scan);
        
        
        // -------------------------------------------------------------
        // TODO 3: Create an array to hold 7 days of data
        //         Use an appropriate data type (int or double)
        //         Name the array weekData
        // -------------------------------------------------------------
        double[] weekData = new double[7];

        // -------------------------------------------------------------
        // TODO 4: Use a for loop to collect data for each day of the week
        //         Prompt example:
        //         "Enter <data type> for day X: "
        //
        //         Include input validation:
        //         - Use a while loop to prevent negative values
        //         - Re-prompt if the value is invalid
        // -------------------------------------------------------------
        for (int i = 0; i < weekData.length; i++) {
            System.out.println("Enter your spending for day " + (i + 1) + ": ");
            while (!scan.hasNextDouble()) {
                System.out.println("Invalid input. Please re-enter:");
                scan.next();
            }
            double input = scan.nextDouble();
            while (input < 0) {
                System.out.println("Spending cannot be negative. Please re-enter:");
                while (!scan.hasNextDouble()) {
                    System.out.println("Invalid input. Spending cannot be negative. Please re-enter:");
                    scan.next();
                }
                input = scan.nextDouble();
            }
            weekData[i] = input;
        }

        // -------------------------------------------------------------
        // TODO 5: Create a WeeklyData object
        //         Pass the weekData array into the constructor
        // -------------------------------------------------------------
        WeeklyData weeklyData = new WeeklyData(weekData, goal, balance);

        // -------------------------------------------------------------
        // TODO 6: Display the results of the analysis
        //         Call methods from WeeklyData to display:
        //         - Total
        //         - Average
        //         - Minimum
        //         - Maximum
        //
        //         Use clear labels and formatted output if needed
        // -------------------------------------------------------------
        displayResults(weeklyData);

        // -------------------------------------------------------------
        // TODO 7: Display the full week of data
        //         Use the toString() method from WeeklyData
        // -------------------------------------------------------------
        System.out.println("Here is your spending data for the week:");
        System.out.println(weeklyData.toString());

        // -------------------------------------------------------------
        // TODO 8: Give the user insights about their week
        //         --> "You need to drink more water next week!"
        //         --> "You were very hydrated this week!"
        //         --> etc.
        // -------------------------------------------------------------
        
        insights(weeklyData, balance, goal);
        
     // end of while loop with goal and balance check



}
    public static void insights(WeeklyData data, double balance, double goal) {
        double finalBalance = data.getBalance();
        if (finalBalance < 0) {
            System.out.println("You spent more than your balance! Consider cutting back on non-essential spending.");
        } 
        else if(finalBalance == balance-(goal*7)) {
            System.out.println("You were close to your budget this week. Try to cut out small expenses next week!");
        } 
        else if (finalBalance > balance-(goal*7)) {
            System.out.println("Great job! You stayed well within your budget this week!");
        } 
        else {
            System.out.println("You went over your budget. You need to monitor your spending more closely next week.");
        }
        
       
      
    }
    
    public static void displayResults(WeeklyData data) {
        System.out.println("Weekly Spending Analysis:");
        System.out.println("Total spending for the week: " + data.getTotal());
        System.out.println("Average daily spending: " + data.getAverage());
        System.out.println("Minimum daily spending: " +  data.getMin());
        System.out.println("Maximum daily spending: "+ data.getMax());
        System.out.println("Days exceeding spending goal: " + data.daysOverGoal());
        System.out.println("Current balance available: " + data.finalBalance());
    }
    public static double setGoal(Scanner scan){
        System.out.println("What is your daily spending goal? ");
        while (!scan.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a numeric value for your spending goal.");
            scan.next(); // consume the invalid input
        }
        double goal = scan.nextDouble();
        while (goal < 0) {
            System.out.println("Spending goal cannot be negative or zero. Please re-enter:");
            while (!scan.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric value for your spending goal.");
                scan.next(); // consume the invalid input
            }
            goal = scan.nextDouble();
        }
        return goal;
    }
    public static double setBalance(Scanner scan){
       System.out.println("What is your current balance available? ");
        while (!scan.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a numeric value for your balance.");
            scan.next(); // consume the invalid input
        }
        double balance = scan.nextDouble();
        while (balance <= 0) {
            System.out.println("Balance cannot be negative or zero. Please re-enter:");
            while (!scan.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric value for your balance.");
                scan.next(); // consume the invalid input
            }
            balance = scan.nextDouble();
        }
        return balance;
    }
}
