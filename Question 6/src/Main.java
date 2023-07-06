import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner strInput = new Scanner(System.in);
        Scanner intInput = new Scanner(System.in);

        System.out.print("Enter number of order: ");
        int orderNum = intInput.nextInt();

        DesignService[] ds = new DesignService[orderNum];

        for (int i = 0; i < orderNum; i++) {
            System.out.print("Enter Customer Name: ");
            String custName = strInput.nextLine();
            System.out.print("Enter amount of deposit (RM): ");
            double deposit = intInput.nextDouble();
            System.out.println("Is this an urgent order? (true/false): ");
            boolean urgentOrder = intInput.nextBoolean();

            System.out.print("1. Physical Design\n2. Digital Design\nEnter your choice: ");
            int choice = intInput.nextInt();

            if (choice == 1) {
                System.out.print("1. Banner\n2. Brochure\n3. Poster\n4. BusinessCard\nEnter your choice: ");
                int physicalType = intInput.nextInt();
                System.out.print("Enter Printing (true/false): ");
                boolean print = intInput.nextBoolean();
                System.out.print("Enter number of copy: ");
                int copy = intInput.nextInt();

                ds[i] = new PhysicalDesign(custName, deposit, urgentOrder, physicalType, print, copy);
            } else if (choice == 2) {
                System.out.print("Enter Digital Type: ");
                int digitalType = intInput.nextInt();

                ds[i] = new DigitalDesign(custName, deposit, urgentOrder, digitalType);
            }

        }
        System.out.println("Details of Physical Design order:\n\n");
        for (int i = 0; i < orderNum; i++) {
            if (ds[i] instanceof PhysicalDesign)
                System.out.println(ds[i].toString() + "\nPAyment: RM" + ds[i].calcPayment());
        }

        int count = 0;
        for (int i = 0; i < orderNum; i++) {
            if (ds[i] instanceof DigitalDesign) {
                DigitalDesign dd = (DigitalDesign) ds[i];
                if (dd.getdigitalType() == 1)
                    count++;
            }

        }

        System.out.print("the number of urgent orders for the website design: " + count);

        intInput.close();
        strInput.close();
    }

}