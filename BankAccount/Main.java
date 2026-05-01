import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<customer> customers = new ArrayList<>();

        customer c1 = new customer("092", "Khushie", "Agrawal", "khushi1805@gmail.com",
                "99813123", "Pune", "375938281", "AHDJWU2");

        customer c2 = new customer("086", "Adele", "Singh", "adele12@gmail.com",
                "9876543210", "Bhopal", "4838939428", "JAJDNWNIRN");

        customer c3 = new customer("087", "Nikki", "Sharma", "nikki28@gmail.com",
                "4938289194", "Delhi", "1938218384", "JWUNRBTHNUBF");

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);

        ArrayList<Account> accounts = new ArrayList<>();

        SavingsAccount sa1 = new SavingsAccount(1001, 6000, c1);
        CurrentAccount ca1 = new CurrentAccount(2001, 20000, c1);

        SavingsAccount sa2 = new SavingsAccount(1002, 8000, c2);
        CurrentAccount ca2 = new CurrentAccount(2002, 17000, c2);

        SavingsAccount sa3 = new SavingsAccount(1003, 4000, c3);

        accounts.add(sa1);
        accounts.add(ca1);
        accounts.add(sa2);
        accounts.add(ca2);
        accounts.add(sa3);

        // SECTION 1
        System.out.println("\n--- Performing Transactions ---\n");
        try {
            sa1.deposit(2000);
            sa1.withdraw(1000);
            sa1.calculateInterest();

            Loan loan = new Loan(12000, 12);
            loan.displayLoan();
            loan.payEMI(sa1);

        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // SECTION 2
        System.out.println("\n--- Customer Summary ---\n");
        displayInfo(customers, accounts);

        // SECTION 3 (Exception test)
        try {
            SavingsAccount tempSa = new SavingsAccount(1001, 6000, c1);
            Loan loan = new Loan(5552000, 12);
            loan.payEMI(tempSa);

        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // SECTION 4 (Minimum balance)
        try {
            SavingsAccount tempSa2 = new SavingsAccount(1001, 6000, c1);
            tempSa2.withdraw(5600);

        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void displayInfo(ArrayList<customer> customers, ArrayList<Account> accounts) {

        for (customer cust : customers) {

            System.out.println("---- CUSTOMER DETAILS ----");
            cust.displayCustomer();

            System.out.println("\n---- ACCOUNTS ----");

            double totalBalance = 0;
            int count = 0;

            for (Account acc : accounts) {
                if (acc.customer.customerID.equals(cust.customerID)) {

                    System.out.println("Account Number: " + acc.accountNumber);
                    System.out.println("Type: " + acc.getClass().getSimpleName());
                    System.out.println("Balance: " + acc.balance);

                    totalBalance += acc.balance;
                    count++;
                    System.out.println();
                }
            }

            System.out.println("Total Accounts: " + count);
            System.out.println("Total Balance: " + totalBalance);
            System.out.println();
        }
    }
}