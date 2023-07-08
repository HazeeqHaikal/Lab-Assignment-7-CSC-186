public class DigitalDesign extends DesignService {
    private int digitalType;

    // normal constructor
    public DigitalDesign(String custName, double deposit, boolean urgentOrder, int digitalType) {
        super(custName, deposit, urgentOrder);
        this.digitalType = digitalType;
    }

    // getter
    public int getDigitalType() {
        return digitalType;
    }

    // printeer
    public String toString() {
        return super.toString() + "\nDigital Type: " + digitalType;
    }

    // Abstarct Method
    public double calcPayment() {
        return 0;
    }

}