package org.example;

public class MortageCalculator {

    public static double calculateMaxloan(double yearlyIncome, double studieschuld)
    {
        double maxloan = yearlyIncome * 4.25;

        if(studieschuld > 0) {
            maxloan *= 0.75;
        }
        return maxloan;
    }


    public static double caculateMonthlyIntrest(double loanAmount, double annualInterestRate)
    {
        double monthlyInterestRate = (annualInterestRate / 100 ) / 12;
        return loanAmount * monthlyInterestRate;
    }

    public static double calulateMonthlyRepayment(double loanAmount) {
        int totalMonths = 30 * 12;
        return loanAmount / totalMonths;
    }

}
