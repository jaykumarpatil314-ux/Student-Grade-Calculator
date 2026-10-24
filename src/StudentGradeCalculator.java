import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Task 2: Student Grade Calculator
 * CodSoft Java Development Internship
 * 
 * Features:
 * - Accepts marks obtained (out of 100) in each subject.
 * - Robust input validation (ensures valid numeric input between 0 and 100).
 * - Computes Total Marks and Average Percentage.
 * - Computes Letter Grade and Performance Remarks.
 * - Displays a comprehensive, formatted Student Grade Report Card.
 * - Supports calculating grades for multiple students in a session.
 */
public class StudentGradeCalculator {

    static class SubjectRecord {
        String name;
        double marks;

        SubjectRecord(String name, double marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printHeader();

        boolean continueRunning = true;

        while (continueRunning) {
            processStudentGrades(scanner);
            continueRunning = askToContinue(scanner);
        }

        System.out.println("\nThank you for using the Student Grade Calculator!");
        scanner.close();
    }

    private static void processStudentGrades(Scanner scanner) {
        System.out.println("\n--------------------------------------------------");
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine().trim();
        if (studentName.isEmpty()) {
            studentName = "Student";
        }

        int numSubjects = getPositiveInt(scanner, "Enter total number of subjects: ", 1, 20);

        List<SubjectRecord> subjects = new ArrayList<>();
        double totalMarks = 0.0;

        System.out.println("\nPlease enter marks obtained out of 100 for each subject:");
        for (int i = 1; i <= numSubjects; i++) {
            System.out.printf("  Subject %d Name [Press Enter for 'Subject %d']: ", i, i);
            String subjectName = scanner.nextLine().trim();
            if (subjectName.isEmpty()) {
                subjectName = "Subject " + i;
            }

            double marks = getValidMarks(scanner, "  Enter marks for " + subjectName + " (0 - 100): ");
            subjects.add(new SubjectRecord(subjectName, marks));
            totalMarks += marks;
        }

        double maxTotalPossible = numSubjects * 100.0;
        double averagePercentage = (totalMarks / maxTotalPossible) * 100.0;
        String grade = determineGrade(averagePercentage);
        String remark = getRemark(grade);

        displayReportCard(studentName, subjects, totalMarks, maxTotalPossible, averagePercentage, grade, remark);
    }

    private static int getPositiveInt(Scanner scanner, String prompt, int min, int max) {
        int val;
        while (true) {
            System.out.print(prompt);
            try {
                val = scanner.nextInt();
                scanner.nextLine(); // clear newline
                if (val >= min && val <= max) {
                    return val;
                } else {
                    System.out.printf(">> Please enter a number between %d and %d.%n", min, max);
                }
            } catch (InputMismatchException e) {
                System.out.println(">> Invalid input! Please enter an integer.");
                scanner.nextLine(); // clear buffer
            }
        }
    }

    private static double getValidMarks(Scanner scanner, String prompt) {
        double val;
        while (true) {
            System.out.print(prompt);
            try {
                val = scanner.nextDouble();
                scanner.nextLine(); // clear newline
                if (val >= 0.0 && val <= 100.0) {
                    return val;
                } else {
                    System.out.println(">> Invalid marks! Marks must be between 0.0 and 100.0.");
                }
            } catch (InputMismatchException e) {
                System.out.println(">> Invalid input! Please enter a numeric score.");
                scanner.nextLine(); // clear buffer
            }
        }
    }

    private static String determineGrade(double percentage) {
        if (percentage >= 90.0) return "A+";
        if (percentage >= 80.0) return "A";
        if (percentage >= 70.0) return "B";
        if (percentage >= 60.0) return "C";
        if (percentage >= 50.0) return "D";
        if (percentage >= 40.0) return "E";
        return "F";
    }

    private static String getRemark(String grade) {
        switch (grade) {
            case "A+": return "Outstanding Performance!";
            case "A":  return "Excellent Work!";
            case "B":  return "Very Good, Keep it up!";
            case "C":  return "Good Effort, Scope for Improvement.";
            case "D":  return "Satisfactory, Needs Hard Work.";
            case "E":  return "Pass, Urgent Improvement Needed.";
            default:   return "Failed, Needs Substantial Attention.";
        }
    }

    private static void displayReportCard(String studentName, List<SubjectRecord> subjects,
                                          double totalMarks, double maxTotal,
                                          double percentage, String grade, String remark) {
        System.out.println("\n========================================================");
        System.out.println("                 OFFICIAL REPORT CARD                   ");
        System.out.println("========================================================");
        System.out.printf(" Student Name : %s%n", studentName);
        System.out.println("--------------------------------------------------------");
        System.out.printf(" %-4s | %-25s | %-15s%n", "#", "Subject", "Marks Obtained");
        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < subjects.size(); i++) {
            SubjectRecord s = subjects.get(i);
            System.out.printf(" %-4d | %-25s | %6.2f / 100.0%n", (i + 1), s.name, s.marks);
        }

        System.out.println("========================================================");
        System.out.printf(" Total Marks Obtained   : %6.2f / %.0f%n", totalMarks, maxTotal);
        System.out.printf(" Average Percentage     : %6.2f%%%n", percentage);
        System.out.printf(" Final Grade Assigned   : %s%n", grade);
        System.out.printf(" Evaluation Remarks     : %s%n", remark);
        System.out.println("========================================================");
    }

    private static boolean askToContinue(Scanner scanner) {
        while (true) {
            System.out.print("\nDo you want to calculate grades for another student? (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            } else {
                System.out.println(">> Please enter 'y' for yes or 'n' for no.");
            }
        }
    }

    private static void printHeader() {
        System.out.println("********************************************************");
        System.out.println("*            STUDENT GRADE CALCULATOR                  *");
        System.out.println("*            CodSoft Java Development                  *");
        System.out.println("********************************************************");
    }
}
