package Ordermanager.Testing.Exceptions;

public class NotEnoughMoneyException extends Exception {
    private double price;
    private double balance;
    public double getPrice(){
        return price;
    }
    public double getBalance(){
        return balance;
    }
    public NotEnoughMoneyException(String message){
        super(message);

    }
}
