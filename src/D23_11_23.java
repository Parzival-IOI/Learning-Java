import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Random;

public class D23_11_23 {
    public static void main(String[] args) {
        // ex1();
        // ex2();
        ex2_Test();
    }
    public static void ex1 () {
        Scanner cin = new Scanner(System.in);
        Random random = new Random();
        int max = 50, min = 1;
        int randomNumber = random.nextInt(max - min + 1) + min;
        int guess = 0;
        int count = 0;
        do {
            System.out.print("Enter Value to Guess : ");
            guess = cin.nextInt();
            if(guess > max || guess < min) {
                System.out.println("Your Value is out of Scope");

                continue;
            }
            if(guess == randomNumber) {
                System.out.println("Yay You Win. The Number was really : " + randomNumber + "\nAnd your attempt is " + (count+1) );
                break;
            }
            if(guess > randomNumber) {
                System.out.println("Your Value is too high");
            }
            if (guess < randomNumber) {
                System.out.println("Your Value is too Low");
            }
            count++;

        }while(true);
        cin.close();
    }
    public static void ex2 () {
        Scanner cin = new Scanner(System.in);
        int input = -1;
        BigDecimal money = new BigDecimal("10.0");
        BigDecimal zero = new BigDecimal("0.0");
        BigDecimal[] value;
        value = new BigDecimal[4];
        value[0] = new BigDecimal("1.25");
        value[1] = new BigDecimal("1.50");
        value[2] = new BigDecimal("1.75");
        value[3] = new BigDecimal("0.25");
        int coke = 5, pepsi = 5, milk = 5, water = 5;
        do {
            System.out.println("The initial balance of the user is " + money + "$");
            System.out.println("Items : ");
            System.out.println("1. Coke for 1.25$ (" + coke +") Left");
            System.out.println("2. Pepi for 1.50$ (" + pepsi +") Left");
            System.out.println("3. Milk for 0.75$ (" + milk +") Left");
            System.out.println("4. Water for 0.25$ (" + water +") Left");
            System.out.print("Enter Your Choice : ");
            input = cin.nextInt();
            if(money.compareTo(zero) == 0) {
                System.out.println("You're Out of Money.\nPress 0 To Exit");
                continue;
            }
            switch(input) {
                case 1 : {
                    if(coke > 0) {
                        if(money.compareTo(value[input-1]) == 1 || money.compareTo(value[input-1]) == 0 ) {
                            money = money.subtract(value[input-1]);
                            System.out.println("You bought Coke : 1.25$");
                        }
                        else {
                            System.out.println("You Don't have Enough Money");
                            continue;
                        }
                        coke--;
                    }
                    else {
                        System.out.println("OUT OF ORDER");
                    }
                    break;
                }
                case 2 : {
                    if(pepsi > 0){
                        if(money.compareTo(value[input-1]) == 1 || money.compareTo(value[input-1]) == 0 ) {
                            money = money.subtract(value[input-1]);
                            System.out.println("You bought Pepsi : 1.50$");
                        }
                        else {
                            System.out.println("You Don't have Enough Money");
                            continue;
                        }
                        pepsi--;
                    }
                    else {
                        System.out.println("OUT OF ORDER");
                    }
                    break;
                }
                case 3 : {
                    if(milk > 0) {
                        if(money.compareTo(value[input-1]) == 1 || money.compareTo(value[input-1]) == 0 ) {
                            money = money.subtract(value[input-1]);
                            System.out.println("You bought Milk : 1.75$");
                        }
                        else {
                            System.out.println("You Don't have Enough Money");
                            continue;
                        }
                        milk--;
                    }
                    else {
                        System.out.println("OUT OF ORDER");
                    }
                    break;
                }
                case 4 : {
                    if(water > 0) {
                        if(money.compareTo(value[input-1]) == 1 || money.compareTo(value[input-1]) == 0 ) {
                            money = money.subtract(value[input-1]);
                            System.out.println("You bought Water : 0.25$");
                        }
                        else {
                            System.out.println("You Don't have Enough Money");
                            continue;
                        }
                        water--;
                    }
                    else {
                        System.out.println("OUT OF ORDER");
                    }
                    break;
                }
                default: {
                    System.out.println("You Enter Wrong Option");
                    break;
                }
            }
            System.out.println("\n");
        }while(input != 0);
        cin.close();
    }

    public static void ex2_Test () {
        Scanner cin = new Scanner(System.in);
        int input = -1;
        BigDecimal money = new BigDecimal("10.0");
        BigDecimal zero = new BigDecimal("0.0");

        Items items[];
        items = new Items[4];
        items[0] = new Items(1, "Coke", new BigDecimal("1.25"), 5);
        items[1] = new Items(2, "Pepsi", new BigDecimal("1.50"), 5);
        items[2] = new Items(3, "Milk", new BigDecimal("1.75"), 5);
        items[3] = new Items(4, "Water", new BigDecimal("0.25"), 5);

        do {
            System.out.println("The initial balance of the user is " + money + "$");
            System.out.println("Items : ");
            for(Items i : items) {
                System.out.println(i.id + ". " + i.name + " for " + i.value + "$ (" + i.amount +") Left");
            }
            System.out.print("Enter Your Choice : ");
            input = cin.nextInt();
            if(money.compareTo(zero) == 0) {
                System.out.println("You're Out of Money.\nPress 0 To Exit");
                continue;
            }
            switch(input) {
                case 1 :
                case 2 :
                case 3 :
                case 4 :
                {
                    if(items[input-1].amount > 0)
                    {
                        int index = input-1;
                        if(money.compareTo(items[index].value) == 1 || money.compareTo(items[index].value) == 0 ) {
                            money = money.subtract(items[index].value);
                            System.out.println("You bought " + items[index].name + " : " + items[index].value + "$");
                        }
                        else {
                            System.out.println("You Don't have Enough Money");
                            continue;
                        }
                        items[index].amount -= 1;
                    }
                    else {
                        System.out.println("OUT OF ORDER");
                    }
                    break;
                }
                default: {
                    System.out.println("You Enter Wrong Option");
                    break;
                }
            }
            System.out.println("\n");
        } while(input != 0);
        cin.close();
    }
}

class Items {
    public int id;
    public String name;
    public BigDecimal value;
    public int amount;
    public Items(int id, String name, BigDecimal value, int amount) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.amount = amount;
    }
}
