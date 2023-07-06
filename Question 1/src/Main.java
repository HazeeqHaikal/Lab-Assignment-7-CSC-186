import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner strScan = new Scanner(System.in);
        Scanner intScan = new Scanner(System.in);

        System.out.print("Enter total customer: ");
        int totalCustomer = intScan.nextInt();

        BajuMelayu bajuMelayu[] = new BajuMelayu[totalCustomer];
        BajuKurung bajuKurung[] = new BajuKurung[totalCustomer];

        // initialize array with empty values
        for (int i = 0; i < totalCustomer; i++) {
            bajuMelayu[i] = new BajuMelayu("", "", 0.00, false, 0);
            bajuKurung[i] = new BajuKurung("", "", 0.00, false, 0, false);
        }

        for (int i = 0; i < totalCustomer; i++) {
            System.out.print("Enter customer " + (i + 1) + " name: ");
            String custName = strScan.nextLine();

            System.out.print("Enter order number: ");
            String orderNum = strScan.nextLine();

            System.out.print("Enter deposit (RM): ");
            double deposit = intScan.nextDouble();

            System.out.print("Delivery (Y/N): ");
            char delivery = strScan.nextLine().charAt(0);
            boolean isDelivery = false;
            switch (delivery) {
                case 'Y':
                    isDelivery = true;
                    break;
            }

            System.out.print("1. Baju Melayu\n2. Baju Kurung\nChoose type of baju: ");
            int type = intScan.nextInt();
            if (type == 1) {
                System.out.print(
                        "1. Baju Melayu Cekak Musang (RM 75.00)\n2. Baju Melayu Teluk Belanga (RM 95.00)\nChoose type of Baju Melayu: ");
                int bajuMelayuType = intScan.nextInt();
                bajuMelayu[i] = new BajuMelayu(custName, orderNum, deposit, isDelivery, bajuMelayuType);
            } else if (type == 2) {
                System.out.print(
                        "1. Baju Kurung Pahang\n2. Baju Kurung Kedah\n3. Baju Kurung Johor\n4. Baju Kurung Kelantan\nChoose type of Baju Kurung: ");
                int bajuKurungType = intScan.nextInt();
                System.out.print("Embroidery (Y/N): ");
                char embroidery = strScan.nextLine().charAt(0);
                boolean isEmbroidery = false;
                switch (embroidery) {
                    case 'Y':
                        isEmbroidery = true;
                        break;
                }
                bajuKurung[i] = new BajuKurung(custName, orderNum, deposit, isDelivery, bajuKurungType, isEmbroidery);
            } else {
                System.out.println("Invalid input");

            }

            System.out.print("Do you want to continue (Y/N): ");
            char choice = strScan.nextLine().charAt(0);
            choice = Character.toUpperCase(choice);

            if (choice == 'N') {
                break;
            }
        }

        // Calculate and display the number of customer order for Baju Kurung with
        // embroidery
        int totalBajuKurungEmbroidery = 0;
        for (int i = 0; i < totalCustomer; i++) {
            if (bajuKurung[i].getEmbroidery()) {
                totalBajuKurungEmbroidery++;
            }
        }

        System.out.println("Total Baju Kurung with embroidery: " + totalBajuKurungEmbroidery);

        // Calculate an display payment for each order. If the customer requests
        // delivery, add RM 5.00 to the payment, Calculate and display the total payment
        // for all orders.
        double totalPayment = 0.00;
        for (int i = 0; i < totalCustomer; i++) {
            // if baju melayu does not has empty value from initialization
            if (!bajuMelayu[i].getCustName().equals("")) {

                // delivery charges
                if (bajuMelayu[i].getDelivery()) {
                    totalPayment += bajuMelayu[i].payment() + 5.00;
                } else {
                    totalPayment += bajuMelayu[i].payment();
                }

                System.out.println("Customer " + (i + 1) + " payment: RM " + totalPayment);
            }

            // if baju kurung does not has empty value from initialization
            if (!bajuKurung[i].getCustName().equals("")) {
                if (bajuKurung[i].getDelivery()) {
                    totalPayment += bajuKurung[i].payment() + 5.00;
                } else {
                    totalPayment += bajuKurung[i].payment();
                }

                System.out.println("Customer " + (i + 1) + " payment: RM " + totalPayment);
            }

        }
    }
}