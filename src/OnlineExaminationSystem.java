
import java.util.Scanner;

// Parent Class
abstract class Question {

    String question;
    int marks;

    Question(String question, int marks) {
        this.question = question;
        this.marks = marks;
    }

    abstract boolean checkAnswer(String answer);

    void displayQuestion() {
        System.out.println(question);
    }
}

// MCQ Child Class
class MCQ extends Question {

    String[] options;
    String correctAnswer;

    MCQ(String question, String[] options, String correctAnswer) {

        super(question, 1);
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    @Override
    void displayQuestion() {

        super.displayQuestion();

        for (String option : options) {
            System.out.println(option);
        }
    }

    @Override
    boolean checkAnswer(String answer) {

        return answer.equalsIgnoreCase(correctAnswer);
    }
}

// True/False Child Class
class TrueFalse extends Question {

    String correctAnswer;

    TrueFalse(String question, String correctAnswer) {

        super(question, 1);
        this.correctAnswer = correctAnswer;
    }

    @Override
    boolean checkAnswer(String answer) {

        return answer.equalsIgnoreCase(correctAnswer);
    }
}

// Main Class
public class OnlineExaminationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Question[] questions = {

                new MCQ(
                        "1. Which language is used for Android development?",
                        new String[]{
                                "A. HTML",
                                "B. Java",
                                "C. CSS",
                                "D. SQL"
                        },
                        "B"
                ),

                new TrueFalse(
                        "2. Java Supports OOP? (True/False)",
                        "True"
                ),

                new MCQ(
                        "3. Which keyword is used for inheritance in Java?",
                        new String[]{
                                "A. static",
                                "B. final",
                                "C. extends",
                                "D. import"
                        },
                        "C"
                )
        };

        int score = 0;

        System.out.println("===== Online Examination System =====");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("\nWelcome " + name);
        System.out.println("Total Questions: " + questions.length);
        System.out.println("Each Question carries 1 Mark.");

        // Display and evaluate questions
        for (Question q : questions) {

            q.displayQuestion();

            System.out.print("Enter your answer: ");
            String answer = sc.nextLine().trim();

            try {

                // Validate MCQ answer
                if (q instanceof MCQ) {

                    if (!answer.matches("[A-Da-d]")) {

                        throw new IllegalArgumentException(
                                "Invalid input! Enter A, B, C or D."
                        );
                    }

                }

                // Validate True/False answer
                else {

                    if (!answer.equalsIgnoreCase("True")
                            && !answer.equalsIgnoreCase("False")) {

                        throw new IllegalArgumentException(
                                "Invalid input! Enter True or False."
                        );
                    }
                }

                // Check answer using polymorphism
                if (q.checkAnswer(answer)) {

                    System.out.println("Correct Answer!");
                    score += q.marks;

                } else {

                    System.out.println("Wrong Answer!");
                }

            } catch (IllegalArgumentException e) {

                System.out.println(e.getMessage());
                System.out.println("0 marks awarded.");
            }

            System.out.println();
        }

        // Display Final Result
        double percentage =
                (score * 100.0) / questions.length;

        System.out.println("===== EXAM RESULT =====");

        System.out.println("Student Name: " + name);
        System.out.println("Total Marks: " + score
                + "/" + questions.length);

        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 40) {

            System.out.println("Result: PASS");

        } else {

            System.out.println("Result: FAIL");
        }

        System.out.println("Thank you for attending the exam!");

        sc.close();
    }
}
