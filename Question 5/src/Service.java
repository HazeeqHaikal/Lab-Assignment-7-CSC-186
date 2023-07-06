public abstract class Service {
    protected String serviceDate; // ddmmyyyy

    // default constructor
    public Service() {
        this.serviceDate = "01012000";
    }

    // normal constructor
    public Service(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    // getter and setter

    public String getServiceDate() {
        return this.serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public abstract double calcCharge();

    // toString
    public String toString() {
        return "Service Date: " + this.serviceDate;
    }

}