package lesson2;

public class BankAccount {
    private String id, name;
    private int balance;

    // Constructor
    public BankAccount(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    // Methods
    public int credit(int amount) {
        balance += amount;
        return balance;
    }

    public int debit(int amount) {
        if (amount <= balance) {
            return balance - amount;
        } else {
            System.out.println("На счету не достаточно средств");
        }
        return balance;
    }

    public int transfer(BankAccount account, int amount) {
        if (amount <= balance) {
            balance -= amount;
            account.credit(amount);
        } else {
            System.out.println("На счету не достаточно средств");
        }
        return balance;
    }

    @Override
    public String toString() {
        return String.format("BankAccount[id=%s, name=%s, balance=%d]", id, name, balance);
    }
}

/*
-id: String
-name: String
-balance: int
+BankAccount(id, name, balance)
+get...
+credit(amount: int) : int - добавляем деньги на счет, возвращаем деньги
+debit(amount: int) : int - снимаем деньги только если amount <= balance
                        если не так, то печатаем ошибку и оставляем баланс неизменным
+transfer(account: BankAccount, amount: int) : int -
+toString() : String - Account[id=?, name=?, balance=?]
 */
