public class BajuKurung extends TailorOrder{
    private int type;
    private boolean embroidery;

    public BajuKurung(String custName, String orderNum, double deposit, boolean delivery, int type, boolean embroidery){
        super(custName, orderNum, deposit, delivery);
        this.type = type;
        this.embroidery = embroidery;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public boolean isEmbroidery() {
        return this.embroidery;
    }

    public boolean getEmbroidery() {
        return this.embroidery;
    }

    public void setEmbroidery(boolean embroidery) {
        this.embroidery = embroidery;
    }

    public double addEmbroidery(){
        if (embroidery){
            return 25.00;
        }
        else{
            return 0.00;
        }
    }

    public double payment(){
        double price = 0.00;
        switch(type){
            case 1:
                price = 30.00;
                break;
            case 2:
                price = 60.00;
                break;
            case 3:
                price = 55.00;
                break;
            case 4:
                price = 110.00;
                break;
        }

        return price + addEmbroidery();
    }

    public String toString(){
        return String.format("Customer Name: %s\nOrder Number: %s\nDeposit: RM%.2f\nDelivery: %b\nType: %d\nEmbroidery: %b\n", getCustName(), getOrderNum(), getDeposit(), getDelivery(), getType(), getEmbroidery());
    }
}