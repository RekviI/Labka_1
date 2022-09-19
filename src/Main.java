import java.util.*;

public class Main
    {
        public static void main(String[] args)
        {
            Scanner input = new Scanner(System.in);
            StringCalculator calculator = new StringCalculator();

            System.out.println("Рядок: ");
            String userInput = input.nextLine();
            try
            {
                int num = calculator.add(userInput);
                System.out.println("Сума: " + num);
            }
            catch(Exception e)
            {
                System.out.println("Некоректні дані");
                System.out.println(e.getLocalizedMessage());
            }
        }
    }