import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);

        System.out.println("Enter number of services: ");
        int numService = intScan.nextInt();
        Service[] serve = new Service[numService];

        for (int i = 0; i < numService; i++) {
            System.out.print("Enter service date: ");
            String serviceDate = strScan.nextLine();

            System.out.print("Enter type of service (1 - Tailor, 2 - Cleaning): ");
            int type = intScan.nextInt();

            if (type == 1) {
                System.out.print("Enter type of tailor (1 - Baju Kurung, 2 - Baju Melayu, 3 - Others): ");
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

        }

        // info cleaning service more than 10 hours
        System.out.println("\nCleaning Service more than 10 hours:");
        for (int i = 0; i < numService; i++) {
            if (serve[i] instanceof CleaningService) {
                if (((CleaningService) serve[i]).getHoursWorked() > 10) {
                    System.out.println(serve[i].toString());
                }
            }
        }

        // display total charges of all services
        double totalCharge = 0.0;
        for (int i = 0; i < numService; i++) {
            totalCharge += serve[i].calcCharge();
        }

        System.out.println("\nTotal charges of all services: RM" + totalCharge);

        intScan.close();
        strScan.close();
    }
}