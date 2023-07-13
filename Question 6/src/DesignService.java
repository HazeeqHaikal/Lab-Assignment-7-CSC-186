public abstract class DesignService {
    private String custName;
    private double deposit;
    private boolean urgentOrder;

    // normal constructor
    public DesignService(String custName, double deposit, boolean urgentOrder) {
        this.custName = custName;
        this.deposit = deposit;
        this.urgentOrder = urgentOrder;
    }

    // getter and setter

    public String getCustName() {
        return this.custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public double getDeposit() {
        return this.deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public boolean isUrgentOrder() {
        return this.urgentOrder;
    }

    public boolean getUrgentOrder() {
        return this.urgentOrder;
    }

    public void setUrgentOrder(boolean urgentOrder) {
        this.urgentOrder = urgentOrder;
    }

    public abstract double calcPayment();

    public String toString() {
        return "Customer Name: " + custName + "\nDeposit: " + deposit + "\nUrgent Order: " + urgentOrder;
    }
}