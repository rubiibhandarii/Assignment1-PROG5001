import java.util.Scanner;
/**
 * This is a template to recieve students marks and assignment name 
 * and find out highest, lowest marks,mean and standard deviation
 * 
 * @author (Rubi Bhandari)
 * @version (version 1.0 08/09/2023)
 */
public class AssignmentStatistics {
    
    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Cannot calculate the square root of a negative number");
        }

        double guess = x;
        double epsilon = 1e-15; // A small value to control the precision of the calculation

        while (Math.abs(guess * guess - x) > epsilon * x) {
            guess = 0.5 * (guess + x / guess); // Newton-Raphson formula
        }

        return guess;
    }
    
    public static double pow(double base, double exponent) {
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
    
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //F1: Allows the user to input the assignment name
        System.out.print("Enter the assignment name: ");
        String assignmentName = scanner.nextLine(); //Assignment name / value will be saved in assignmentName
       
        // F2: Allows the user to input students' marks for assignment
        int[] marks = new int[30];
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
                    System.out.println("Invalid input! Please enter a mark between 0 and 30."); //Validation for marks
                }
            }
        }
          // F4: Print assignment name and students' marks after users have finished entering the marks
        System.out.println("Assignment Name: " + assignmentName);
        System.out.println("Students' Marks:");
        for (int i = 0; i < 30; i++) {
            System.out.println("Student " + (i + 1) + ": " + marks[i]);
        }
        
        //F5: Print the highest mark and the lowest mark on the screen
        int highestMark = marks[0];
        int lowestMark = marks[0];
        for (int mark : marks) {
            if (mark > highestMark) {
                highestMark = mark;
            }
            if (mark < lowestMark) {
                lowestMark = mark;
            }
        }
        System.out.println("Highest Mark: " + highestMark);
        System.out.println("Lowest Mark: " + lowestMark);

        //F6: Calculate and print the mean and standard deviation of the marks and 
        double sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        double mean = sum / 30; //Formula for mean
        double deviationSum = 0;
        for (int mark : marks) {
            deviationSum += pow(mark - mean, 2); //formula for standard deviation
        }
        double standardDeviation = sqrt(deviationSum / 30);

        System.out.println("Mean: " + mean);
        System.out.println("Standard Deviation: " + standardDeviation);

        scanner.close();
    }
}
