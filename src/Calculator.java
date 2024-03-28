import java.util.Scanner;

public class Calculator
{

    public static void main(String[] argc)
    {
        Scanner scanner = new Scanner(System.in);

        while (true) {
        float firstNumber, secondNumber, result;
        char operator;

        System.out.print("Enter first digit:  ");
        firstNumber = scanner.nextFloat();
            if (firstNumber <= -9999 || firstNumber >= 9999)
            {
                System.out.println("Please enter shorten numbers");
            }

        System.out.print("Enter an operator:  ");
        operator= scanner.next().charAt(0);

        System.out.print("Enter second digit:  ");
        secondNumber = scanner.nextFloat();

            if (secondNumber <= -9999 || firstNumber >= 9999)
            {
                System.out.println("Please enter shorten numbers");
            }

        switch (operator)
        {
            case '+':
                    result = firstNumber + secondNumber;
                    System.out.println("res: " + result);
                    break;
            case '-':
                    result = firstNumber - secondNumber;
                    System.out.println("res: " + result);
                    break;
            case '*':
                    result = firstNumber * secondNumber;
                    System.out.println("res: " + result);
                    break;
            case '/':
                if(firstNumber != 0 && secondNumber != 0)
                {
                    result = firstNumber / secondNumber;
                    System.out.println("res: " + result);
                }
                else
                {
                    System.out.println("Digits can´t divide on 0");
                }
                break;
            default:
                System.out.println("Invalid operator");
        }
    }
    }
}
