import java.util.Scanner;

public class D23_12_07 {
    public static void main(String[] args) {
        // ex1();
        ex2();
    }
    public static void ex1() {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter Input : ");
        String text = s.nextLine();
        String temp;
        boolean isCon = true;

        while (isCon) {
            
            System.out.println("1. Count the number of characters in the sentence.");
            System.out.println("2. Count the number of words in the sentence.");
            System.out.println("3. Convert the sentence to uppercase.");
            System.out.println("4. Convert the sentence to lowercase.");
            System.out.println("5. Exit");

            System.out.print("Enter Choices : ");
            int num = s.nextInt();

            switch(num) {
                case 1: {
                    temp = text;
                    temp = temp.replaceAll("\\s", "");
                    
                    System.out.println("number of characters in the sentence : " + temp.length());
                    break;
                }
                case 2: {
                    String[] temp1 = text.split(" ");

                    System.out.println("number of words in the sentence : " + temp1.length);
                    break;
                }
                case 3: {
                    System.out.println("Uppercase : " + text.toUpperCase());
                    break;
                }
                case 4: {
                    System.out.println("Lowercase : " + text.toLowerCase());
                    break;

                }
                case 5: {

                    isCon = false;
                    break;
                }
                default: {
                    System.out.println("Error : wrong choice!");
                }
            }
            System.out.println("\n\n\n");
        }



        s.close();
    }

    public static void ex2() {
        Scanner s = new Scanner(System.in);
        
        boolean isCon = true;
        int choice;

        String[] name = {"", "", ""};
        int[] number = {0,0,0}; 

        while(isCon) {
            System.out.println("1. View available products and their quantities.");
            System.out.println("2. Add a new product to the inventory with a specified quantity.");
            System.out.println("3. Update the quantity of an existing product in the inventory.");
            System.out.println("4. Remove a product from the inventory.");
            System.out.println("5. Exit");

            System.out.print("Input choice : ");
            choice = s.nextInt();

            switch (choice) {
                case 1: {
                    boolean check = true;
                    for(int i=0; i<name.length; i++) {
                        if(name[i] != "") {
                            System.out.println("Product name: " + name[i]);
                            System.out.println("Quantity: " + number[i]);
                            check = false;
                        }
                        System.out.println("\n");
                    }
                    if(check) {
                        System.out.println("Inventory is Empty !");
                    }
                    break;
                }
                case 2: {
                    boolean check = true;
                    for(int i=0; i<name.length; i++) {
                        if(name[i] == "" && check) {
                            System.out.print("Enter Product Name: ");
                            name[i] = s.next();
                            System.out.print("Enter Quantity: ");
                            number[i] = s.nextInt();
                            check = false;
                        }
                        System.out.println("\n");
                    }
                    if(check) {
                        System.out.println("Inventory is Full !");
                    }
                    break;
                }
                case 3: {
                    boolean check = true;
                    System.out.print("Enter Product Name: ");
                    String temp = s.next();
                    for(int i=0; i<name.length; i++) {
                        if(name[i].equals(temp)) {
                            System.out.print("Enter Quantity: ");
                            number[i] = s.nextInt();
                            check = false;
                        }
                        System.out.println("\n");
                    }
                    if(check) {
                        System.out.println("Can't Find product in Inventory");
                    }
                    break;
                }
                case 4: {
                    boolean check = true;
                    System.out.print("Enter Product Name: ");
                    String temp = s.next();
                    for(int i=0; i<name.length; i++) {
                        if(name[i].equals(temp)) {
                            name[i] = "";
                            number[i] = 0;
                            System.out.println("delete Sucessfull !");
                            check = false;
                        }
                        System.out.println("\n");
                    }
                    if(check) {
                        System.out.println("Can't Find product in Inventory");
                    }
                    break;
                }
                case 5: {
                    isCon = false;
                    break;
                }
                    
            
                default:
                    System.out.println("Error : wrong Choice");
                    break;
            }
            System.out.println("\n\n\n");
        }


        s.close();
    }
}
