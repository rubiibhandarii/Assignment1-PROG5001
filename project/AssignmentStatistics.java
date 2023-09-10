import java.util.Scanner;
/**
 * This is a template to recieve students marks and assignment name 
 * and find out highest, lowest marks,mean and standard deviation
 * 
 * @author (Rubi Bhandari)
 * @version (version 1.0 08/09/2023)
 */
public class AssignmentStatistics 
{
    // instance variables- replace the example below with your own
    private String assignmentName; //Assignment name / value will be saved in 'assignmentName'
    private int[] marks; //Students' marks will be saved under 'marks'

    //F1: Allows the user to input the assignment name
    public AssignmentStatistics(String assignmentName) {
        this.assignmentName = assignmentName;
        this.marks = new int[30];
    }
    
    // F2: Allows the user to input students' marks for assignment
    public void inputStudentMarks() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 30; i++) { //Assuming there are 30 students in the unit
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter student " + (i + 1) + "'s mark (0-30): ");
                int mark = scanner.nextInt();
                if (mark >= 0 && mark <= 30) { //Only accepting valid mark inputs by user (0-30)
                    marks[i] = mark;
                    validInput = true;
                } 
                //F3: Validation for marks
                else {
                    System.out.println("Invalid input! Please enter a mark between 0 and 30.");
                }
            }
        }
        scanner.close();
    }

    // F4: Print assignment name and students' marks after users have finished entering the marks
    public void printAssignmentInfo() {
        System.out.println("Assignment Name: " + assignmentName);
        System.out.println("Students' Marks:");
        for (int i = 0; i < 30; i++) {
            System.out.println("Student " + (i + 1) + ": " + marks[i]);
        }
    }

    //F5: Print the highest mark on the screen
    public int getHighestMark() {
        int highestMark = marks[0];
        for (int mark : marks) {
            if (mark > highestMark) {
                highestMark = mark;
            }
        }
        return highestMark;
    }
    
    //F5: Print the lowest mark on the screen
    public int getLowestMark() {
        int lowestMark = marks[0];
        for (int mark : marks) {
            if (mark < lowestMark) {
                lowestMark = mark;
            }
        }
        return lowestMark;
    }

    //F6: Calculate and print the mean of the marks
    public double calculateMean() {
        double sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum / 30;
    }
    
    //F6: Calculate and print the standard deviation of the marks
    public double calculateStandardDeviation() {
        double mean = calculateMean();
        double deviationSum = 0;
        for (int mark : marks) {
            deviationSum += pow(mark - mean, 2);
        }
        double epsilon = 1e-7; // Tolerance for the approximation
        return sqrt(deviationSum / 30, epsilon);
    }
    
    private static double sqrt(double x, double epsilon) {
        //Throws error incase of negative marks input by the user.
        if (x < 0) {
            throw new IllegalArgumentException("Marks cannot be negative.");
        }

        if (x == 0) {
            return 0;
        }

        double num = x / 2.0; // Initial variable
        double prevGuess;
        double prevSquared;
        
        do {
            prevGuess = num;
            prevSquared = prevGuess * prevGuess;
            num = 0.5 * (prevGuess + x / prevGuess); // Babylonian method to calculate square root for standard deviation
        } while (prevSquared - x >= epsilon * epsilon);

        return num;
    }
    
    private static double pow(double base, double exponent) { //Method to calculate power for standard deviation
     if (exponent == 0) {
            return 1.0;
        } else if (exponent < 0) {
            return 1.0 / powerPositive(base, -exponent);
        } else {
            return powerPositive(base, exponent);
        }
    }
    
    private static double powerPositive(double base, double exponent) {
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) { //Method to print assignment name, student marks, highest marks, lowest marks, mean and standard deviation
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the assignment name: ");
        String assignmentName = scanner.nextLine();

        AssignmentStatistics assignment = new AssignmentStatistics(assignmentName);

        assignment.inputStudentMarks();
        assignment.printAssignmentInfo();

        System.out.println("Highest Mark: " + assignment.getHighestMark());
        System.out.println("Lowest Mark: " + assignment.getLowestMark());
        System.out.println("Mean: " + assignment.calculateMean());
        System.out.println("Standard Deviation: " + assignment.calculateStandardDeviation());

        scanner.close();
    }
}