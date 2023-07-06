public class TailorService extends Service {
    private int type; // 1- baju kurung, 2 - baju melayu, 3 - others

    public TailorService(String serviceDate, int type) {
        super(serviceDate);
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double calcCharge() {
        double charge = 0.0;
        switch (type) {
            case 1:
                charge = 65.00;
                break;
            case 2:
                charge = 90.00;
                break;
            case 3:
                charge = 50.00;
                break;
            default:
                charge = 0.0;
                break;
        }
        return charge;
    }

    public String toString() {
        return super.toString() + "\nType: " + this.type;
    }
}