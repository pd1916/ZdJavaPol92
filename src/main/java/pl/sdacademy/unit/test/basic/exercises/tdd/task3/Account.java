package pl.sdacademy.unit.test.basic.exercises.tdd.task3;

public class Account {

    private float balance;
    private String accountNumber;
    private Customer customer;

    public Account(float balance, String accountNumber, Customer customer) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.customer = customer;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void transferMoney(Account account, float amount) {
        validate(account, amount);
        transfer(account, amount);
    }

    private void validate(Account account, float amount) {
        validateAccountNumber(this);
        validateAccountNumber(account);
        validateAmount(amount);
    }

    private void validateAccountNumber(Account account) {
        if (account.getAccountNumber().length() != 26 || !account.getAccountNumber().matches("[0-9]+")) {
            throw new IllegalArgumentException("Wrong account number: " + account.accountNumber);
        }
    }

    private void validateAmount(float amount) {
        if (this.balance < amount || amount <= 0) {
            throw new IllegalArgumentException("Wrong value of amount");
        }
    }

    private void transfer(Account account, float amount) {
        this.setBalance(this.getBalance() - amount);
        account.setBalance(account.getBalance() + amount);
    }
}