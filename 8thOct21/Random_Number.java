import java.util.Random;
import java.util.Scanner;

public class Random_Number {
    public static void main(String[] args){
        int max_value=50;
        Random random = new Random();
        int random_number = random.nextInt(max_value);
        System.out.println("the random number generated is "+random_number);
        Scanner scanner = new Scanner(System.in);

        boolean is_user_correct = false;
        while (is_user_correct == false){
            System.out.println("please guess the random number from 1 to 50");
            int guess_number = scanner.nextInt();
            if(guess_number < random_number){
                System.out.println("Too low, try again");

            }
            else if(guess_number > random_number){
                System.out.println("Too high, try again");

            }
            else {
                System.out.println("Yes, you guessed the number.");
                is_user_correct = true;
            }

        }
    }
}
