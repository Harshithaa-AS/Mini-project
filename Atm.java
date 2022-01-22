import java.util.*;

class Atm {
    static int amount[] = { 0, 0, 0, 0 };
    static int amountnum[] = { 2000, 500, 200, 100 };
    static String name[] = { "Harshithaa", "Suji" };
    static String pass[] = { "510914", "555" };
    static String bank[] = { "State", "Indian" };
    static int WithDraw_count = 0;
    static int Transfer_count = 0;
    static int account[] = { 50000, 15000 };
    static int amt, total;
    static boolean ApplyCom = false;
    static int count = 0;
    static int j = 0;
    static ArrayList<String> mini = new ArrayList<>();
    static int a, b, c, d, e, f, g, h;
    private static Scanner sc;

    static void add_amt() {
        System.out.print("\033[H\033[2J");
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter number of " + amountnum[i] + " is ");
            amount[i] += sc.nextInt();
            System.out.print("\033[H\033[2J");
        }
        for (int i = 0; i < 4; i++) {

            total += amountnum[i] * amount[i];
        }
        System.out.println("Amount added Successfully");
        System.out.println();
        System.out.println("Please press enter for previous menu");
        try {
            System.in.read();
            adminfunc();
        } catch (Exception e) {
        }
    }

    static void show_amt() {
        System.out.print("\033[H\033[2J");
        for (int i = 0; i < 4; i++) {
            System.out.println("Number of notes in " + amountnum[i] + " is " + amount[i]);
        }
        System.out.println("Total amount added " + total);
        System.out.println();
        System.out.println("Please press enter for previous menu");
        try {
            System.in.read();
            adminfunc();
        } catch (Exception e) {
        }
    }

    static void withdraw_amt(int i) {

        System.out.print("\033[H\033[2J");
        System.out.println("Enter the amount");
        amt = sc.nextInt();
        if (account[i] >= amt) {
            if (total < amt) {
                System.out.println("No Cash to Dispence");
                System.out.println();
                System.out.println("Please press enter for previous menu");
                try {
                    System.in.read();
                    userfunc(i);
                } catch (Exception e) {
                }
            } else {

                total -= amt;
                if (ApplyCom) {
                    if (amt % 100 == 0) {
                        if (account[i] >= amt + 100) {
                            account[i] -= 100;
                            with(amt);
                            Transfer_count++;
                            account[i] -= amt;
                            trans(String.valueOf(amt), "Withdrawn");
                            System.out.println("Amount Withdraw Successfully");
                            System.out.println();
                            System.out.println("Please press enter for previous menu");
                            try {
                                System.in.read();
                                userfunc(i);
                            } catch (Exception e) {
                            }
                        } else {
                            System.out.println("Insufficent balance for Extra transation");
                            System.out.println();
                            System.out.println("Please press enter for previous menu");
                            try {
                                System.in.read();
                                userfunc(i);
                            } catch (Exception e) {
                            }
                        }
                    } else {
                        System.out.println("Invalid Input");
                        System.out.println();
                        System.out.println("Please press enter for previous menu");
                        try {
                            System.in.read();
                            userfunc(i);
                        } catch (Exception e) {
                        }
                    }

                } else {

                    if (amt % 100 == 0) {
                        with(amt);
                        Transfer_count++;
                        account[i] -= amt;
                        trans(String.valueOf(amt), "Withdrawn");
                        System.out.println("Amount Withdraw Successfully");
                        System.out.println();
                        System.out.println("Please press enter for previous menu");
                        try {
                            System.in.read();
                            userfunc(i);
                        } catch (Exception e) {
                        }
                    } else {
                        System.out.println("Invalid Input");
                        System.out.println();
                        System.out.println("Please press enter for previous menu");
                        try {
                            System.in.read();
                            userfunc(i);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        } else {
            System.out.println("Insufficent balance in your account " + account[i]);
            System.out.println();
            System.out.println("Please press enter for previous menu");
            try {
                System.in.read();
                userfunc(i);
            } catch (Exception e) {
            }
        }
    }

    static void trans(String a, String b) {
        mini.add("The Amount is " + a + ": " + b);
    }

    static void transaction(int n) {

        System.out.print("\033[H\033[2J");
        int indx = mini.size() - 1, i = 0;
        if (Transfer_count >= 6) {
            while (i < 6) {
                System.out.println(mini.get(indx));
                i++;
                indx--;
            }

            System.out.println();
            System.out.println("Please press enter for previous menu");
            try {
                System.in.read();
                userfunc(n);
            } catch (Exception e) {
            }
        } else {
            System.out.println("Required Minimum 6 Transactions");
            System.out.println();
            System.out.println("Please press enter for previous menu");
            try {
                System.in.read();
                userfunc(n);
            } catch (Exception e) {
            }
        }
    }

    static void Amount_transfer(int n) {
        System.out.print("\033[H\033[2J");
        System.out.println("Enter Username to Transfer:");
        sc.nextLine();
        String toUser = sc.nextLine().trim();
        if (Arrays.asList(name).contains(toUser)) {
            System.out.println("Enter Amount:");
            int Amount = sc.nextInt();
            if (account[n] >= Amount) {
                Transfer_count++;
                for (int i = 0; i < name.length; i++) {
                    if (name[i].equals(toUser)) {
                        account[i] += Amount;
                        account[n] -= Amount;
                        break;
                    }
                }
                trans(String.valueOf(Amount), "Transfered");
                System.out.println("Amount Transfered Successfully");
                System.out.println();
                System.out.println("Please press enter for previous menu");
                try {
                    System.in.read();
                    userfunc(n);
                } catch (Exception e) {
                }
            } else {
                System.out.println("Insufficent Balance");
                System.out.println();
                System.out.println("Please press enter for previous menu");
                try {
                    System.in.read();
                    userfunc(n);
                } catch (Exception e) {
                }
            }
        } else {
            System.out.println("Invalid UserName");
            System.out.println();
            System.out.println("Please press enter for previous menu");
            try {
                System.in.read();
                userfunc(n);
            } catch (Exception e) {
            }
        }
    }

    static void show_bal(int i) {
        System.out.print("\033[H\033[2J");
        System.out.println("Your account balance is " + account[i]);
        System.out.println();
        System.out.println("Please press enter for previous menu");
        try {
            System.in.read();
            userfunc(i);
        } catch (Exception e) {
        }
    }

    static void adminfunc() {
        System.out.print("\033[H\033[2J");
        System.out.println("1. Add Amount");
        System.out.println("2. Show Amount");
        System.out.println("3. Back");
        int ch1 = sc.nextInt();
        switch (ch1) {
            case 1:
                add_amt();
                break;
            case 2:
                show_amt();
                break;
            case 3:
                mainfunc();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    static void userfunc(int i) {
        System.out.print("\033[H\033[2J");
        System.out.println("1. Withdraw Amount");
        System.out.println("2. Account Balance");
        System.out.println("3. Mini Statement");
        System.out.println("4. Pin change");
        System.out.println("5. Deposite Amount");
        System.out.println("6. Amount Transfer");
        System.out.println("7. Back");
        int ch1 = sc.nextInt();
        switch (ch1) {
            case 1:
                if (bank[i] == "State") {
                    withdraw_amt(i);
                    break;
                } else if (WithDraw_count < 1) {
                    WithDraw_count += 1;
                    withdraw_amt(i);
                    break;
                } else {
                    ApplyCom = true;
                    withdraw_amt(i);
                }
            case 2:
                show_bal(i);
                break;
            case 3:
                transaction(i);
                break;
            case 4:
                pinchange(i);
                break;
            case 5:
                depositeAmt(i);
                break;
            case 6:
                Amount_transfer(i);
                break;
            case 7:
                mainfunc();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    static void adminlogin() {
        System.out.print("\033[H\033[2J");
        System.out.println("Enter Admin Id");
        sc.nextLine();
        String adminid = sc.nextLine();
        System.out.print("\033[H\033[2J");
        if (adminid.equals("AI")) {
            System.out.println("Enter Password");
            String adminpass = sc.nextLine();
            if (adminpass.equals("123456")) {
                adminfunc();
            } else {
                System.out.println("Invalid password");
            }
        } else {
            System.out.println("Invalid admin id");
        }
    }

    static void userlogin() {
        System.out.print("\033[H\033[2J");
        if (count < 9) {
            System.out.print("\033[H\033[2J");
            count++;
            System.out.println("Enter Username");
            sc.nextLine();
            String username = sc.nextLine();
            System.out.print("\033[H\033[2J");
            if (username.equals(name[0])) {
                System.out.println("Enter Password");
                String userpass = sc.nextLine();
                if (userpass.equals(pass[0])) {
                    Transfer_count = 0;
                    mini.clear();
                    userfunc(0);
                } else {
                    System.out.println("Invalid password");
                }
            } else if (username.equals(name[1])) {
                System.out.println("Enter Password");
                String userpass = sc.nextLine();
                if (userpass.equals(pass[1])) {
                    userfunc(1);
                } else {
                    System.out.println("Invalid password");
                }
            } else {
                System.out.println("Invalid Username");
            }
        } else {
            System.out.println("Login Attempt Exceeded");
        }
    }

    static void mainfunc() {
        System.out.print("\033[H\033[2J");
        int ch = 0;
        System.out.println("ATM MACHINE");
        System.out.println("1. Admin Login");
        System.out.println("2. User Login");
        System.out.println("3. Exit");
        System.out.println("Enter your choice");
        ch = sc.nextInt();
        switch (ch) {
            case 1:
                adminlogin();
                break;
            case 2:
                userlogin();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

    static void pinchange(int i) {
        System.out.print("\033[H\033[2J");
        System.out.println("Enter Old Password");
        String oldpass = sc.next();
        if (pass[i].equals(oldpass)) {
            System.out.print("\033[H\033[2J");
            System.out.println("Enter new password");
            String newpass = sc.next();
            pass[i] = newpass;
            System.out.println("Password Changed");
        } else {
            System.out.println("Password incorrect");
        }
        System.out.println();
        System.out.println("Please press enter for previous menu");
        try {
            System.in.read();
            userfunc(i);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        mainfunc();
    }

    static void depositeamt(int i) {
        System.out.print("\033[H\033[2J");
        int v = 0;
        for (int k = 0; k < 4; k++) {
            System.out.println("Enter number of " + amountnum[k] + " is ");
            int t = sc.nextInt();
            v += t * amountnum[k];
            amount[k] += t;
            System.out.print("\033[H\033[2J");
        }
        account[i] += v;
        total += v;

        System.out.println("Amount added Successfully");
        System.out.println();
        System.out.println("Please press enter for previous menu");
        try {
            System.in.read();
            userfunc(i);
        } catch (Exception e) {
        }

    }

    static void with(int n) {

        for (int i = 0; i < amount.length; i++) {
            if (n >= amountnum[i]) {
                int temp = Math.abs(amount[i] - (n / amountnum[i]));

                int rec = (temp - amount[i] == 0) ? temp : Math.abs(temp - amount[i]);
                int mul = rec * amountnum[i];
                n -= mul;
                amount[i] -= rec;
            }
        }
    }
}