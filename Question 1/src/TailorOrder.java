public abstract class TailorOrder{
    private String custName;
    private String orderNum;
    private double deposit;
    private boolean delivery;

    public TailorOrder(String custName, String orderNum, double deposit, boolean delivery){
        this.custName = custName;
        this.orderNum = orderNum;
        this.deposit = deposit;
        this.delivery = delivery;
    }


    public String getCustName() {
        return this.custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getOrderNum() {
        return this.orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public double getDeposit() {
        return this.deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public boolean isDelivery() {
        return this.delivery;
    }

    public boolean getDelivery() {
        return this.delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public abstract double payment();
}