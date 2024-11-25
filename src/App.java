import java.util.Scanner;

public class App {
    private static float balance;
    private static final int PIN = 7838;

    public static void main(String[] args) throws Exception {
        checkPin();
    }

    private static void checkPin() {
        System.out.println("Enter your 4-Digit Pin 🫣");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();
        if (enteredPin == PIN) {
            menu();
        } else {
            System.out.println("Incorrect Pin. Please try again");
            checkPin();
        }
    }

    private static void menu() {
        System.out.println("Please choose your option 🤨");
        System.out.println("1. Check Balance 💰");
        System.out.println("2. Withdraw Money 🤑");
        System.out.println("3. Deposit Money 💶");
        System.out.println("4. Exit 👋");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Your current balance is 👉: " + balance);
                menu();
                break;
            case 2:
                System.out.println("Enter the amount you want to withdraw");
                float withdrawAmount = sc.nextFloat();
                if (withdrawAmount <= balance) {
                    balance -= withdrawAmount;
                    System.out.println("You Withdraw Sucessfully 😊");
                    System.out.println("Your new balance is 👉: " + balance);
                    menu();
                } else {
                    System.out.println("Insufficient balance 😥");
                    menu();
                }
                break;
            case 3:
                System.out.println("Enter the amount you want to deposit 💶");
                float depositAmount = sc.nextFloat();
                balance += depositAmount;
                System.out.println("You deposited successfully 👍");

                // Ask if user wants to see their balance
                System.out.println("Would you like to see your new balance? (Y/N)");
                String response = sc.next().toUpperCase();
                if (response.equals("Y")) {
                    System.out.println("Your new balance is 👉: " + balance);
                } else {
                    System.out.println("Okay, returning to menu.");
                }
                menu();
                break;
            case 4:
                System.out.println("Thank you for using our ATM! 🙏");
                break;
            default:
                System.out.println("Invalid Option ❕. Please try again 😥");
                menu();
        }
    }
}
