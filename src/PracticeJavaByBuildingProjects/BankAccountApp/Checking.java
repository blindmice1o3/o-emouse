package PracticeJavaByBuildingProjects.BankAccountApp;

public class Checking extends Account {
    // List properties specific to the Checking account
    private int debitCardNumber;
    private int debitCardPIN;

    // Constructor to initialize settings for the Checking properties
    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;
    }

    // List any methods specific to checking account
    private void setDebitCard() {
        //debitCardNumber = (long) ((Math.random() * (long)(900000*1000000)) + (long)(100000*1000000)); //couldn't get to work
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12)); //doesn't always display 12 digits
        debitCardPIN = (int) (Math.random() * Math.pow(10, 4));;

    }

    public void showInfo() {
        super.showInfo();
        System.out.println(
                "Your Checking Account Features" +
                "\n Debit Card Number: " + debitCardNumber +
                "\n Debit Card PIN: " + debitCardPIN
                );
    }

}
