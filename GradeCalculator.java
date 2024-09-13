import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();


        if (numSubjects <= 0) {
            System.out.println("Number of subjects must be greater than 0.");
            return;
        }


        int[] marks = new int[numSubjects];


        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            int mark = scanner.nextInt();


            if (mark < 0 || mark > 100) {
                System.out.println("Marks must be between 0 and 100. Please re-enter.");
                i--; // Decrement i to re-enter marks for the current subject
                continue;
            }

            marks[i] = mark;
        }


        int totalMarks = calculateTotalMarks(marks);


        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);


        char grade = determineGrade(averagePercentage);


        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    private static char determineGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
