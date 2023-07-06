public class CleaningService extends Service {
    private int hoursWorked;
    private int numCleaner;

    // normal constructor
    public CleaningService(String serviceDate, int hoursWorked, int numCleaner) {
        super(serviceDate);
        this.hoursWorked = hoursWorked;
        this.numCleaner = numCleaner;
    }

    // getter and setter
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getNumCleaner() {
        return this.numCleaner;
    }

    public void setNumCleaner(int numCleaner) {
        this.numCleaner = numCleaner;
    }

    public double calcCharge() {
        return hoursWorked * numCleaner * 7;
    }

    public String toString() {
        return super.toString() + "\nHours Worked: " + this.hoursWorked + "\nNumber of Cleaner: " + this.numCleaner;
    }
}
