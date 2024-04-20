import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    // GLBAL VARIABLES THAT  WILL BE USED BY METHOS
    private static User user1 = new User(0, 0, 100000, 0, 0);
    private static int phoneNumber = user1.get_phoneNumber();
    private static int mpesaPin = user1.get_mpesaPin();
    private static float mpesaBalance = user1.get_mpesaBalance();
    private static int airtimeBalance = user1.get_airtimeBalance();
    private static int dataBalance = user1.get_dataBalance();
    private static List<String> transactionHistory = new ArrayList<>();

    // MAIN METHOD
    public static void main(String[] args) throws Exception {
        // WELCOME MESSAGE
        System.out.println("*=======================================*\n"+
                           "*_| S | A | F | A | R | I | C | O | M |_*\n"+
                           "*---------------------------------------*\n"+
                           "*- __________.-.__________.--._.----._.-*\n"+
                           "*-|  ________.-.__________.--| |---/ /--*\n"+
                           "*-| |--------------|  |------| |--/ /---*\n"+
                           "*-| |--------------|  |------| |-/ /----*\n"+
                           "*-| |________------|  |------| |/ /-----*\n"+
                           "*-|________ |------|  |------| |\\ \\-----*\n"+
                           "*---------| |------|  |------| |-\\ \\----*\n"+
                           "*---------| |------|  |------| |--\\ \\---*\n"+
                           "*.________| |------|  |------| |---\\ \\--*\n"+
                           "*.__________|------|__|------|_|----\\ \\-*\n"+
                           "*---------------------------------------*\n"+
                           "*=======================================*\n");
        //    FIRST METHOD TO ALLOW USER TO SETUP ACCOUNT
        userSetting();
    }

    // ABSTRACTION
    // POLYMORPHISM
    // BELOW ARE ALL THE METHODS
    // USER TO INPUT THEIR MOBILE PHONE NUMBER AND PIN
    public static void userSetting() {
        System.out.println("Enter: \n1. Phone Number (Press Enter)\n2. M-Pesa PIN (Press Enter)\n");
        Scanner scanner = new Scanner(System.in);
        phoneNumber = scanner.nextInt();
        mpesaPin = scanner.nextInt();
        System.out.println("Success!\nPhone Number: " + phoneNumber + "\n");
        restart();
        scanner.close();
    }

    // DISPLAYS A LIST OF OPTIONS PROMPTING THE USER TO SELECT ACTION
    public static void menuOptions() {
        System.out.println(
                "Menu:\nSelect:\n1. Check Airtime Balance\n2. Purchase Airtime\n3. Check Data Balance\n4. Subscribe to Data Bundles\n5. Check Mpesa Balance\n6. Transaction History\n7. Change My M-Pesa PIN\n");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // System.out.println("Fetching Airtime Balance...");
                checkAirtimeBalance();
                break;
            case 2:
                // System.out.println("Success purchase");
                purchaseAirtime();
                break;
            case 3:
                // System.out.println("Fetching Data Balance...");
                checkDataBalance();
                break;
            case 4:
                // System.out.println("Success! new Subscription");
                subscribeToDataBundle();
                break;
            case 5:
                // System.out.println("Fetching M-Pesa Balance...");
                checkMpesaBalance();
                break;
            case 6:
                // System.out.println("Querying Transaction History...");
                transactionHistory();
                break;
            case 7:
                // System.out.println("PIN Changed!");
                changePin();
                break;
            default: {
                System.out.println("Invalid Option!");
            }
        }

        scanner.close();

        restart();
    }

    // IF SELECTED SHOWS AIRTIM BALANCE
    public static void checkAirtimeBalance() {
        System.out.println("Airtime Balance: " + airtimeBalance + "KES\n");
        restart();
    }

    // IF SELECTED , USER CAN PURCHASE AIRTIME
    public static void purchaseAirtime() {
        System.out.println("Enter Your Phone Number: ");
        Scanner scanner = new Scanner(System.in);
        int inputPhone = scanner.nextInt();
        if (inputPhone == phoneNumber) {
            // success
            System.out.println("Enter Your PIN: ");
            int inputPin = scanner.nextInt();

            if (inputPin == mpesaPin) {
                // success
                System.out.println("Exsisting Airtime Balance: " + airtimeBalance + "KES\n" + "Enter Amount: ");
                int amount = scanner.nextInt();
                if (amount <= mpesaBalance) {
                    // success
                    airtimeBalance += amount;
                    mpesaBalance -= amount;

                    System.out.println("Success!\nAirtime Balance: " + airtimeBalance + "KES\n" + "M-Pesa Balance: "
                            + mpesaBalance + "KES\n");

                    addToTransactionHistory("Purchased Airtime", amount );
                    addToTransactionHistory("Bought Airtime From M-Pesa", -amount);
                    restart();
                } else if (amount > mpesaBalance) {
                    // denied
                    System.out
                            .println("Failed! Insufficient Airtime! Please Recharge Your Account. Please Try Again\n");
                    restart();
                    ;
                }
            } else {
                // denied
                System.out.println("Incorrect PIN! Please Try Again.\n");
                restart();
            }
        } else {
            System.out.println("Incorrect Phone Number! Please Try Again\n");
            purchaseAirtime();
        }
        scanner.close();
    }

    // IF SELECTED QUERRIES DATA BALANCE FROM USER'S ACCOUNT
    public static void checkDataBalance() {
        System.out.println("Enter Phone Number: ");
        Scanner scanner = new Scanner(System.in);
        int inputPhone = scanner.nextInt();
        if (inputPhone == phoneNumber) {
            // success
            System.out.println("Data Balance : " + dataBalance + "MB\n");
            restart();
        }
        // else if (!inputPhone.equals(phoneNumber)) {
        // System.out.println("Incorrect Phone Number! Please Try Again");
        // }
        else {
            System.out.println("Incorrect Phone Number! Please Try Again\n");
            checkDataBalance();
        }
        scanner.close();
    }

    //  IF SELECTED , THE USER CAN BUY DATA BUNDLE FROM THEIR AIRTIME LIMITED TO THEIR BALANCE.
    public static void subscribeToDataBundle() {
        System.out.println("Enter Your Phone Number: ");
        Scanner scanner = new Scanner(System.in);
        int inputPhone = scanner.nextInt();
        if (inputPhone == phoneNumber) {
            // success
            System.out.println(
                    "Select: \n1. Daily(300MB 24HRS 20KES)\n2. Weekly (7000MB 7DAYS 300KES)\n3. Monthly(30000MB 30DAYS 1000KES)\n");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    if (20 <= airtimeBalance) {
                        // success
                        dataBalance += 300;
                        airtimeBalance -= 20;
                        System.out.println("Success!\nData Balance: " + dataBalance + "MB\n" + "Airtime Balance: "
                                + airtimeBalance + "KES\n");
                        restart();
                    } else {
                        // denied
                        System.out.println("Insufficient Airtime! Please Recharge Your Account");
                        restart();
                    }
                    break;
                case 2:
                    if (300 <= airtimeBalance) {
                        // success
                        dataBalance += 7000;
                        airtimeBalance -= 300;
                        System.out.println("Success!\nData Balance: " + dataBalance + "MB\n" + "Airtime Balance: "
                                + airtimeBalance + "KES\n");
                        restart();
                    } else {
                        // denied
                        System.out.println("Insufficient Airtime! Please Recharge Your Account");
                        restart();
                    }
                    break;
                case 3:
                    if (20 <= airtimeBalance) {
                        // success
                        dataBalance += 30000;
                        airtimeBalance -= 1000;
                        System.out.println("Success!\nData Balance: " + dataBalance + "MB\n" + "Airtime Balance: "
                                + airtimeBalance + "KES\n");
                        restart();
                    } else {
                        // denied
                        System.out.println("Insufficient Airtime! Please Recharge Your Account");
                        restart();
                    }
                    break;
                default: {
                    System.out.println("Invalid Choice! Please Try Again");
                    subscribeToDataBundle();
                }
                    break;
            }
            restart();
        } else {
            System.out.println("Incorrect Phone Number! Please Try Again\n");
            subscribeToDataBundle();
        }
        scanner.close();
    }

    // IF SELECTED THE USER CAN QUERRY THEIR MPESA BALANCE WITH THE CORRECT PIN.
    public static void checkMpesaBalance() {
        System.out.println("Enter Your Phone Number: ");
        Scanner scanner = new Scanner(System.in);
        int inputPhone = scanner.nextInt();
        if (inputPhone == phoneNumber) {
            // success
            System.out.println("Enter PIN: ");
            int inputPin = scanner.nextInt();
            if (inputPin == mpesaPin) {
                // success
                System.out.println("Dear Customer Your M-Pesa Balance is: " + mpesaBalance + "KEs\n");
                restart();
            }
        } else {
            // denied
            System.out.println("Incorrect Phone Number! Please Try Again\n");
            checkAirtimeBalance();
        }
        scanner.close();
    }

    // IF SELECTED THE USER CAN CHANGE THEIR MPESA PIN
    public static void changePin() {
        System.out.println("Enter Your Old PIN: ");
        Scanner scanner = new Scanner(System.in);
        int inputPin = scanner.nextInt();
        if (inputPin == mpesaPin) {
            // success
            System.out.println("Enter New  PIN: ");
            int newPin = scanner.nextInt();
            mpesaPin = newPin;
            System.out.println("Success! PIN Changed\n");
        } else {
            System.out.println("Icorrect PIN ! PLease try Again\n");
            changePin();
        }
        restart();
        scanner.close();
    }

    // THIS METHOD ALLOWS THE USER TO END SESSION AFTER ACTIONS OR CONTINUE WITH THE MENU OPTIONS
    public static void restart() {
        System.out.println("Select: \n1. To Continue\n2. To End Session\n");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                menuOptions();
                break;
            case 2:
                System.out.println("Session Ended Successfully.");
                break;
            default: {
                System.out.println("Invalid Option! Please Try Again");
                restart();
            }
        }
        scanner.close();
    }

    // THIS METHOD ADDS EVERY ACTION / TRANSACTION TO TRANSACTON HISTORY
    public static void addToTransactionHistory (String transactionType, double amountTransacted) {
        String transaction = transactionType + ": " + amountTransacted + "KES\n";
        transactionHistory.add(transaction);
    }

    //  WHEN SELECTED THE USER CAN GET THEIR TRANSACTION HISTORY PRINTED OUT AS A STRING
    public static void transactionHistory() {
        System.out.println("Enter M-pesa Pin: ");
        Scanner scanner = new Scanner(System.in);
        int inputPin = scanner.nextInt();

        if (inputPin == mpesaPin) {
            // success
            System.out.println("Transaction History: \n");
            if (transactionHistory.isEmpty()) {
                System.out.println("No Transactions Yet!");
            } else {
                for (String transaction : transactionHistory) {
                    System.out.println(transaction);
                }
            }
            restart();
        } else {
            System.out.println("Incorrect PIN! Please Try Again.");
            transactionHistory();
        }

        scanner.close();
    }

}
