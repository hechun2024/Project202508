import java.util.Scanner;

public class MultiplicationTableExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // keep generating sets until the user scores 10/10
            int score = 0;

            // generate 10 random multiplication questions
            for (int i = 1; i <= 10; i++) {
                int a = (int)(Math.random() * 10) + 1; // random number 1-10[Math.random() return: 0-1]
                int b = (int)(Math.random() * 10) + 1;

                System.out.print("Question " + i + ": " + a + " x " + b + " = ");
                int answer = scanner.nextInt();

                if (answer == a * b) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong, the correct answer is " + (a * b));
                }
            }

            // check if the user mastered the table
            if (score == 10) {
                System.out.println("Congrats! You have mastered the multiplication table!");
                break; // end program
            } else {
                System.out.println("You scored " + score + "/10. Let's try another set!\n");
            }
        }

        scanner.close();
    }
}