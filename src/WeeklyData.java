/**
 * The WeeklyData class stores and analyzes a week’s worth of numeric data of user spending. It allows the user to set a spending goal and current balance, and provides methods to calculate total, average, minimum, and maximum spending, as well as other useful statistics.
 * @author Cathy Vo
 * @collaborators Mrs. Morris
 * @version 1/21/2026
 */
public class WeeklyData {

    // -------------------------------------------------------------
    // Instance Variables
    // -------------------------------------------------------------
    // TODO: Declare a private array to store the week’s data
    //       Choose an appropriate type (double[] or int[])
    //       Create other instance variables as necessary
    private double[] spendings;
    private double goal;
    private double balance;

//-------------------------------------------------------------
    // Getters and Setters
    // -------------------------------------------------------------
/**
 * Returns the spending goal set for the week.
 * @return the spending goal
 */
public double getGoal() {
        return goal;
}
/**
 * Sets the daily spending goal.
 * @param goal
 */
public void setGoal(double goal) {
    this.goal = goal;
}
/**
 * Returns the current balance available.
 * @return the current balance
 */
public double getBalance() {
        return balance;
}
/**
 * Sets the current balance available.
 * @param balance
 */
public void setBalance(double balance) {
    this.balance = balance;
}


    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------
    /**
     * Constructs a WeeklyData object by taking in an array of spending values
     * and making a deep copy (element-by-element) into the internal array.
     *
     * @param input an array representing 7 days of data
     * @param goal  the spending goal per day
     * @param balance the current balance available
     */
    public WeeklyData(double[] input, double goal, double balance) {
        // TODO: (Optional) Check if input is null and handle appropriately
        // TODO: Create a new array with the same length as input
        // TODO: Copy each value from input into the internal data array
        // NOTE: Do NOT do this.data = input; (that would create aliasing)
        this.spendings = new double[input.length];
       this.goal = goal;
       this.balance = balance;

        for (int i = 0; i < input.length; i++) {
            this.spendings[i] = input[i];
        }
    }


    // -------------------------------------------------------------
    // getTotal
    // -------------------------------------------------------------
    /**
     * Calculates and returns the total of all values in the week.
     *
     * @return the sum of all values in the data array
     */
    public double getTotal() {
        // TODO: Create a variable to store the running total
        // TODO: Use a loop to add each value in the array to the total
        // TODO: Return the total
        double sum = 0.0;
        for (double spent: spendings){
            sum += spent;
        }
        return sum; // replace with your calculated total
    }


    // -------------------------------------------------------------
    // getAverage
    // -------------------------------------------------------------
    /**
     * Calculates and returns the average value for the week.
     *
     * @return the average of the values in the array,
     *         or 0.0 if the array is empty 
     */
    public double getAverage() {
        // TODO: If the array length is 0, return 0.0
        // TODO: Otherwise, divide the total by the number of elements
        // Hint: You may call getTotal()
        if (spendings.length == 0) {
            return 0.0;
        }
        else{
            return getTotal() / spendings.length; // replace with your calculated average
        }
       
    }


    // -------------------------------------------------------------
    // getMax
    // -------------------------------------------------------------
    /**
     * Finds and returns the highest value in the data array.
     *
     * @return the maximum value
     */
    public double getMax() {
        // TODO: Assume the first value is the current maximum
        // TODO: Loop through the rest of the array and update max as needed
        // TODO: Return the maximum value found
        double max = spendings[0];
        for (double spent: spendings){
            if (spent > max){
                max = spent;
            }
        }
        return max; // replace with the maximum value
    }


    // -------------------------------------------------------------
    // getMin
    // -------------------------------------------------------------
    /**
     * Finds and returns the lowest value in the data array.
     *
     * @return the minimum value
     */
    public double getMin() {
        // TODO: Assume the first value is the current minimum
        // TODO: Loop through the rest of the array and update min as needed
        // TODO: Return the minimum value found
        double min = spendings[0];
        for (double spent: spendings){
            if (spent < min){
                min = spent;
            }
        }
        return min; // replace with the minimum value
    }
    
    public boolean isWithinBudget() {
        for (double spent : spendings) {
            if (spent > goal || spent > balance) {
                return false;
            }
        }
        return true;
    }



    // -------------------------------------------------------------
    // toString
    // -------------------------------------------------------------
    /**
     * Returns a formatted, multi-line String showing each day’s data.
     *
     * Example:
     * Day 1: 4500
     * Day 2: 6200
     * Day 3: 5100
     *
     * @return a formatted String representing the week’s data
     */
    @Override
    public String toString() {
        // TODO: Create a StringBuilder
        // TODO: Loop through the data array
        // TODO: Append each value with a day label (Day 1, Day 2, etc.)
        // TODO: Return the completed String
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spendings.length; i++) {
            sb.append("Day ").append(i + 1).append(": ").append("$").append(spendings[i]).append("\n");
        }
        return sb.toString(); // replace with your formatted output
    }

    /**
     * Calculates the final balance after spending for the week.
     * @return the final balance after spending
     */
    public double finalBalance() {
        double totalSpent = getTotal();
        balance -= totalSpent;
        return balance;
    }
    /**
     * Counts the number of days where spending exceeded the daily goal.
     * @return the number of days over the spending goal
     */
    public int daysOverGoal() {
        int count = 0;
        for (double spent : spendings) {
            if (spent > goal) {
                count++;
            }
        }
        return count;
    }
}
