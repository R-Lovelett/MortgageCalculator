import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double monthlyRate; //Final monthly mortgage payment
        int principalAmount; //initial loan amount
        double interestRate; //Annual interest rate in % form
        int loanLength; //length of loan in years

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Principal Loan Amount: ");
        principalAmount = scanner.nextInt();
        System.out.print("Enter an Annual Interest Rate %: ");
        interestRate = scanner.nextDouble();
        System.out.print("Enter length of loan in yrs: ");
        loanLength = scanner.nextInt();

        //System.out.println(principalAmount + ", " + interestRate + ", " + loanLength);
        monthlyRate = calculateMonthlyRate(principalAmount, interestRate, loanLength);

        System.out.println("Monthly Payment: " + NumberFormat.getCurrencyInstance().format(monthlyRate));
    }

    public static double calculateMonthlyRate(int principal, double interest, int years) {
        double monthlyRate;
        double decimalRate = (interest / 100) / 12;
        double mathAmount = 1 + decimalRate;
        int monthLoanLength = years * 12;

        monthlyRate = principal * ((decimalRate * Math.pow(mathAmount, monthLoanLength)) / (Math.pow(mathAmount, monthLoanLength) - 1));

        return monthlyRate;
    }
}