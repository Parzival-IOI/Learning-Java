import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        //each of this function represent one exercise
        //comment out if not needed
        //uncomment to RUN exercise
        ex1();
//        ex2();
//        ex3();
//        ex4();
    }
    public static void ex1 () {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter Number : ");
        double num = cin.nextDouble();
        System.out.print("1. Fahrenheit \n2. Celsius \nEnter Number to convert to : ");
        int option = cin.nextInt();
        double result = 0;
        String cvto = "";
        if(option == 1) {
            //(c* 9/ 5) + 32
            result = (num * 9 / 5 ) + 32;
            cvto = "Fahrenheit";
        }
        else if(option == 2) {
            // (f - 32) * 5/9
            result = (num - 32) * 5/9;
            cvto = "Celsius";
        }
        System.out.print("The temperature is : " + result + " " + cvto);
        cin.close();
    }
    public static void ex2 () {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter Score : ");
        double score = cin.nextDouble();
        char grade = '0';

        if(score < 50) {
            grade = 'F';
        }
        else if (score < 60) {
            grade = 'E';
        }
        else if (score < 70) {
            grade = 'D';
        }
        else if (score < 80) {
            grade = 'C';
        }
        else if (score < 90) {
            grade = 'B';
        }
        else if (score <= 100) {
            grade = 'A';
        }
        if(score < 0) {
            System.out.println("Your Score is too low");
        }
        else if (score > 100) {
            System.out.println("Your Score is too High");
        }
        else {
            System.out.println("Your Grade is : " + grade );
        }
        cin.close();
    }
    public static void ex3 () {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter Score : ");
        int number = cin.nextInt();

        if((number % 2) == 1 ) {
            System.out.println("Your Number " + number + " is ODD");
        }
        else if((number % 2) == 0) {
            System.out.println("Your Number " + number + " is EVEN");
        }
        cin.close();
    }
    public static void ex4 () {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter First Number : ");
        BigDecimal num1 = cin.nextBigDecimal();
        System.out.print("Enter Second Number : ");
        BigDecimal num2 = cin.nextBigDecimal();
        System.out.print("Enter Operator : ");
        char operator = cin.next().charAt(0);
        BigDecimal reslut = new BigDecimal('0');
        switch(operator) {
            case '+': {
                reslut = num1.add(num2);
                break;
            }
            case '-': {
                reslut = num1.subtract(num2);
                break;
            }
            case '*': {
                reslut = num1.multiply(num2);
                break;
            }
            case '/': {
                reslut = num1.divide(num2, MathContext.DECIMAL32);
                break;
            }
            default: {
                reslut = new BigDecimal('0');
            }
        }
        System.out.println("Your Result is : " + reslut);
        cin.close();
    }
}
