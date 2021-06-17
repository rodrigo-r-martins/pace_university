import java.rmi.*;
import java.util.Scanner;

public class BankClient {

    private static Scanner keyboard;

    public static void main(String args[]) {

        String name = "";
        float amount = 0;
        int number = 0;

        try {
            int port = 16790;
            String host = "localhost";
            String registryURL = "rmi://" + host + ":" + port + "/bank";
            AccountInterface h = (AccountInterface)Naming.lookup(registryURL);

            keyboard = new Scanner(System.in);
            int code = 1;
            while (code >= 1 && code <= 5) {
                System.out.print("==== Options menu: ====" +
                        "\n1) Create account" +
                        "\n2) Get balance" +
                        "\n3) Withdraw" +
                        "\n4) Deposit" +
                        "\n5) Transfer" +
                        "\n6) Exit" +
                        "\n ===> Enter your option: ");
                code = keyboard.nextInt();
                if (code < 1 || code > 6) {
                    System.out.println("Try again: ");
                    code = keyboard.nextInt();
                }
                switch (code) {
                    case 1:
                        System.out.print("Enter the name of the person: ");
                        name = keyboard.next();
                        System.out.print("Enter the amount: ");
                        amount = keyboard.nextFloat();
                        System.out.println("===== Bank statement =====");
                        System.out.println(h.createAccount(name, amount));
                        System.out.println("==========================");
                        break;
                    case 2:
                        System.out.print("Enter the name of the person: ");
                        name = keyboard.next();
                        System.out.print("Enter the account number: ");
                        number = keyboard.nextInt();
                        System.out.println("===== Bank statement =====");
                        System.out.println(h.getBalance(name, number));
                        System.out.println("==========================");
                        break;
                    case 3:
                        System.out.print("Enter the name of the person: ");
                        name = keyboard.next();
                        System.out.print("Enter the amount: ");
                        amount = keyboard.nextFloat();
                        System.out.print("Enter the account number: ");
                        number = keyboard.nextInt();
                        System.out.println("===== Bank statement =====");
                        System.out.println(h.withdraw(name, amount, number));
                        System.out.println("==========================");
                        break;
                    case 4:
                        System.out.print("Enter the name of the person: ");
                        name = keyboard.next();
                        System.out.print("Enter the amount: ");
                        amount = keyboard.nextFloat();
                        System.out.print("Enter the account number: ");
                        number = keyboard.nextInt();
                        System.out.println("===== Bank statement =====");
                        System.out.println(h.deposit(name, amount, number));
                        System.out.println("==========================");
                        break;
                    case 5:
                        System.out.print("Enter the name of the person: ");
                        name = keyboard.next();
                        System.out.print("Enter the amount: ");
                        amount = keyboard.nextFloat();
                        System.out.print("Enter the account number that take from: ");
                        number = keyboard.nextInt();
                        System.out.print("Enter the account number to transfer: ");
                        int number2 = keyboard.nextInt();
                        System.out.println("===== Bank statement =====");
                        System.out.println(h.transfer(name, number, number2, amount));
                        System.out.println("==========================");
                        break;
                    case 6:
                        System.out.println("Exiting bank program.");
                        break;
                    default:
                        System.out.println("Wrong number. Try again.");
                        break;
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

