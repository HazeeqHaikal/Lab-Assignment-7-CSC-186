import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);

        System.out.print("Enter number of services: ");
        int numService = intScan.nextInt();
        Service[] serve = new Service[numService];

        System.out.println();
        for (int i = 0; i < numService; i++) {
            System.out.print("Enter service date (example: 1/1/2021): ");
            String serviceDate = strScan.nextLine();

            System.out.print("\n1. Tailor\n2. Cleaning\nEnter your choice: ");
            int type = intScan.nextInt();

            if (type == 1) {
                System.out.print("\n1. Baju Kurung\n2. Baju Melayu\n3. Others\nEnter your choice: ");
                int tailorType = intScan.nextInt();
                serve[i] = new TailorService(serviceDate, tailorType);
            } else if (type == 2) {
                System.out.print("Enter number of hours worked: ");
                int hoursWorked = intScan.nextInt();
                System.out.print("Enter number of cleaner: ");
                int numCleaner = intScan.nextInt();
                serve[i] = new CleaningService(serviceDate, hoursWorked, numCleaner);
            } else {
                System.out.println("Invalid type of service.");
            }

            System.out.println();
        }

        // info cleaning service more than 10 hours
        String output = "\n\nCleaning Service more than 10 hours:\n";
        boolean found = false;
        for (int i = 0; i < numService; i++) {
            if (serve[i] instanceof CleaningService) {
                if (((CleaningService) serve[i]).getHoursWorked() > 10) {
                    output += serve[i].toString() + "\n";
                    found = true;
                }
            }
        }

        if (found) {
            System.out.print(output);
        } else {
            System.out.print("No cleaning service more than 10 hours.");
        }

        // display total charges of all services
        double totalCharge = 0.0;
        for (int i = 0; i < numService; i++) {
            totalCharge += serve[i].calcCharge();
        }

        System.out.printf("\n\nTotal charges of all services: RM%.2f", totalCharge);

        intScan.close();
        strScan.close();
    }
}