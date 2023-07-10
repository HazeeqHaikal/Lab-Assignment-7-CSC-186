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
            System.out.println("Is this an urgent order? (Y/N): ");
            char urgentOrderChoice = strInput.next().charAt(0);
            urgentOrderChoice = Character.toUpperCase(urgentOrderChoice);
            boolean urgentOrder = false;
            if (urgentOrderChoice == 'Y')
                urgentOrder = true;

            System.out.print("1. Physical Design\n2. Digital Design\nEnter your choice: ");
            int choice = intInput.nextInt();

            if (choice == 1) {
                System.out.print("1. Banner\n2. Brochure\n3. Poster\n4. BusinessCard\nEnter your choice: ");
                int physicalType = intInput.nextInt();
                System.out.print("Enter Printing (Y/N): ");
                char printChoice = strInput.next().charAt(0);
                printChoice = Character.toUpperCase(printChoice);
                boolean print = false;

                int copy = 0;
                if (printChoice == 'Y') {
                    print = true;
                    System.out.print("Enter number of copy: ");
                    copy = intInput.nextInt();
                }

                ds[i] = new PhysicalDesign(custName, deposit, urgentOrder, physicalType, print, copy);
            } else if (choice == 2) {
                System.out.print("1. Website\n2. Advertisement\nEnter your choice: ");
                int digitalType = intInput.nextInt();

                ds[i] = new DigitalDesign(custName, deposit, urgentOrder, digitalType);
            }

        }
        String details = "Details of Physical Design order:\n\n";
        boolean print = false;
        for (int i = 0; i < orderNum; i++) {
            if (ds[i] instanceof PhysicalDesign) {
                details += ds[i].toString() + "\nPayment: RM" + ds[i].calcPayment() + "\n\n";
                print = true;
            }
        }

        if (print)
            System.out.println(details);
        else
            System.out.println("No Physical Design order");

        int count = 0;
        for (int i = 0; i < orderNum; i++) {
            if (ds[i] instanceof DigitalDesign) {
                DigitalDesign dd = (DigitalDesign) ds[i];
                if (dd.isUrgentOrder() && dd.getDigitalType() == 1)
                    count++;
            }

        }

        if (count == 0)
            System.out.print("No urgent orders for the website design");
        else
            System.out.print("The number of urgent orders for the website design: " + count);

        intInput.close();
        strInput.close();
    }

}