import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("        STUDENT GRADE TRACKER");
        System.out.println("========================================");

        // Student Name
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        // Number of Subjects
        System.out.print("Enter Number of Subjects: ");
        int subjects = sc.nextInt();

        int[] marks = new int[subjects];

        int total = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        System.out.println("\nEnter Marks:");

        // Input Marks
        for (int i = 0; i < subjects; i++) {

            while (true) {

                System.out.print("Subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();

                if (marks[i] >= 0 && marks[i] <= 100) {
                    break;
                } else {
                    System.out.println("Invalid Marks! Please enter marks between 0 and 100.");
                }
            }

            total += marks[i];

            if (marks[i] > highest) {
                highest = marks[i];
            }

            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }

        // Average and Percentage
        double average = (double) total / subjects;
        double percentage = average;

        // Overall Grade
        String grade;

        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "Fail";
        }

        // Pass / Fail
        String status;

        if (average >= 33) {
            status = "PASS";
        } else {
            status = "FAIL";
        }

        // Subject Wise Report
        System.out.println("\n========================================");
        System.out.println("          SUBJECT REPORT");
        System.out.println("========================================");

        for (int i = 0; i < subjects; i++) {

            String subjectGrade;

            if (marks[i] >= 90) {
                subjectGrade = "A+";
            } else if (marks[i] >= 80) {
                subjectGrade = "A";
            } else if (marks[i] >= 70) {
                subjectGrade = "B";
            } else if (marks[i] >= 60) {
                subjectGrade = "C";
            } else if (marks[i] >= 50) {
                subjectGrade = "D";
            } else {
                subjectGrade = "Fail";
            }

            System.out.println("Subject " + (i + 1) + " : " + marks[i] + " Marks    Grade : " + subjectGrade);
        }

        // Final Report
        System.out.println("\n========================================");
        System.out.println("             FINAL REPORT");
        System.out.println("========================================");

        System.out.printf("%-20s : %s%n", "Student Name", name);
        System.out.printf("%-20s : %d%n", "Subjects", subjects);
        System.out.printf("%-20s : %d%n", "Total Marks", total);
        System.out.printf("%-20s : %.2f%n", "Average", average);
        System.out.printf("%-20s : %.2f%%%n", "Percentage", percentage);
        System.out.printf("%-20s : %d%n", "Highest Marks", highest);
        System.out.printf("%-20s : %d%n", "Lowest Marks", lowest);
        System.out.printf("%-20s : %s%n", "Grade", grade);
        System.out.printf("%-20s : %s%n", "Status", status);
        System.out.printf("%-20s : %s%n", "Result Date", "10/07/2026");

        System.out.println("========================================");
        System.out.println("   THANK YOU FOR USING OUR SYSTEM");
        System.out.println("========================================");

        sc.close();
    }
}