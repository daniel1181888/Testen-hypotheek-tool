package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int rentevaste = 0;
        String Partner;
        int postcode = 0;
        int MaandInkomen = 0;
        int studieschuld = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Vul je maand inkomen in: ");

            try {
                MaandInkomen = scanner.nextInt();
                System.out.println("U heeft een geldig maandinkomen ingevoerd: " + MaandInkomen);
                break;
            } catch (Exception e) {
                System.out.println("Ongeldige invoer. Voer alstublieft een geldig geheel getal in.");
                scanner.next();  // Clear the invalid input
            }
        }

        while (true) {
            System.out.print("rentevaste periode (1, 5, 10, 20, 30): ");
            rentevaste = scanner.nextInt();


            scanner.nextLine();

            if (rentevaste == 1 || rentevaste == 5 || rentevaste == 10 ||
                    rentevaste == 20 || rentevaste == 30) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 1, 5, 10, 20, or 30.");
            }
        }

        while (true) {
            System.out.print("Heeft u een partner? ja/nee");

            Partner = scanner.nextLine();
            Partner = Partner.toLowerCase();

            if (Partner.equals("ja")) {
                System.out.println("Opgeslagen antwoord:" + Partner);
                break;
            } else if (Partner.equals("nee")) {
                System.out.println("Opgeslagen antwoord:" + Partner);
                break;
            } else {
                System.out.println("Ongeldig antwoord");
            }

        }

        while (true) {
            System.out.print("Vul je studieschuld in: ");

            try {
                studieschuld = scanner.nextInt();
                System.out.println("U heeft een geldig studie inkomen ingevoerd: " + studieschuld);
                break;
            } catch (Exception e) {
                System.out.println("Ongeldige invoer. Voer alstublieft een geldig geheel getal in.");
                scanner.next();  // Clear the invalid input
            }
        }

        while (true) {
            System.out.print("Vul je Postcode in 9679, 9681 of 9682 niet geaccepteerd: ");
            postcode = scanner.nextInt();
            scanner.nextLine();

            if (postcode == 9679 || postcode == 9681 || postcode == 9682) {
                System.out.println("9679, 9681 of 9682 niet geaccepteerd");
            } else {
                break;
            }
        }




        System.out.println("MaandInkomen is: " + MaandInkomen);
        System.out.println("Postcode is: " + postcode);
        System.out.println("rentevaste is: " + rentevaste);
        System.out.println("Beschik je over een parter is: " + Partner);

        double yearlyIncome = MaandInkomen * 12;
        if (Partner.equals("ja")) {
            yearlyIncome *= 2;
        }

        double maxLoan = MortageCalculator.calculateMaxloan(yearlyIncome, studieschuld);
        double monthlyInterest = MortageCalculator.caculateMonthlyIntrest(maxLoan, rentevaste);
        double monthlyRepayment = MortageCalculator.calulateMonthlyRepayment(maxLoan);

        System.out.println("Maximaal lenen " + maxLoan);
        System.out.println("Maandelijkse intrest " + monthlyInterest);
        System.out.println("maandelijkse betaling " + monthlyRepayment);


    }
}