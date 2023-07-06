import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner strInput = new Scanner(System.in);
        Scanner intInput = new Scanner(System.in);

        // Declare array of object
        System.out.print("Enter number of order: ");
        int orderNum = intInput.nextInt();

        DesignService[] ds = new DesignService[orderNum];

        // Step 2; input
        for (int i = 0; i < orderNum; i++) {
            System.out.print("Enter Customer Name: ");
            String cn = strInput.nextLine();
            System.out.print("Enter Deposit: RM");
            double dp = strInput.nextDouble();
            System.out.print("Enter Urgent order(true/false) :");
            boolean uo = strInput.nextBoolean();

            // ask for optiobn 1- physicalDesign or 2- digitalDesign
            System.out.print("Enter Design Type (1-Physical/2-Digital): ");
            int choice = intInput.nextInt();

            if (choice == 1) {
                // input specific
                System.out.print("Enter Physical Type(1-Banner/2-Brochure/3-Poster/4-BusinessCArd):");
                int pt = intInput.nextInt();
                System.out.print("Enter Printing(true/false)");
                boolean print = intInput.nextBoolean();
                System.out.print("Enter number of Copy: ");
                int copy = intInput.nextInt();

                // step 3;Store into objects
                ds[i] = new PhysicalDesign(cn, dp, uo, pt, print, copy);
            } else {
                System.out.print("Enter Digital Type: ");
                int dt = intInput.nextInt();

                ds[i] = new DigitalDesign(cn, dp, uo, dt);
            }

        }
        // manipulation
        // -i)
        System.out.print("Details of Physical Design order:\n\n");
        for (int i = 0; i < orderNum; i++) {
            if (ds[i] instanceof PhysicalDesign)
                System.out.println(ds[i].toString() + "\nPAyment: RM" + ds[i].calcPayment());
        }
        // -ii)
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