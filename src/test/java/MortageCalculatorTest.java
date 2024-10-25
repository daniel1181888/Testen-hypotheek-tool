import org.junit.jupiter.api.Test;

import static org.example.MortageCalculator.*;
import static org.junit.jupiter.api.Assertions.*;

public class MortageCalculatorTest {

    @Test

    public void calculateMaxloanTest() {
        // Tloan amount = 2000, studieschuld = 0 x 4,25 zelfde wat gebeurt in de calculateMaxloan methode
        double expected = 2000 * 4.25;
        // Berekening maken met methode calculateMaxloan
        double actual = calculateMaxloan(2000,0);
        // expected vergelijken met actual resulaten vergelijken
        assertEquals(expected, actual);
    }

    @Test

    public void calculateMonthlyInterestTest() {

        //loan amount = 2000, annual interest rate = 5%
        double loanAmount = 2000;
        double annualInterestRate = 5.0;

        // Verwachting. Berekening die de methode uitvoert
        double expected = loanAmount * (annualInterestRate / 100) / 12;

        // De methode uitvoeren om te kijken naar het resultaat
        double actual = caculateMonthlyIntrest(loanAmount, annualInterestRate);

        // vergelijken
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void calculateMonthlyRepaymentTest() {

        //loan amount = 120,000
        double loanAmount = 120000;

        // Berkenening doen die de methode zelf doet
        int totalMonths = 30 * 12;
        double expected = loanAmount / totalMonths;

        // De methode zelf gebruiken
        double actual = calulateMonthlyRepayment(loanAmount);

        // rersultaat vergelijken
        assertEquals(expected, actual, 0.0001);
    }
}
