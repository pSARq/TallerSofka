package taller_kata;

public class StartApp {
    public static void main(String[] args) {

        Account account = new Account("taller kata", 0);

        account.deposit(1000, "10/01/2021");
        account.deposit(2000, "13/01/2021");
        account.withdraw(500, "14/01/2021");

        account.printStatements();
    }
}
