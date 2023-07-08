public class PhysicalDesign extends DesignService {
    private int physicalType;
    private boolean printing;
    private int numCopy;

    // normal constructor
    public PhysicalDesign(String custName, double deposit, boolean urgentOrder, int physicalType, boolean printing,
            int numCopy) {
        super(custName, deposit, urgentOrder);
        this.physicalType = physicalType;
        this.printing = printing;
        this.numCopy = numCopy;
    }

    // getter and setter

    public int getPhysicalType() {
        return this.physicalType;
    }

    public void setPhysicalType(int physicalType) {
        this.physicalType = physicalType;
    }

    public boolean isPrinting() {
        return this.printing;
    }

    public boolean getPrinting() {
        return this.printing;
    }

    public void setPrinting(boolean printing) {
        this.printing = printing;
    }

    public int getNumCopy() {
        return this.numCopy;
    }

    public void setNumCopy(int numCopy) {
        this.numCopy = numCopy;
    }

    // printer
    public String toString() {
        return super.toString() + "\nPhysical Type: " + physicalType + "\nPrinting: " + printing + "\nNumber of Copy: "
                + numCopy;

    }

    // Abstract method
    public double calcPayment() {
        double payment = 0;
        if (physicalType == 1 || physicalType == 2)
            payment = 250;
        else if (physicalType == 3)
            payment = 150;
        else if (physicalType == 4)
            payment = 100;

        if (printing) {
            if (physicalType == 1)
                payment += 40 * numCopy;
            else if (physicalType == 2)
                payment += 10 * numCopy;
            else if (physicalType == 3)
                payment += 35 * numCopy;
            else if (physicalType == 4)
                payment += 3 * numCopy;

        }
        if (super.isUrgentOrder())
            payment = payment + 50;

        payment = payment - super.getDeposit();

        return payment;
    }
}