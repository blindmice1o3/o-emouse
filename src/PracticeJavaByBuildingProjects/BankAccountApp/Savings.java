package PracticeJavaByBuildingProjects.BankAccountApp;

public class Savings extends Account {
    // List properties specific to the Savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // Constructor to initialize settings for the Savings properties
    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    // List any methods specific to savings account
    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int) ((Math.random() * 900) + 100);
        //safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3)); //doesn't always display 3 digits
        safetyDepositBoxKey = (int) ((Math.random() * 9000) + 1000);
        //safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4)); //doesn't always display 4 digits
    }

    public void showInfo() {
        super.showInfo();
        System.out.println(
                "Your Savings Account Features" +
                "\n Safety Deposit Box ID: " + safetyDepositBoxID +
                "\n Safety Deposit Box Key: " + safetyDepositBoxKey
                );
    }

}
