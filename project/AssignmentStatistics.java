import java.util.Scanner;

public class AssignmentStatistics {
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
        
    }
}