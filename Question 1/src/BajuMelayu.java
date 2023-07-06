public class BajuMelayu extends TailorOrder{
    private int type;

    public BajuMelayu(String custName, String orderNum, double deposit, boolean delivery, int type){
        super(custName, orderNum, deposit, delivery);
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double payment(){
        double price = 0.00;
        switch(type){
            case 1:
                price = 75.00;
                break;
            case 2:
                price = 95.00;
                break;
        }

        return price;
    }
}